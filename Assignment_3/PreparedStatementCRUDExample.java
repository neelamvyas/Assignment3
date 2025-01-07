package Assignment_3;

import java.sql.*;

public class PreparedStatementCRUDExample {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password")) {

            // Insert
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (id, name) VALUES (?, ?)");
            pstmt.setInt(1, 2);
            pstmt.setString(2, "Alice");
            pstmt.executeUpdate();
            System.out.println("Prepared Statement Insert Successful!");

            // Update
            pstmt = conn.prepareStatement("UPDATE users SET name=? WHERE id=?");
            pstmt.setString(1, "Bob");
            pstmt.setInt(2, 2);
            pstmt.executeUpdate();
            System.out.println("Prepared Statement Update Successful!");

            // Select
            pstmt = conn.prepareStatement("SELECT * FROM users");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

            // Delete
            pstmt = conn.prepareStatement("DELETE FROM users WHERE id=?");
            pstmt.setInt(1, 2);
            pstmt.executeUpdate();
            System.out.println("Prepared Statement Delete Successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
