package com.telisko.jdbclearning;
import java.sql.*;
import java.util.Scanner;
public class LaunchApp8 {
   
	public static void main(String[] args) {
         System.out.println("here we'll try to update recordsby using the prepared statement..");
         Connection connection = null;
//         Statement statement = null;
         PreparedStatement  pstmt = null;
         Scanner sc = new Scanner(System.in);
         try {
        	 
        	 String sql ="UPDATE studentinfo SET  sname =? WHERE ID=?";
        	     
        	connection  = CommonComponent.getConnection();
        	pstmt  =connection.prepareStatement(sql);
        	System.out.println("Enter the information that needs to be updated");
        	System.out.println("Please enter the name that you wanna Update..");
        	String name = sc.next();
        	System.out.println("Plese enter the id for which you wanna update");
        	int id = sc.nextInt();
        	pstmt.setString(1,name);
        	pstmt.setInt(2, id);
        	int afftecte = pstmt.executeUpdate();
        	if(afftecte == 0) {
        		System.out.println("records can no be update");
        	}else {
        		System.out.println("records  updated");

        	}
         }catch(SQLException e) {
        	   e.printStackTrace();
         }catch(Exception e) {
        	 e.printStackTrace();
         }finally {
        	 try {
            	 CommonComponent.closeConnection(connection, pstmt);

        	 }catch(ClassNotFoundException e) {
        		 e.printStackTrace();
        	 }catch(SQLException e) {
        		 e.printStackTrace(); 
        	 }
         }
         
         
          
	}

}
