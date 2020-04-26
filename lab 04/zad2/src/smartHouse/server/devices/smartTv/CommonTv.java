package smartHouse.server.devices.smartTv;

import SmartHouseModule.RangeError;
import SmartHouseModule.SmartTv;
import com.zeroc.Ice.Current;
import smartHouse.server.devices.CommonSmartDevice;

import java.util.logging.Logger;

public abstract class CommonTv extends CommonSmartDevice implements SmartTv {
    private static final Logger logger = Logger.getLogger(CommonTv.class.getName());

    private final int maxChannel;

    private int currentChannel = 1;

    protected CommonTv(int maxChannel, String name) {
        super(name, logger);
        this.maxChannel = maxChannel;
    }

    @Override
    public boolean changeChannel(int channelNr, Current current) throws RangeError {
        if (channelNr > 0 && channelNr <= maxChannel) {
            currentChannel = channelNr;
            logger.info("New channel: " + channelNr);
            return true;
        }
        logger.severe("Bad channel nr: " + channelNr);
        throw new RangeError(0, maxChannel);
    }

    @Override
    public int getCurrentChannel(Current current) {
        logger.info("Channel nr requested: " + currentChannel);
        return currentChannel;
    }
}
