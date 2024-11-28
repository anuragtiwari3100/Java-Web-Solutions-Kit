package com.telisko.jdbclearning;
import java.sql.*;
import java.util.Scanner;
public class LaunchApp9 {

	public static void main(String[] args) {
		System.out.println("here we we'll try to delete using prepared statemnt");
		Connection  connection = null;
		PreparedStatement pstm=null;
		Scanner sc = new Scanner(System.in);
		try {
			   connection = CommonComponent.getConnection();
			   String sql = "DELETE FROM studentinfo WHERE ID=? ";
			   pstm = connection.prepareStatement(sql);
			   System.out.println("Plz enter the id for  which you wanna delete");
			   int id = sc.nextInt();
			   pstm.setInt(1,id);
			   int  affected = pstm.executeUpdate();
			   if(affected == 0) {
				   System.out.println("Data could not deleted from the DB");
			   }else {
				   System.out.println("Data Sucessfully deleted from the Database");
			   }
			
		}catch(SQLException e) {
               e.printStackTrace();			
		}catch(Exception e) {
            e.printStackTrace();			
		}finally {
			try {
				CommonComponent.closeConnection(connection, pstm);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
