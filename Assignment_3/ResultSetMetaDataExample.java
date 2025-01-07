package Assignment_3;

/*
 * Theory: What is ResultSetMetaData? Provides metadata about the columns in a
 * ResultSet. Key Methods in ResultSetMetaData: getColumnCount()
 * getColumnName(int column) getColumnType(int column) Lab Exercise:
 */

import java.sql.*;

public class ResultSetMetaDataExample {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password")) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            ResultSetMetaData rsMetaData = rs.getMetaData();

            System.out.println("Column Count: " + rsMetaData.getColumnCount());
            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                System.out.println("Column Name: " + rsMetaData.getColumnName(i));
                System.out.println("Column Type: " + rsMetaData.getColumnTypeName(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
