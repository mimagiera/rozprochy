package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;

public class Client {

    private static final int serverPortNumber = 54321;
    private static final String hostName = "localhost";
    private static InetAddress address;

    static {
        try {
            address = InetAddress.getByName(hostName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        System.out.println("CLIENT STARTED");
        Socket socket = new Socket(hostName, serverPortNumber);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DatagramSocket datagramSocket = new DatagramSocket();

        Thread readTCPMessagesThread = readTCPMessages(in);
        Thread readUDPMessagesThread = readUDPMessages(datagramSocket);
        Thread sendMessagesThread = sendMessages(out, datagramSocket);

        readTCPMessagesThread.start();
        readUDPMessagesThread.start();
        sendMessagesThread.start();
        sendUdpMessage(datagramSocket, "UDP connected from port: " + datagramSocket.getLocalPort());
    }

    private static Thread readTCPMessages(BufferedReader in) {
        return new Thread(() -> {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("received msg by TCP: " + message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static Thread readUDPMessages(DatagramSocket datagramSocket) {
        return new Thread(() -> {
            byte[] receiveBuffer = new byte[1024];
            while (true) {
                try {
                    Arrays.fill(receiveBuffer, (byte) 0);
                    DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                    datagramSocket.receive(receivePacket);
                    String msg = new String(receivePacket.getData());
                    System.out.println("received msg by UDP: " + msg);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static Thread sendMessages(PrintWriter out, DatagramSocket datagramSocket) {
        return new Thread(() -> {
            Scanner scn = new Scanner(System.in);
            String message;
            while (true) {
                message = scn.nextLine();
                switch (message) {
                    case "U": {
                        System.out.println("Sending message by UDP. Enter your message: ");
                        message = scn.nextLine();
                        sendUdpMessage(datagramSocket, message);
                        break;
                    }
                    case "M": {
                        //TODO
                        break;
                    }
                    default: {
                        out.println(message);
                        break;
                    }
                }
            }
        });
    }

    private static void sendUdpMessage(DatagramSocket datagramSocket, String message) {
        byte[] sendBuffer = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, serverPortNumber);
        try {
            datagramSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
