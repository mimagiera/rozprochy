package smartHouse.server.devices.thermometer;

import SmartHouseModule.Thermometer;
import SmartHouseModule.WeatherState;
import com.zeroc.Ice.Current;
import smartHouse.server.devices.CommonSmartDevice;

import java.util.Arrays;
import java.util.logging.Logger;

public abstract class CommonThermometer extends CommonSmartDevice implements Thermometer {
    private static final Logger logger = Logger.getLogger(CommonThermometer.class.getName());

    private int currentTemperature;

    private WeatherState[] weatherStates = new WeatherState[]{WeatherState.SUNNY, WeatherState.WINDY};

    protected CommonThermometer(String name, int currentTemperature) {
        super(name, logger);
        this.currentTemperature = currentTemperature;
    }

    @Override
    public int getTemperature(Current current) {
        logger.info("Temperature requested: " + currentTemperature);
        return currentTemperature;
    }

    @Override
    public WeatherState[] getWeatherStates(Current current) {
        logger.info("Weather states requested: " + Arrays.toString(weatherStates));
        return weatherStates;
    }
}
