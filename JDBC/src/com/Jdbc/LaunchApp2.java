package com.telisko.jdbclearning;
import java.sql.*;
public class LaunchApp2 {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
	System.out.println("Here we'll perform the Updation operation to the Database");
	Class.forName("com.mysql.cj.jdbc.Driver");
    String url ="jdbc:mysql://localhost:3306/abhishek";
	String user ="root";
	String pass = "abhishek@2002";
	Connection connect =DriverManager.getConnection(url,user,pass);
	Statement statement=connect.createStatement();
	
// Executing query i.e   updating the records
	   String  sql = "UPDATE studentinfo SET sage=19 WHERE ID = 101";
	   
          int   affectedRow  = statement.executeUpdate(sql);
          if(affectedRow == 0) {
        	  System.out.println("Database could not Updated..");
          }else {
        	  System.out.println("Database update..");
          }
          connect.close();
          statement.close();
	}

}
