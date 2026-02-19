package jdbc_02_statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
	public static final String loadDriver="com.mysql.cj.jdbc.Driver";
	public static final String url= "jdbc:mysql://localhost:3306/AdvanceJava";
	public static final String username= "root";
	public static final String password="";
	
	public static final String QUERY="create table stud2(id int primary key,name varchar(30),age int not null)";
	 public static void main(String[] args) {
		 try {
			 Class.forName(loadDriver);
			 
			Connection con=DriverManager.getConnection(url,username,password);
		//statement->fixed kaam karega
			Statement st=con.createStatement();
		int k=st.executeUpdate(QUERY);
		if(k==0) {
			System.out.println("Table created");
		}else {
			System.out.println("Table not created");
		}
			 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}

}
