package com.telisko.jdbclearning;
import  java.sql.*; 

public class LaunchApp1 {

	public static void main(String[] args) throws ClassNotFoundException ,SQLException {
       System.out.println("Here we'll perform the Insertion operation to the Database");
        //Load and register the driver
       Class.forName("com.mysql.cj.jdbc.Driver");
    
       //Establish the connection
       String url ="jdbc:mysql://localhost:3306/JDBCLEARNING";
       String user ="root";
       String password ="abhishek@2002";
       
       Connection connect =DriverManager.getConnection(url,user,password);
       
//       DriverManager.registerDriver(new com.mysql.jdbc.Driver());
       //creating statement
      Statement statement = connect.createStatement();
      
      //execute query => i.e here we are inserting data 
      String sql = "INSERT INTO studentinfo (id, sname, sage, scity) VALUES (12, 'Abhishek', 21, 'gopalhanj'), (13, 'Abhishek', 21, 'gopalhanj'), (14, 'Abhishek', 21, 'gopalhanj')";
      	

     int rowAffected= statement.executeUpdate(sql); 
      
      //process the result
      if(rowAffected ==0) {
    	    System.out.println("Unable to insert data");
      }else {
    	  System.out.println("Data inserted Sucessfully!!!");
      }
      
      
      //close the resource
      
      statement.close();
      connect.close();
  
	}

}
