import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import server.actors.ServerActor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        final ActorSystem system = ActorSystem.create("system");
        final ActorRef actor = system.actorOf(Props.create(ServerActor.class), "server");
        System.out.println("Started. Commands: 'price [product]'");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("q")) {
                break;
            }
            actor.tell(line, actor);
        }

        system.terminate();
    }
}
