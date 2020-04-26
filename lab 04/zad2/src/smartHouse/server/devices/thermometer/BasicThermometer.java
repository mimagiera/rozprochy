package smartHouse.server.devices.thermometer;

public class BasicThermometer extends CommonThermometer {
    private static final String NAME = "BasicThermometer";

    public BasicThermometer() {
        super(NAME, 5);
    }
}
