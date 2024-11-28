package com.telisko.jdbclearning;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class LaunchApp6 {


		public static void main(String[] args){
			 System.out.println(" created"
	                 + "components that will take care of loading and registering "
	                 + "the driver, making the connection, and creating the statement. "
	                 + "We will just be using these components as needed.");//			  "These are the interfaces that refer to the objects of their implementing classes."

			Connection connect =null;
			Statement statement = null;	  
			  
			  try {
				  connect=  CommonComponent.getConnection();
						    statement = connect.createStatement();
							
//				     String sql  = "SELECT * FROM  studentinfo"; //for this if block got exceecuted 
//					String sql = "Update  studentinfo  set  sage=16 where id=1";
				     String sql = "INSERT INTO studentinfo(id,sname,sage,scity)VALUES(3,'Sakshan',23,'gopalganj')";
//				     String sql = "DELETE FROM studentinfo WHERE ID =3";
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
				  
			  }catch(SQLException e) {
				  e.printStackTrace();	
			  }catch(Exception e) {
                      e.printStackTrace();				  
			  }finally { 

				  
				    try {
				    	CommonComponent.closeConnection(connect, statement);
				    	  
				    }catch(ClassNotFoundException e) {
				    	e.printStackTrace();
				    }catch(SQLException e) {
				    	e.printStackTrace();
				    }
				   
   			  }
			  
			 

		}

	}
