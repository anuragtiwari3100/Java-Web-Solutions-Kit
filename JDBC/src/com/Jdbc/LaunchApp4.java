package com.telisko.jdbclearning;
import java.sql.*;
public class LaunchApp4 {

	public static void main(String[] args)throws ClassNotFoundException,SQLException{
	  System.out.println("we'll be delting here records");
      
	  //Load and register the Driver
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  
	  
	  //Establishing the connection
	   String url ="jdbc:mysql://localhost:3306/JDBCLEARNING";
	  String user ="root";
	  String pass ="abhishek@2002";
	Connection connnect = DriverManager.getConnection(url,user,pass);
	
	//Creating the connection 
	Statement statement =connnect.createStatement();
	
	
	//processing the query
	String sql = "DELETE FROM studentinfo where id=12";
	int rowAffected =statement.executeUpdate(sql);
	
   if(rowAffected ==0) {
	   System.out.println("Deletion is failed!!");
   }else {
	   System.out.println("Deletion  Suceeasfully !!");

   }
	
	
	
	statement.close();
	connnect.close();

	
	  
	}

}
