package Assignment_3;

/*
 * Theory: What is a CallableStatement?
 * 
 * It is an interface in JDBC used to call stored procedures in a database.
 * Stored procedures are precompiled SQL statements that can accept input (IN)
 * and return output (OUT) parameters. How to use CallableStatement:
 * 
 * Use the prepareCall() method of the Connection object. Syntax: java Copy code
 * CallableStatement cstmt =
 * connection.prepareCall("{call procedureName(?, ?)}"); Steps for using
 * CallableStatement:
 * 
 * Create a stored procedure in the database. Use CallableStatement to pass IN
 * parameters and retrieve OUT parameters. Execute the statement and process the
 * results.
 */
import java.sql.*;

public class CallableStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Prepare the CallableStatement
            CallableStatement cstmt = conn.prepareCall("{call GetEmployeeName(?, ?)}");

            // Set the IN parameter (employee ID)
            cstmt.setInt(1, 101); // Replace 101 with the desired employee ID

            // Register the OUT parameter
            cstmt.registerOutParameter(2, Types.VARCHAR);

            // Execute the stored procedure
            cstmt.execute();

            // Retrieve and display the OUT parameter
            String fullName = cstmt.getString(2);
            System.out.println("Employee Full Name: " + fullName);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
