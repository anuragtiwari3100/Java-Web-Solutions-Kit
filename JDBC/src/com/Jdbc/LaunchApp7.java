package com.telisko.jdbclearning;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class LaunchApp7 {


		public static void main(String[] args){
			 System.out.println("we'll learn About Prepared statement");
			Connection connect =null;
			Statement statement = null;	 
			PreparedStatement psmt= null;
			  
			  try {
				  connect=  CommonComponent.getConnection();						
 				    String sql = "INSERT INTO studentinfo(id,sname,sage,scity)VALUES(?,?,?,?)";			      
 				    psmt =  connect.prepareStatement(sql);
				   
			    System.out.println("Please Enter the  following  details  to be stored in DB \n");
			    Scanner sc = new Scanner(System.in);
			    System.out.println("Enter the Your ID   \n");
			    int id = sc.nextInt();
			    System.out.println("Enter Your Name  \n");
			    String name = sc.next();
			    System.out.println("Enter Your age plz \n");
			    int age = sc.nextInt();
			    System.out.println("Enter Your city  \n");
			    String city = sc.next();
			    
			    psmt.setInt(1,id);
			    psmt.setString(2,name);
			    psmt.setInt(3,age);
			    psmt.setString(4,city);
	
			    
			    int affectedRow = psmt.executeUpdate();
			    //process the result
			    if(affectedRow ==  0) {
			    	System.out.println("unable to insert the Data");
			    }else {
			    	System.out.println("Data inserted Sucessfully");
			    }
				  
			  }catch(SQLException e) {
				  e.printStackTrace();	
			  }catch(Exception e) {
                      e.printStackTrace();				  
			  }finally {
				  
			    try {
				    	CommonComponent.closeConnection(connect, psmt);
				    	  
				    }catch(ClassNotFoundException e) {
				    	e.printStackTrace();
				    }catch(SQLException e) {
				    	e.printStackTrace();
				    }
				   
   			  }

		}

	}
