/*
 * Theory: Steps to Establish a JDBC Connection:
 * 
 * Import JDBC packages. Register the JDBC driver.
 * Open a connection to the database. 
 * Create a Statement or PreparedStatement. 
 * Execute SQL queries.
 * Process the ResultSet.
 * Close the connection.
 */
package Assignment_3;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionSteps {
    public static void main(String[] args) {
        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password"
            );
            System.out.println("Connection Established Successfully!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
