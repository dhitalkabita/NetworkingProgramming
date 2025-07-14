import java.sql.*;

public class SecureLogin {
    public static void main(String[] args) {
        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/studentdb";
        String dbUser = "root";
        String dbPassword = "J@v@123";

        // User input (this can come from Scanner or GUI in real applications)
        String usernameInput = "admin";
        String passwordInput = "admin123";

        // SQL query using PreparedStatement to prevent SQL injection
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set input values into the query
            pstmt.setString(1, usernameInput);
            pstmt.setString(2, passwordInput);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Check if user exists
            if (rs.next()) {
                System.out.println("✅ Login Successful!");
            } else {
                System.out.println("❌ Invalid credentials.");
            }

        } catch (SQLException e) {
            System.out.println("Database error:");
            e.printStackTrace();
        }
    }
}
