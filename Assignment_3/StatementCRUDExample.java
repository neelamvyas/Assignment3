/*
 * Theory: Statement Types: Statement: Executes basic SQL queries.
 * PreparedStatement: Supports parameterized queries. Precompiled for better
 * performance. CallableStatement: Used for executing stored procedures.
 */
package Assignment_3;

import java.sql.*;

public class StatementCRUDExample {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password")) {

            Statement stmt = conn.createStatement();
            
            // Insert
            stmt.executeUpdate("INSERT INTO users (id, name) VALUES (1, 'John Doe')");
            System.out.println("Record inserted successfully!");
            
            // Update
            stmt.executeUpdate("UPDATE users SET name='Jane Doe' WHERE id=1");
            System.out.println("Record updated successfully!");
            
            // Select
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
            
            // Delete
            stmt.executeUpdate("DELETE FROM users WHERE id=1");
            System.out.println("Record deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
