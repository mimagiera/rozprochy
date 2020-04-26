package smartHouse.server.devices.fridge;

public class BasicFridge extends CommonFridge {
    private static final String NAME = "BasicFridge";

    public BasicFridge() {
        super(NAME, 2, 8);
    }
}
