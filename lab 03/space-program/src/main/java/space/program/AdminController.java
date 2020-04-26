package space.program;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.program.companies.Admin;

import java.util.Scanner;

public class AdminController {
    static Logger logger = LoggerFactory.getLogger(AdminController.class);

    public static void main(String[] args) {
        Admin admin = new Admin();
        Scanner input = new Scanner(System.in);
        logger.info("Enter action type (agency, carrier or all)");
        String actionType;
        while ((actionType = input.nextLine()) != null) {
            logger.info("Enter message");
            String message = input.nextLine();
            switch (actionType) {
                case "agency":
                    admin.sendToAllAgencies(message);
                    break;
                case "carrier":
                    admin.sendToAllCarriers(message);
                    break;
                case "all":
                    admin.sendToAll(message);
                    break;
                default:
                    logger.warn("Action type + " + actionType + " not found");
                    break;
            }
        }
    }
}
