package space.program.model;

import java.util.UUID;

import static java.lang.String.format;

public class OrderConfirmation {
    private final UUID carrierId;
    private final Order order;

    public OrderConfirmation(UUID carrierId, Order order) {
        this.carrierId = carrierId;
        this.order = order;
    }

    public String getDescription() {
        return format("Carrier: %s handled order: \"%s\"",
                carrierId,
                order.getDescription());
    }
}
