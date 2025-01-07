package Assignment_3;

/*
 * Theory: What is ResultSet? ResultSet is an object that holds the results of a
 * SQL query. Navigating through ResultSet: Use methods like next(), previous(),
 * first(), last(), etc., to traverse the results. Processing Data: Retrieve
 * column values using getString(), getInt(), etc.
 */
import java.sql.*;

public class ResultSetNavigation {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password")) {

            Statement stmt = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // Navigate through the ResultSet
            System.out.println("Navigating through ResultSet:");
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

            if (rs.last()) {
                System.out.println("Last Record: ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

            if (rs.first()) {
                System.out.println("First Record: ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
