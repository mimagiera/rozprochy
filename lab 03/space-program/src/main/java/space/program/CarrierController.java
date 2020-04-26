package space.program;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.program.companies.Carrier;
import space.program.model.OrderType;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static space.program.utils.Utils.fromStringOrNumber;
import static space.program.utils.Utils.possibleServicesNames;

public class CarrierController {
    static Logger logger = LoggerFactory.getLogger(CarrierController.class);
    private static final int NUMBER_OF_SERVICES = 2;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        logger.info("Enter {} types of services or its' numbers starting from 1. Possible are: {}.", NUMBER_OF_SERVICES, possibleServicesNames());
        List<OrderType> orderTypes = new LinkedList<>();
        for (int i = 0; i < NUMBER_OF_SERVICES; i++) {
            logger.info("Enter order type nr {}", i + 1);
            String orderArgument = input.nextLine();
            try {
                OrderType orderType = fromStringOrNumber(orderArgument);
                if (!orderTypes.contains(orderType)) {
                    orderTypes.add(orderType);
                } else {
                    logger.error("Order type {} is already handled by this carrier. Try another one", orderType);
                    i--;
                }
            } catch (IllegalArgumentException e) {
                logger.error("Order type {} not found. Please try again.", orderArgument);
                i--;
            }
        }
        Carrier carrier = new Carrier(orderTypes);
        logger.info("Starting carrier with id: {}", carrier.getId());
        carrier.startCarrier();
    }

}
