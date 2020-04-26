package space.program.model;

import java.util.UUID;

import static java.lang.String.format;

public class Order {
    private final OrderType orderType;
    private final String agencyName;
    private final UUID id;

    public Order(OrderType orderType, String agencyName, UUID id) {
        this.orderType = orderType;
        this.agencyName = agencyName;
        this.id = id;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public String getDescription() {
        return format("Order type: %s. Agency name: %s. Order id: %s",
                orderType,
                agencyName,
                id);
    }
}
