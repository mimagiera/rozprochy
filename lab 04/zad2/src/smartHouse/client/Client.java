package src.sr.ice.client;

import SmartHouseModule.FridgePrx;
import SmartHouseModule.SmartTvPrx;
import SmartHouseModule.ThermometerPrx;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.LocalException;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.Util;

import java.util.Map;

public class Client {

        private static Map<String, String> deviceToIdentity = Map.of("veryGoodTv", "smartTv/veryGoodTv",
                "veryBadTv", "smartTv/veryBadTv",
                "basicFridge", "smartTv/basicFridge",
                "basicThermometer", "smartTv/basicThermometer");

    static String getDeviceProxy(String device) {
        return deviceToIdentity.get(device) + ":tcp -h localhost -p 10000";
    }

    private static ObjectPrx getObjProxy(Communicator communicator, String deviceName) {
        return communicator.stringToProxy(getDeviceProxy(deviceName));
    }

    public static void main(String[] args) {
        int status = 0;
        Communicator communicator = null;

        try {
            communicator = Util.initialize(args);
            SmartTvPrx veryGoodTv = SmartTvPrx.checkedCast(getObjProxy(communicator, "veryGoodTv"));
            SmartTvPrx veryBadTv = SmartTvPrx.checkedCast(getObjProxy(communicator, "veryBadTv"));
            FridgePrx basicFridge = FridgePrx.checkedCast(getObjProxy(communicator, "basicFridge"));
            ThermometerPrx basicThermometer = ThermometerPrx.checkedCast(getObjProxy(communicator, "basicThermometer"));

            if (veryGoodTv == null) throw new Error("Invalid proxy");

            String line = null;
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            do {
                try {
                    System.out.print("==> ");
                    System.out.flush();
                    line = in.readLine();

                    if (line == null) {
                        break;
                    } else if (line.equals("goodTv")) {
                        String goodTvName = veryGoodTv.getName();
                        System.out.println(goodTvName);
                    } else if (line.equals("badTv")) {
                        String veryBadTvName = veryBadTv.getName();
                        System.out.println(veryBadTvName);
                    } else if (line.equals("therm")) {
                        String basicThermometerName = basicThermometer.getName();
                        System.out.println(basicThermometerName);
                    } else if (line.equals("fridge")) {
                        String basicFridgeName = basicFridge.getName();
                        System.out.println(basicFridgeName);
                    }


                } catch (java.io.IOException ex) {
                    ex.printStackTrace();
                }
            }
            while (!line.equals("x"));


        } catch (LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        }
        if (communicator != null) {
            // Clean up
            //
            try {
                communicator.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
        }
        System.exit(status);
    }


}