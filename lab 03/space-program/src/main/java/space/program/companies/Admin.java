package space.program.companies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static space.program.companies.RoutingKeys.*;

public class Admin extends SpaceCitizen {
    Logger logger = LoggerFactory.getLogger(Admin.class);

    public Admin() {
        consumeInfo().start();
    }

    private Thread consumeInfo() {
        String queueName = "ADMIN";
        return super.consumeInfo(queueName, List.of(ADMIN), logger);
    }

    public void sendToAllAgencies(String message) {
        sendMessage(message, AGENCY_ALL);
    }

    public void sendToAllCarriers(String message) {
        sendMessage(message, CARRIER_ALL);
    }

    public void sendToAll(String message) {
        sendMessage(message, ALL);
    }

    private void sendMessage(String message, String routingKey) {
        try {
            publishChannel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
