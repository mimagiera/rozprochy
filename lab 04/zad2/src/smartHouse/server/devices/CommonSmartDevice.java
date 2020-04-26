package smartHouse.server.devices;

import SmartHouseModule.SmartDevice;
import com.zeroc.Ice.Current;

import java.util.logging.Logger;

public abstract class CommonSmartDevice implements SmartDevice {
    private final String name;
    private final Logger logger;
    protected boolean status;

    protected CommonSmartDevice(String name, Logger logger) {
        this.name = name;
        this.logger = logger;
    }

    @Override
    public boolean getStatus(Current current) {
        logger.info("Status requested: " + status);
        return status;
    }

    @Override
    public boolean turnOn(Current current) {
        if (status) {
            logger.warning("Device already turned on");
            return false;
        }
        status = true;
        logger.info("Device turned on");
        return true;
    }

    @Override
    public boolean turnOff(Current current) {
        if (!status) {
            logger.warning("Device already turned off");
            return false;
        }
        status = false;
        logger.info("Device turned off");
        return true;
    }

    @Override
    public String getName(Current current) {
        logger.info("Name requested: " + name);
        return name;
    }
}
