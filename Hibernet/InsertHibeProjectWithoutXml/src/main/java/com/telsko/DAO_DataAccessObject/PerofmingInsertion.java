package com.telsko.DAO_DataAccessObject;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.telusko.Entity.Student;

public class PerofmingInsertion {



	public static void main(String[] args) {
		System.out.println("Staring the actual applocation");
	    Configuration cfg = null;
	    SessionFactory sessionFactory = null;
	    Session session = null;
	    Transaction   transaction = null;
	    boolean  transactionDone = false;
	    Student st= null;
	    cfg = new Configuration();
	   
	    cfg.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
	    cfg.setProperty("hibernate.connection.username","root");
	    cfg.setProperty("hibernate.connection.password","abhishek@2002");
	    cfg.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/thrdDb");
	    cfg.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        cfg.setProperty("hibernate.hbm2ddl.auto","update");
        cfg.setProperty("hibernate.show_sql","true"); 
	    cfg.setProperty("hibernate.formate_sql","true");
	    cfg.setProperty("hibernate.show_sql", "true");
        cfg.addAnnotatedClass(Student.class);
	   
        sessionFactory = cfg.buildSessionFactory();
        
	    session =sessionFactory.openSession();
	    st = new Student();
	    st.setId(11);
	    st.setName("tiwari");
	    st.setCity("gopalganj");
	    
	   
	    try {
	         
	    	transaction =session.beginTransaction();
	    	session.persist(st);
	    	transactionDone = true;
	    	
	    }catch(HibernateException ex){
	    	
	    	
	    }catch(Exception ex) {
            ex.printStackTrace();	    	
	    }finally {
	        if(transactionDone == true) {
	        	transaction.commit();
	        }else {
	        	transaction.rollback();
	        }
	       session.close();
	       sessionFactory.close();
	    }
	}

}
