package space.program;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.program.companies.Agency;
import space.program.model.OrderType;

import java.io.IOException;
import java.util.Scanner;

import static space.program.utils.Utils.possibleServicesNames;

public class AgencyController {
    static Logger logger = LoggerFactory.getLogger(AgencyController.class);

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        logger.info("Enter agency name");
        String agencyName = input.nextLine();
        Agency agency = new Agency(agencyName);

        logger.info("Enter order type or it's number starting from 1: {}.", possibleServicesNames());
        String orderType;
        while ((orderType = input.nextLine()) != null) {
            switch (orderType) {
                case "PLACE_SATELLITE":
                case "1":
                    agency.createOrder(OrderType.PLACE_SATELLITE);
                    break;
                case "TRANSPORT_PEOPLE":
                case "2":
                    agency.createOrder(OrderType.TRANSPORT_PEOPLE);
                    break;
                case "TRANSPORT_CARGO":
                case "3":
                    agency.createOrder(OrderType.TRANSPORT_CARGO);
                    break;
                default:
                    logger.warn("Order type + " + orderType + " not found");
                    break;
            }
        }
    }
}
