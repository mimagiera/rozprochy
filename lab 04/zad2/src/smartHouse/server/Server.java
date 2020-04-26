package smartHouse.server;

import SmartHouseModule.Fridge;
import SmartHouseModule.SmartTv;
import SmartHouseModule.Thermometer;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import smartHouse.server.devices.fridge.BasicFridge;
import smartHouse.server.devices.smartTv.VeryBadTv;
import smartHouse.server.devices.smartTv.VeryGoodTv;
import smartHouse.server.devices.thermometer.BasicThermometer;

public class Server {
    public void t1() {
        int status = 0;
        Communicator communicator = null;

        try {
            communicator = Util.initialize();

            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter1", "tcp -h localhost -p 10000:udp -h localhost -p 10000");

            SmartTv veryGoodTv = new VeryGoodTv();
            SmartTv veryBadTv = new VeryBadTv();
            Fridge basicFridge = new BasicFridge();
            Thermometer basicThermometer = new BasicThermometer();

            adapter.add(veryGoodTv, new Identity("veryGoodTv", "smartTv"));
            adapter.add(veryBadTv, new Identity("veryBadTv", "smartTv"));
            adapter.add(basicFridge, new Identity("basicFridge", "fridge"));
            adapter.add(basicThermometer, new Identity("basicThermometer", "thermometer"));

            adapter.activate();

            System.out.println("Entering event processing loop...");

            communicator.waitForShutdown();

        } catch (Exception e) {
            System.err.println(e);
            status = 1;
        }
        if (communicator != null) {
            try {
                communicator.destroy();
            } catch (Exception e) {
                System.err.println(e);
                status = 1;
            }
        }
        System.exit(status);
    }

    public static void main(String[] args) {
        Server app = new Server();
        app.t1();
    }
}
