package jdbc_05_callable;
import java.io.BufferedReader;

import java.sql.*;
import java.io.*;

public class CallableIn {

    public static final String loadDriver = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/AdvanceJava";
    public static final String username = "root";
    public static final String password = "***********";

   public static final String query="{call register(?,?,?,?,?,?,?,?,?,?,?,?)}";
    public static void main(String[] args) {

        try {
            Class.forName(loadDriver);

            Connection con = DriverManager.getConnection(url, username, password);
              
            InputStreamReader isr=new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       CallableStatement cs=con.prepareCall(query);
       
       System.out.println("Enter your Account Number");
       cs.setInt(1, Integer.parseInt(br.readLine()));
       
       System.out.println("Enter your Customer Id");
      int cid=Integer.parseInt(br.readLine());
      cs.setInt(2,cid);
      
      System.out.println("Enter your Name");
          cs.setString(3, (br.readLine()));
          
          System.out.println("Enter your Balance");
          cs.setInt(4,Integer.parseInt(br.readLine()));
          
          System.out.println("Enter your AccountType");
          cs.setString(5,(br.readLine()));
          
          System.out.println("Enter your House Number");
          cs.setString(6,(br.readLine()));
          
          System.out.println("Enter your Street Name");
          cs.setString(7,(br.readLine()));
          
          System.out.println("Enter your City");
          cs.setString(8,(br.readLine()));
          
          System.out.println("Enter your State");
          cs.setString(9,(br.readLine()));
          
          System.out.println("Enter your pincode");
          cs.setInt(10 ,Integer.parseInt(br.readLine()));
          
          System.out.println("Enter you Mail ID");
          cs.setString(11 , (br.readLine()));
          
          System.out.println("Enter your phoneNo");
          cs.setString(12, (br.readLine()));
      
      
          cs.execute();
         System.out.println("code inserted");
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
