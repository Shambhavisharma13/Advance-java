package jdbc_05_callable;

import java.sql.*;
import java.util.Scanner;

public class Callableout {

    public static final String loadDriver = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/AdvanceJava";
    public static final String username = "root";
    public static final String password = "********";

    public static final String query = "{call retrive(?,?,?,?,?,?,?,?,?,?,?,?)}";

    public static void main(String[] args) {

        try {

            Class.forName(loadDriver);

            Connection con = DriverManager.getConnection(url, username, password);

            CallableStatement cs = con.prepareCall(query);

            Scanner s = new Scanner(System.in);

            System.out.println("Enter your Account Number:");
            int accno = s.nextInt();

            cs.setInt(1, accno);

            cs.registerOutParameter(2, Types.INTEGER);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.INTEGER);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.registerOutParameter(6, Types.VARCHAR);
            cs.registerOutParameter(7, Types.VARCHAR);
            cs.registerOutParameter(8, Types.VARCHAR);
            cs.registerOutParameter(9, Types.VARCHAR);
            cs.registerOutParameter(10, Types.VARCHAR);
            cs.registerOutParameter(11, Types.VARCHAR);
            cs.registerOutParameter(12, Types.VARCHAR);

            cs.execute();

            System.out.println("Account No: " + accno);
            System.out.println("Customer ID: " + cs.getInt(2));
            System.out.println("Customer Name: " + cs.getString(3));
            System.out.println("Balance: " + cs.getInt(4));
            System.out.println("Account Type: " + cs.getString(5));
            System.out.println("House Number: " + cs.getString(6));
            System.out.println("Street Name: " + cs.getString(7));
            System.out.println("City: " + cs.getString(8));
            System.out.println("State: " + cs.getString(9));
            System.out.println("Pincode: " + cs.getString(10));
            System.out.println("Mail ID: " + cs.getString(11));
            System.out.println("Phone No: " + cs.getString(12));

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
