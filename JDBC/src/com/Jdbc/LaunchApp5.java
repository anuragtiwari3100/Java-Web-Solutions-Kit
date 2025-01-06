package com.telisko.jdbclearning;
import java.sql.*;
public class LaunchApp5 {

	public static void main(String[] args)throws ClassNotFoundException,SQLException{
		System.out.println("here we'll perform CRUD using single meathod =>execute()");
		  Class.forName("com.mysql.cj.jdbc.Driver");		
		 String url ="jdbc:mysql://localhost:3306/JDBCLEARNING";
	    String user = "root";
	    String pass ="abhishek@2002";
		
		Connection connect = DriverManager.getConnection(url,user,pass);
		Statement statement = connect.createStatement();
		
	     String sql  = "SELECT * FROM  studentinfo"; //for this if block got exceecuted 
//		String sql = "Update  studentinfo  set  sage=16 where id=1";
	     boolean stauts = statement.execute(sql);
	      
	     if(stauts) {
	    	 System.out.println("If block");
	    	     //select
	    	 ResultSet rs =statement.getResultSet();
	    	 while(rs.next()) {
	    		 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
	    	 }
	     }else {
	    	 System.out.println("else block");

	    	    //insertion,updatation , deletion
	    	int rows = statement.getUpdateCount();
	    	if(rows == 0) {
	    		System.out.println("Opeartaion is failed");
	    	}else {
	    		System.out.println("Opeartaion Sucessfull");

	    	}
	     }
	     
	     
		connect.close();
		statement.close();
		

	}

}
