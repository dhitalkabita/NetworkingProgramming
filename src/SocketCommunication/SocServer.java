package SocketCommunication;
import java.io.*;
import java.net.*;
//Reads text data sent by the client line-by-line and prints it to the console.
public class SocServer {
    public static void main(String[] args) throws Exception {
        int port = 9999; //Creates a server socket that listens on port 9999.
        // This port number must match the port the client connects to.

        System.out.println("Server Started");

        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server is waiting for client request");

        Socket s = ss.accept();  // Waits here
        System.out.println("Client Connected!");

        // 🎯 Read data from client
        // Wraps it in an InputStreamReader and then a BufferedReader to read text lines easily.
        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String message;
        while ((message = reader.readLine()) != null) { /// Reads incoming data line-by-line using readLine().
            System.out.println("📩 Received: " + message);
        }
/// The loop continues until the client closes the output stream (or socket), causing readLine() to return null.

        s.close();
        ss.close();
        /// Closes the client socket and the server socket, releasing resources and ending the program.
        System.out.println("Connection closed.");
    }
}
