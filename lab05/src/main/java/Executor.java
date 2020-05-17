import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class Executor implements Watcher, Runnable, DataMonitorListener {
    private static final Logger LOG = LoggerFactory.getLogger(Executor.class);

    private final DataMonitor dataMonitor;
    private final String filename;
    private final String[] exec;
    private final String zNode;
    private Process process;
    private final ZooKeeper zooKeeper;

    public Executor(String connectionString, String zNode, String filename,
                    String[] exec) throws IOException {
        this.filename = filename;
        this.zNode = zNode;
        this.exec = exec;
        this.zooKeeper = new ZooKeeper(connectionString, 3000, this);
        this.dataMonitor = new DataMonitor(zooKeeper, zNode, this);
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            LOG.error("USAGE: Executor connectionString zNode filename program [args ...]");
            System.exit(2);
        }
        String connectionString = args[0];
        String zNode = args[1];
        String filename = args[2];
        String[] exec = new String[args.length - 3];
        System.arraycopy(args, 3, exec, 0, exec.length);
        try {
            Executor executor = new Executor(connectionString, zNode, filename, exec);
            executor.getTree().start();
            executor.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Thread getTree() {
        return new Thread(() -> {
            Scanner input = new Scanner(System.in);
            while (input.nextLine() != null) {
                Stat nodeStat = null;
                System.out.println(format("Tree for node %s: ", zNode));
                try {
                    nodeStat = zooKeeper.exists(zNode, true);
                } catch (KeeperException | InterruptedException ignored) {
                }
                if (nodeStat != null) {
                    listChildrenForPath(zNode);
                } else {
                    System.out.println(format("Node %s doesn't exist", zNode));
                }
            }
        });
    }

    private void listChildrenForPath(String path) {
        try {
            List<String> children = zooKeeper.getChildren(path, false);
            System.out.println(path);
            children.forEach(child -> listChildrenForPath(path + '/' + child));
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        dataMonitor.process(event);
    }


    @Override
    public void run() {
        try {
            synchronized (this) {
                while (!dataMonitor.dead) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closing(int rc) {
        synchronized (this) {
            notifyAll();
        }
    }

    @Override
    public void exists(byte[] data) {
        if (data == null) {
            killProcess();
            process = null;
        } else {
            killProcess();
            try (var fos = new FileOutputStream(filename)) {
                fos.write(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                LOG.info("Starting process");
                process = Runtime.getRuntime().exec(exec);
                printExecResult().start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void killProcess() {
        if (process != null) {
            LOG.info("Killing process");
            process.destroy();
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Thread printExecResult() {
        return new Thread(() -> {
            try {
                process.getInputStream().transferTo(System.out);
                if (process != null) {
                    process.getErrorStream().transferTo(System.err);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}