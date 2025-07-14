import java.net.URL;
import java.util.Scanner;

public class URLParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a URL: ");
        String urlString = scanner.nextLine();

        try {
            // Create URL object
            URL url = new URL(urlString);

            // Display different parts of the URL
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());

            int port = url.getPort();
            if (port == -1) {
                System.out.println("Port: (default or not specified)");
            } else {
                System.out.println("Port: " + port);
            }

            System.out.println("Path: " + url.getPath());

            String query = url.getQuery();
            if (query != null) {
                System.out.println("Query: " + query);
            } else {
                System.out.println("Query: (none)");
            }

        } catch (Exception e) {
            System.out.println("Invalid URL! Please make sure the format is correct.");
        }

        scanner.close();
    }
}
