package jdbc_01_connection;
import java.sql.Connection;

import java.sql.DriverManager;

public class connect_opt {
	public static final String loadDriver="com.mysql.cj.jdbc.Driver";
	public static final String url= "jdbc:mysql://localhost:3306/AdvanceJava";
	public static final String username= "root";
	public static final String password="8235618645";
	
	
	 public static void main(String[] args) {
		 try {
			 Class.forName(loadDriver);
			 
			Connection con=DriverManager.getConnection(url,username,password);
			if(con!=null) {
				System.out.println("connection done");
			}
			else {
				System.out.println("connection not done");
			}
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}

}
