package Assignment_3;

/*
 * Theory: Introduction to Java Swing: Swing is a part of Java's standard
 * library for creating GUI applications. Integrating Swing with JDBC: Use Swing
 * components like JButton, JTextField, and JTable to interact with the user.
 * Use JDBC for database interactions such as CRUD operations.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SwingCRUDApp extends JFrame {
    private JTextField idField, fnameField, lnameField, emailField;
    private JButton insertButton, updateButton, selectButton, deleteButton;
    private JTextArea resultArea;

    public SwingCRUDApp() {
        // Set up GUI components
        setTitle("Swing JDBC CRUD App");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("ID:"));
        idField = new JTextField(10);
        add(idField);

        add(new JLabel("First Name:"));
        fnameField = new JTextField(10);
        add(fnameField);

        add(new JLabel("Last Name:"));
        lnameField = new JTextField(10);
        add(lnameField);

        add(new JLabel("Email:"));
        emailField = new JTextField(10);
        add(emailField);

        insertButton = new JButton("Insert");
        add(insertButton);
        updateButton = new JButton("Update");
        add(updateButton);
        selectButton = new JButton("Select");
        add(selectButton);
        deleteButton = new JButton("Delete");
        add(deleteButton);

        resultArea = new JTextArea(10, 50);
        add(new JScrollPane(resultArea));

        // Button event listeners
        insertButton.addActionListener(e -> insertRecord());
        updateButton.addActionListener(e -> updateRecord());
        selectButton.addActionListener(e -> selectRecords());
        deleteButton.addActionListener(e -> deleteRecord());
    }

    private void insertRecord() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password")) {

            String sql = "INSERT INTO users (id, fname, lname, email) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(idField.getText()));
            pstmt.setString(2, fnameField.getText());
            pstmt.setString(3, lnameField.getText());
            pstmt.setString(4, emailField.getText());
            pstmt.executeUpdate();
            resultArea.setText("Record inserted successfully!");
        } catch (SQLException ex) {
            resultArea.setText("Error: " + ex.getMessage());
        }
    }

    private void updateRecord() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password")) {

            String sql = "UPDATE users SET fname = ?, lname = ?, email = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fnameField.getText());
            pstmt.setString(2, lnameField.getText());
            pstmt.setString(3, emailField.getText());
            pstmt.setInt(4, Integer.parseInt(idField.getText()));
            pstmt.executeUpdate();
            resultArea.setText("Record updated successfully!");
        } catch (SQLException ex) {
            resultArea.setText("Error: " + ex.getMessage());
        }
    }

    private void selectRecords() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password")) {

            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            StringBuilder results = new StringBuilder("Records:\n");
            while (rs.next()) {
                results.append("ID: ").append(rs.getInt("id"))
                       .append(", First Name: ").append(rs.getString("fname"))
                       .append(", Last Name: ").append(rs.getString("lname"))
                       .append(", Email: ").append(rs.getString("email")).append("\n");
            }
            resultArea.setText(results.toString());
        } catch (SQLException ex) {
            resultArea.setText("Error: " + ex.getMessage());
        }
    }

    private void deleteRecord() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password")) {

            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(idField.getText()));
            pstmt.executeUpdate();
            resultArea.setText("Record deleted successfully!");
        } catch (SQLException ex) {
            resultArea.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingCRUDApp app = new SwingCRUDApp();
            app.setVisible(true);
        });
    }
}
