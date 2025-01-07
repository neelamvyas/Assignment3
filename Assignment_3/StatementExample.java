//2. JDBC Driver Types
package Assignment_3;

// Theory:
// Overview of JDBC Driver Types:
// 1. Type 1: JDBC-ODBC Bridge Driver
//    - Translates JDBC calls to ODBC calls.
//    - Deprecated and not recommended for use.
// 2. Type 2: Native-API Driver
//    - Converts JDBC calls to native database API calls.
//    - Requires database-specific native libraries.
// 3. Type 3: Network Protocol Driver
//    - Uses middleware to translate JDBC calls into database-specific calls.
//    - Suitable for enterprise applications.
// 4. Type 4: Thin Driver
//    - Directly communicates with the database using database-specific protocols.
//    - Most commonly used driver.
 import java.sql.Connection;
 import java.sql.DriverManager;

 public class JDBCDriverTypeExample {
     public static void main(String[] args) {
         try {
             Connection conn = DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/testdb", "root", "password"
             );
             System.out.println("Using Type 4 Driver for MySQL.");
             conn.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 }
