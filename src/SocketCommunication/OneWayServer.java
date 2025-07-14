package SocketCommunication;

import java.io.*;
import java.net.*;

public class OneWayServer {
    public static void main(String[] args) {
        int port = 5050;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println(" Server is listening on port " + port);

            Socket socket = serverSocket.accept();
            System.out.println(" Client connected.");

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String message;
            System.out.println(" Reading from client...");
            while ((message = reader.readLine()) != null) {
                System.out.println("📩 Received: " + message);
            }
            System.out.println("📴 Client disconnected.");

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
