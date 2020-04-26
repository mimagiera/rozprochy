package space.program.companies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.program.model.Order;
import space.program.model.OrderType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

import static space.program.companies.RoutingKeys.*;
import static space.program.utils.Utils.orderToJson;

public class Agency extends SpaceCitizen {
    Logger logger = LoggerFactory.getLogger(Agency.class);

    private final String name;

    public Agency(String name) {
        this.name = name;
        consumeInfo().start();
    }

    private Thread consumeInfo() {
        String queueName = "SPACE.AFENCY." + name;
        return super.consumeInfo(queueName, List.of(singleAgency(this.name), AGENCY_ALL, ALL), logger);
    }

    public void createOrder(OrderType orderType) throws IOException {
        var order = new Order(orderType, name, UUID.randomUUID());
        String message = orderToJson(order);
        logger.info("Agency: {} is sending order: \"{}\"",
                name,
                order.getDescription());
        publishChannel.basicPublish(EXCHANGE_NAME, RoutingKeys.singleOrder(orderType.toString()), null, message.getBytes(StandardCharsets.UTF_8));
    }
}
