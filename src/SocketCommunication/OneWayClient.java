package SocketCommunication;

import java.io.*;
import java.net.*;

public class OneWayClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5050;

        try (Socket socket = new Socket(host, port)) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println("Hello, Server!");
            writer.println("This is a one-way message.");
            writer.println("Bye!");

            socket.shutdownOutput(); // Let server know we're done sending

            System.out.println("Client sent messages successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
