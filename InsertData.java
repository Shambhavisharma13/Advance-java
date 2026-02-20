package jdbc_02_statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {
	public static final String loadDriver="com.mysql.cj.jdbc.Driver";
	public static final String url= "jdbc:mysql://localhost:3306/AdvanceJava";
	public static final String username= "root";
	public static final String password="*****";
	
	public static final String QUERY="insert into stud2 values(101,'Aman',20),(102,'Lakshya',22),(103,'Harsh',21)";
	public static void main(String[] args) {
		
		 try {
			 Class.forName(loadDriver);
			 
			Connection con=DriverManager.getConnection(url,username,password);
			
			Statement st=con.createStatement();
			
			int k=st.executeUpdate(QUERY);
			if(k<0) {
				System.out.println("data inserted");
			}else {
				System.out.println("Data not inserted");
			}
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}

}

