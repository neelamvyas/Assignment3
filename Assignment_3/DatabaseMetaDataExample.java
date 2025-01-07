package Assignment_3;

/*
 * Theory: What is DatabaseMetaData? Provides information about the database and
 * its structure. Key Methods in DatabaseMetaData: getDatabaseProductName()
 * getDatabaseProductVersion() getTables(), etc.
 */

import java.sql.*;

public class DatabaseMetaDataExample {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password")) {

            DatabaseMetaData dbMetaData = conn.getMetaData();
            
            System.out.println("Database Product Name: " + dbMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbMetaData.getDatabaseProductVersion());
            
            ResultSet tables = dbMetaData.getTables(null, null, "%", new String[]{"TABLE"});
            System.out.println("List of Tables:");
            while (tables.next()) {
                System.out.println(tables.getString("TABLE_NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
