package jdbc_06_transaction;
import java.io.BufferedReader;

import java.sql.*;
import java.io.*;
import java.util.*;
public class transaction{

    public static final String loadDriver = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/AdvanceJava";
    public static final String username = "root";
    public static final String password = "**********";
// it check wheter a user exist or not
  public static final String CHECKUSER="select * from BankCustomer where accno=?";
  
  public static final String UpdateBalance="update BankCustomer set balance=balance+ ? where accno=?";
  
    public static void main(String[] args) {  

        try {
            Class.forName(loadDriver);

            Connection con = DriverManager.getConnection(url, username, password);
              
            InputStreamReader isr=new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Scanner s=new Scanner(System.in);
      PreparedStatement ps1=con.prepareStatement(CHECKUSER);
      PreparedStatement ps2=con.prepareStatement(UpdateBalance);
      
      System.out.println("Commit Status:"+con.getAutoCommit());
      con.setAutoCommit(false);
      System.out.println("Commit Status:"+con.getAutoCommit());
     
      //Transaction
      Savepoint sb= con.setSavepoint();
      
      System.out.println("Enter sender Account Number");
      int sender=s.nextInt();
      
      ps1.setInt(1, sender);
      
      ResultSet rs=ps1.executeQuery();
      if(rs.next()) {
    	  String senderName=rs.getString(3);
    	  int balance=rs.getInt(4);
    	  
    	 System.out.println("Sender Name:"+senderName);
    	 System.out.println("Balance:"+balance);
    	 
    	 //Receiver
    	 
    	 System.out.println("Enter receiver Account Number");
         int recAcc=s.nextInt();
         
         ps1.setInt(1, recAcc);
         
         ResultSet rs2=ps1.executeQuery();
    	 
         if(rs2.next()) {
        	 String reAcc=rs.getString(3);
        	 System.out.println("Receiver Name:"+reAcc);
        	 
        	 System.out.println("eneter your amount to be transferred");
        	 int amt=Integer.parseInt(br.readLine());
        	 if(amt<balance) {
        		 //subtract from sender account
        		 ps2.setInt(1,-amt);
        		 ps2.setInt(2, sender);
        		 //yeh  query ko db se bhi update krwa diya
        		 int p=ps2.executeUpdate();
        		 
        		 //receiver credit
        		 ps2.setInt(1, amt);
        		 ps2.setInt(2, recAcc);
        		 
        		 //yeh query ko db me vi update krta hai
        		 int q=ps2.executeUpdate();
        		 if(p>0&&q>0) {
        			 System.out.println("Transaction successfull");
        			 con.commit();
        			 
        			 System.out.println("check your balance(yes/no)");
        			 String opt=br.readLine();
        			   if(!opt.startsWith("y")&&!opt.startsWith("Y"));
        			   System.out.println("thankyou for using us");
        		 }
        		 else {
        			 ps1.setInt(1, sender);
        			 ResultSet rs3=ps1.executeQuery();
        			 if(rs3.next()) {
        				 System.out.println("Customer Name:"+rs2.getString(3));
        				 System.out.println("Current Balance:"+rs2.getInt(4));
        			 
        			 }
        			 else {
        				 System.out.println("server Down");
        			 }
        		 }
        		 
        	 }
        	 else {
        		 System.out.println("Transaction Failed");
        		 con.rollback(sb);
        	 }
        	 System.out.println("Insufficient funds");
        	 
         }else {
        	 System.out.println("Invalid Receiver Account number");
         }
    	 
      }else {
    	  System.out.println("Invalid Sender Account Number");
      }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
