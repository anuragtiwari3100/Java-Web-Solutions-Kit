package com.telisko.jdbclearning;

import java.sql.*;


public class CommonComponent {
//while loading and  regisering the driver , getting the connection  and closing the coonnection is common so we will do that in this appication we will just resue it whereever we wish to use

		static{
			     try {
			    	  Class.forName("com.mysql.cj.jdbc.Driver");
			     }catch(ClassNotFoundException e) {
			    	  e.printStackTrace(); 
			     }
		}
		
   public static Connection getConnection() throws SQLException {
		 String url ="jdbc:mysql://localhost:3306/JDBCLEARNING";
		    String user = "root";
		    String pass ="abhishek@2002";
		 return DriverManager.getConnection(url,user,pass);
	   
   }
   public static  void closeConnection(Connection connect,Statement statement)throws ClassNotFoundException, SQLException{
	     connect.close();
	     statement.close();
   }
		
	}






/* just an example of loading the class at that time static block get executed
 
      class DemoClass {

    // Static block
    static {
        System.out.println("Static block is executed when the class is loaded.");
    }

    // Constructor
    DemoClass() {
        System.out.println("Constructor is executed when an object is created.");
    }

    // Static method
    static void staticMethod() {
        System.out.println("Static method is called.");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Main method starts.");

        // Accessing the class without creating an instance
        DemoClass.staticMethod(); // This will cause the class to load and the static block to execute

        System.out.println("Creating an instance of DemoClass.");
        DemoClass demo = new DemoClass(); // Constructor will execute here, but the static block won’t execute again

        System.out.println("Main method ends.");
    }
}

 */
 