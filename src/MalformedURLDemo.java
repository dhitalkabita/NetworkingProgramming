import java.net.MalformedURLException;
import java.net.URL;

public class MalformedURLDemo {
    public static void main(String[] args) {
        String malformedURL = "htp:/wrong-url";

        try {
            // Attempt to create a URL object from malformed string
            URL url = new URL(malformedURL);
            System.out.println("URL created successfully: " + url);
        } catch (MalformedURLException e) {
            // Catch and handle the malformed URL exception
            System.out.println("Error: The URL is malformed.");
            System.out.println("Details: " + e.getMessage());
        }
    }
}
