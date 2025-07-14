import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class EmailSender {

    public static void main(String[] args) throws Exception {
        String apiKey = "YOUR_SENDGRID_API_KEY";
        String jsonPayload = "{"
                + "\"personalizations\": [{\"to\": [{\"email\": \"recipient@example.com\"}]}],"
                + "\"from\": {\"email\": \"sender@example.com\"},"
                + "\"subject\": \"Test Email from Java\","
                + "\"content\": [{\"type\": \"text/plain\", \"value\": \"Hello from Java without Jakarta Mail!\"}]"
                + "}";

        URL url = new URL("https://api.sendgrid.com/v3/mail/send");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", "Bearer " + apiKey);
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonPayload.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = con.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        if (responseCode == 202) {
            System.out.println("Email sent successfully!");
        } else {
            System.out.println("Failed to send email.");
        }
    }
}
