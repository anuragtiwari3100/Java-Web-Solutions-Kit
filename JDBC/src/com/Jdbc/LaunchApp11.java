package com.telisko.jdbclearning;
import java.sql.*;
import java.util.Scanner;
public class LaunchApp11 {
   
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
        	
        	pstmt.setString(1,"Vikash");
        	pstmt.setInt(2, 101);
        	pstmt.addBatch();
        	pstmt.setString(1,"tieari");
        	pstmt.setInt(2, 102);
        	pstmt.addBatch();
        	pstmt.setString(1,"Tiwari");
        	pstmt.setInt(2, 103);
        	pstmt.addBatch();
        	pstmt.setString(1,"Abhishek");
        	pstmt.setInt(2, 104);
        	pstmt.addBatch();
        	
        	pstmt.executeUpdate();
        	System.out.println("Check Your data to see updated recoords");
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
