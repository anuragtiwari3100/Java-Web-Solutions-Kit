package com.telisko.actApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telisko.model.Student;
public class launchApplication {
	 @SuppressWarnings("deprecation")
	public static void main(String args[]) {
		  System.out.println("this file  is responsoble for mappiing the class to the table");
		    
		  // Step ->01 Configuration Object
	        Configuration cfg = new Configuration();
	       
	       //step ->02   Configuring the Hibernate.cfg.xml file into the configure object
	        cfg.configure();//here  we don't need to specify the   xml file name if it is in correct formate or is in  
//	        the  locaon else we've to specify here  only
	          //cfg.configure("hibernate.configure.xml")  -> as here formate is changed
	        
	       //Step ->03    Creating the Session Factory
	     SessionFactory  sessionfactory= cfg.buildSessionFactory();
	     
	     //Step =>04      Geting the Session object from SessionFactory
	      Session session= sessionfactory.openSession();
	      
	      //Step =>05   Begin the  transaction with the session
	        Transaction   transaction = session.beginTransaction();
	      
	      
	      Student st = new Student();
	      Student st2 = new Student();
	        st.setsName("saksham");
	        st.setSid(3130);
	        st.setScity("Gopalgnaj");
	        
	        st2.setsName("saksi");
	        st2.setSid(3111);
	        st2.setScity("Gopalgnaj");
	       
	        System.out.println(st);
	        //Step 06 => performing the operation
	        session.save(st);
//	        session.save(st2);
	        session.persist(st2);
	        //step 07 => performing the  transaction operations
	        transaction.commit(); 
	        
	        //step 08 => Closing the sessions 
	        session.close();
	        
	      
	     
	     
	        
	}

}
