package jdbc_01_connection;

import java.sql.Connection;     // missing import
import java.sql.DriverManager;

public class connect {
    public static void main(String[] args) {
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/AdvanceJava",
                "root",
                "3456346"
            );

            if (con != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Not Established");
            }

            con.close();  // good practice

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
