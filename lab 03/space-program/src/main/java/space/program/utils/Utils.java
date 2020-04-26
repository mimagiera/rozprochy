package space.program.utils;

import com.google.gson.Gson;
import space.program.model.Order;
import space.program.model.OrderType;

import java.util.Arrays;

public class Utils {
    private static Gson gson = new Gson();

    public static String orderToJson(Order order) {
        return gson.toJson(order);
    }

    public static Order jsonToOrder(String json) {
        return gson.fromJson(json, Order.class);
    }

    public static String possibleServicesNames() {
        return Arrays.toString(OrderType.class.getEnumConstants());
    }

    public static OrderType fromStringOrNumber(String orderType) {
        return switch (orderType) {
            case "PLACE_SATELLITE", "1" -> OrderType.PLACE_SATELLITE;
            case "TRANSPORT_PEOPLE", "2" -> OrderType.TRANSPORT_PEOPLE;
            case "TRANSPORT_CARGO", "3" -> OrderType.TRANSPORT_CARGO;
            default -> throw new IllegalArgumentException();
        };
    }
}
