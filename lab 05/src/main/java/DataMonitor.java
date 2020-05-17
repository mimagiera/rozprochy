import org.apache.zookeeper.AsyncCallback.StatCallback;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.apache.zookeeper.KeeperException.Code.SESSIONEXPIRED;

public class DataMonitor implements Watcher, StatCallback {
    private static final Logger LOG = LoggerFactory.getLogger(DataMonitor.class);

    private final ZooKeeper zk;
    private final DataMonitorListener listener;
    private final String zNode;
    boolean dead;

    byte[] prevData;

    public DataMonitor(ZooKeeper zk, String zNode, DataMonitorListener listener) {
        this.zk = zk;
        this.zNode = zNode;
        this.listener = listener;
        zk.exists(zNode, true, this, null);
    }


    @Override
    public void process(WatchedEvent event) {
        String path = event.getPath();
        LOG.debug("Received event: {}", event);
        if (path != null) {
            handleNewChildren(path);
        }

        if (event.getType() == Event.EventType.None) {
            switch (event.getState()) {
                case SyncConnected:
                    LOG.info("Client connected");
                    break;
                case Expired:
                    dead = true;
                    listener.closing(SESSIONEXPIRED.intValue());
                    break;
            }
        } else {
            if (Objects.equals(path, zNode)) {
                zk.exists(zNode, true, this, null);
            }
        }
    }

    private void handleNewChildren(String path) {
        try {
            Stat nodeStat = zk.exists(path, true);
            if (nodeStat != null) {
                List<String> zkChildren = zk.getChildren(path, true);
                LOG.debug("Children of node {}: {}", path, zkChildren);
                LOG.info("Number of children of node \"{}\": {}", zNode, zk.getAllChildrenNumber(zNode));
                zkChildren.forEach(zNode -> {
                    try {
                        zk.getChildren(path + "/" + zNode, true);
                    } catch (KeeperException | InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        boolean exists;
        switch (Code.get(rc)) {
            case OK:
                exists = true;
                break;
            case NONODE:
                exists = false;
                break;
            case SESSIONEXPIRED, NOAUTH:
                dead = true;
                listener.closing(rc);
                return;
            default:
                zk.exists(zNode, true, this, null);
                return;
        }

        byte[] b = null;
        if (exists) {
            try {
                b = zk.getData(zNode, false, null);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        if ((b == null && null != prevData)
                || (b != null && !Arrays.equals(prevData, b))) {
            listener.exists(b);
            prevData = b;
        }
    }
}