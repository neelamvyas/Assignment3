// 1. Introduction to JDBC

// Theory:
// What is JDBC?
// JDBC (Java Database Connectivity) is a standard Java API that allows Java applications to interact with relational databases.
// It provides methods to connect to a database, execute SQL queries, and retrieve results.
// Importance of JDBC:
// JDBC is crucial in Java programming as it allows applications to perform database operations seamlessly, enabling data storage, retrieval, and manipulation.
// JDBC Architecture:
// - DriverManager: Manages database drivers and establishes connections.
// - Driver: Interfaces with the database to process queries.
// - Connection: Represents a connection to the database.
// - Statement: Used to execute SQL queries.
// - ResultSet: Holds data retrieved from the database.

// Lab Exercise:
import java.sql.*;
public class SimpleJDBCConnection {
    public static void main(String[] args) {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");

            // Confirm connection
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
