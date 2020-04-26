package smartHouse.server.devices.fridge;

import SmartHouseModule.Fridge;
import SmartHouseModule.RangeError;
import com.zeroc.Ice.Current;
import smartHouse.server.devices.CommonSmartDevice;

import java.util.logging.Logger;

public abstract class CommonFridge extends CommonSmartDevice implements Fridge {
    private static final Logger logger = Logger.getLogger(CommonFridge.class.getName());

    private final int min_temperature;
    private final int max_temperature;
    private int currentTemperature;

    protected CommonFridge(String name, int min_temperature, int max_temperature) {
        super(name, logger);
        this.min_temperature = min_temperature;
        this.max_temperature = max_temperature;
    }

    @Override
    public boolean setTemperature(int temperature, Current current) throws RangeError {
        if (temperature >= min_temperature && temperature <= max_temperature) {
            currentTemperature = temperature;
            logger.info("New temperature: " + temperature);
            return true;
        }
        logger.severe("Bad channel nr: " + temperature);
        throw new RangeError(min_temperature, max_temperature);
    }

    @Override
    public int getTemperature(Current current) {
        logger.info("Temperature requested: " + currentTemperature);
        return currentTemperature;
    }
}
