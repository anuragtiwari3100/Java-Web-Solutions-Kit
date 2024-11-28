package com.telisko.jdbclearning;
import java.sql.*;
public class LaunchApp3 {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		System.out.println("Here we'll perform the Read or fetch operation");
//		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());    //this is older synatx here Registering and loading the class both are being doing manualy and sepertly
		//Load and register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");  // lading and register at ones during the runtinnme
		//Establishing the connection
//		String url ="jdbc:mysql//localhost:3306/JDBCLEARNING";
	    String url ="jdbc:mysql://localhost:3306/JDBCLEARNING";

		String user ="root";
		String pass ="abhishek@2002";
		Connection connect =DriverManager.getConnection(url,user,pass);
		//Creating statement
		Statement statement = connect.createStatement();
		//process the query
		String sql = "Select * from studentinfo";
		ResultSet rs = statement.executeQuery(sql);
				
		//processing 
		while(rs.next()) {
//			 int id = rs.getInt(1);
			//either we have to pass column no by spacifyoun the typrof Data
			 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" ");
			 //or we can pass  name  of column
			 System.out.println(rs.getInt("id")+" "+rs.getString("sname")+" "+rs.getInt("sage")+" "+rs.getString("scity"));
		}
	   
		
		
		//close the resource
		connect.close();
		statement.close();
		rs.close();
		
		
	}

}
