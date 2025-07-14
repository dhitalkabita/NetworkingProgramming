package SocketCommunication;
import java.io.*;
import java.net.*;
//One-Way Socket Programming in Java (Client → Server Only)
//In one-way socket programming, communication happens in only one direction, typically from client to server.
//The server listens, and the client sends data (but the server doesn't send back a response).


public class SocClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 9999);
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            //This is the stream you write to in order to send data from client to server.
            //The second argument, true, means auto-flush is enabled.This is important in network programming, so your message is sent promptly without delay.

            out.println("Kabita Dhital");
            out.println("Hello, Server!");
            out.println("This is a one-way message.");
            out.println("Bye!");
            s.shutdownOutput(); // 🔒 Tell server we're done
            //I’m done sending data” — no more bytes will be sent to the server.
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
