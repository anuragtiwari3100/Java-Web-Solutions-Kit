package com.telsko.DAO_DataAccessObject;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.Entity.Student;

public class performingDelOperation {

	@SuppressWarnings("deprecation")
	  public static void main(String args[]) {
		System.out.println("Staring the actual applocation");
	      SessionFactory sessionFactory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	        Session session = null;
	        boolean transaction_Done = false;
	        Transaction  transaction = null;
	        Student st = null;
	        try {
	        	session = sessionFactory.openSession();
	        	transaction = session.beginTransaction();
	        	 st = new Student();
//	        	st.setId(101);
//	        	st.setCity("Benga");
//	        	st.setName("Pardip tiwari");
	        	
//	        	st.setId(109);
//	        	st.setCity("UK");
//	        	st.setName("Chiko");
	        	 
	        	 
//	        	session.update(st); //depricated
//	        	session.saveOrUpdate(st);  //depricated
//	        	session.merge(st);
//	        	session.delete(st);	 //depricated 
	        	st =session.get(Student.class, 109);
	        	if(st != null) {
	        		session.remove(st);
	                System.out.println("Student with ID 109 successfully deleted.");
	        	}else {
	        	    System.out.println("Student with ID 109 not found.");

	        	}

	        	transaction_Done = true; 
	        	
	        }catch(HibernateException ex) {
	        	
	        }catch(Exception ex) {
	        	ex.printStackTrace();
	        }
	        finally {
	        	if(transaction_Done == true) {
	        		transaction.commit();
	        		
	        	}else {
	        		transaction.rollback();
	        		
	        	}
	        	session.close();
	        	sessionFactory.close();
	        }
	}
	}


