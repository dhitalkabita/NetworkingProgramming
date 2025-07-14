import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        try {
            // Create URL object
            URL url = new URL("https://www.example.com:443/page/index.html?user=admin&ref=123");

            // Display different parts of the URL
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("File: " + url.getFile());
            System.out.println("Query: " + url.getQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }}}
