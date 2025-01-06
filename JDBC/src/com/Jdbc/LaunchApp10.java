package com.telisko.jdbclearning;
import java.sql.*;
import java.util.Scanner;

public class LaunchApp10 {

    public static void main(String[] args) {
        System.out.println("Here we’ll try to retrieve data using a prepared statement.");
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try {
            connection = CommonComponent.getConnection();
//            String sql = "SELECT * FROM studentInfo WHERE ID = ?";
            String sql = "SELECT id,sname,sage,scity FROM studentInfo WHERE ID = ?";

            pstm = connection.prepareStatement(sql);
            System.out.println("Please enter the ID for which you want to retrieve data:");
            int id = sc.nextInt();
            pstm.setInt(1, id);
//            rs = pstm.executeQuery();
            rs = pstm.executeQuery();

//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
//            }

            if(rs.next()) {
            	Integer sid = rs.getInt(1);
            	String name = rs.getString(2);
            	Integer sage = rs.getInt(3);
            	String scity = rs.getString(4);
            	System.out.println("id is  "+sid+" "+"name is  "+name+" "+"Age is "+sage+" "+"City is "+scity);

            }else {
            	System.out.println("No data exists form this  id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                CommonComponent.closeConnection(connection, pstm);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
