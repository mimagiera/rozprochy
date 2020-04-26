package space.program.companies;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.program.model.Order;
import space.program.model.OrderConfirmation;
import space.program.model.OrderType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

import static space.program.companies.RoutingKeys.ALL;
import static space.program.companies.RoutingKeys.CARRIER_ALL;
import static space.program.utils.Utils.jsonToOrder;

public class Carrier extends SpaceCitizen {
    Logger logger = LoggerFactory.getLogger(Carrier.class);

    public UUID getId() {
        return id;
    }

    private final UUID id = UUID.randomUUID();
    private final List<OrderType> availableServices;

    public Carrier(List<OrderType> services) {
        availableServices = services;
        consumeInfo().start();
    }

    private Thread consumeInfo() {
        String queueName = "SPACE.CARRIER." + id;
        return super.consumeInfo(queueName, List.of(CARRIER_ALL, ALL), logger);
    }

    public void startCarrier() throws IOException {
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        channel.basicQos(1);

        availableServices.forEach(serviceType -> {
            String queueName = serviceType.toString();
            try {
                channel.queueDeclare(queueName, false, false, true, null);
                channel.queueBind(queueName, EXCHANGE_NAME, RoutingKeys.singleOrder(queueName));

                channel.basicConsume(queueName, false, orderConsumer(channel));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    Consumer orderConsumer(Channel channel) {
        return new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                Order order = jsonToOrder(message);
                channel.basicAck(envelope.getDeliveryTag(), false);

                OrderConfirmation confirmation = new OrderConfirmation(id, order);
                String confirmationDescription = confirmation.getDescription();
                logger.info(confirmationDescription);

                sendConfirmationToAgency(order, confirmationDescription, channel);
            }
        };
    }

    private void sendConfirmationToAgency(Order order, String confirmationDescription, Channel channel) throws IOException {
        channel.basicPublish(EXCHANGE_NAME, RoutingKeys.singleAgency(order.getAgencyName()), null, confirmationDescription.getBytes());
    }
}
