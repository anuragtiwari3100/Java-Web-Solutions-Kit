package com.telisko.jdbclearning;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class BetterWaytowrite {


		public static void main(String[] args){
			System.out.println("Here instead of ducking the exception we will  try to  handle it ");
//			  "These are the interfaces that refer to the objects of their implementing classes."

			Connection connect =null;
			Statement statement = null;	  
			  
			  try {
				  Class.forName("com.mysql.cj.jdbc.Driver");	
				  
				  String url ="jdbc:mysql://localhost:3306/JDBCLEARNING";
				    String user = "root";
				    String pass ="abhishek@2002";
					
							connect = DriverManager.getConnection(url,user,pass);
						    statement = connect.createStatement();
							
				     String sql  = "SELECT * FROM  studentinfo"; //for this if block got exceecuted 
//					String sql = "Update  studentinfo  set  sage=16 where id=1";
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
				     
				   
					
				  
			  }catch(ClassNotFoundException e) {
				  e.printStackTrace();	
			  }catch(SQLException e) {
				  e.printStackTrace();	
			  }catch(Exception e) {
                      e.printStackTrace();				  
			  }finally {
				  
//					connect.close();
//					statement.close();
				  
				    try {
				    	statement.close();
				    	statement.close();
				    }catch(SQLException e) {
				    	e.printStackTrace();
				    }
				   
   			  }
			  
			 

		}

	}
