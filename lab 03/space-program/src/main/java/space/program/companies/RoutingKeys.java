package space.program.companies;

public class RoutingKeys {
    public static final String ALL = "space";
    public static final String AGENCY_ALL = "space.agency";
    public static final String CARRIER_ALL = "space.carrier";
    public static final String ADMIN = "space#";

    public static String singleAgency(String agencyName) {
        return AGENCY_ALL + "." + agencyName;
    }

    public static String singleOrder(String orderType) {
        return CARRIER_ALL + "." + orderType;
    }
}
