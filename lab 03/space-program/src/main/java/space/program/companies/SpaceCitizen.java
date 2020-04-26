package space.program.companies;

import com.rabbitmq.client.*;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeoutException;

public abstract class SpaceCitizen {
    public static final String EXCHANGE_NAME = "spaceExchange";
    public static final String HOSTNAME = "localhost";
    protected final Connection connection;
    protected final Channel publishChannel;

    SpaceCitizen() {
        connection = createConnection();
        publishChannel = createPublishChannel();
    }

    private Connection createConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOSTNAME);
        try {
            return factory.newConnection();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Channel createPublishChannel() {
        Channel channel = null;
        try {
            channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
            channel.basicQos(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return channel;
    }

    protected Thread consumeInfo(String queueName, List<String> routingKeys, Logger logger) {
        return new Thread(() -> {
            try {
                Channel channel = connection.createChannel();
                channel.queueDeclare(queueName, false, false, true, null);
                routingKeys.forEach(routingKey -> {
                    try {
                        channel.queueBind(queueName, EXCHANGE_NAME, routingKey);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                Consumer consumer = createInfoConsumer(channel, logger);
                channel.basicConsume(queueName, false, consumer);
                channel.basicQos(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private Consumer createInfoConsumer(Channel channel, Logger logger) {
        return new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                channel.basicAck(envelope.getDeliveryTag(), false);
                logger.info("Received (exchange: {}, topic: {}): {}",
                        envelope.getExchange(),
                        envelope.getRoutingKey(),
                        message);
            }
        };
    }
}
