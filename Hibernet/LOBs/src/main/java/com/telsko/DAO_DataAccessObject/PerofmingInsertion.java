package com.telsko.DAO_DataAccessObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.telusko.Entity.StudentInfo;

public class PerofmingInsertion {



	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Staring the actual applocation");
	    Configuration cfg = null;
	    SessionFactory Factory = null;
	    Session session = null;
	    Transaction   transaction = null;
	    boolean  transactionDone = false;
	    StudentInfo st= null;
	    FileInputStream  fis = null;
	    FileReader  reader= null;
	    byte image[] = null;
	    
	    cfg = new Configuration();
	    cfg.addAnnotatedClass(StudentInfo.class);
	    Factory = cfg.buildSessionFactory();
	   session =Factory.openSession();
	   
	   try {
		  fis = new FileInputStream("C:\\Users\\anura\\OneDrive\\Desktop\\s.png");
		 image= new byte[fis.available()];
		 fis.read(image);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   catch(Exception e) {
			e.printStackTrace();
		}
		   

	   
	    st = new StudentInfo();
//	    st.setId(181);   because we have use @GeneraedValue in the Model(Student) class id will be auto assign
	    st.setName("Abhishek");
	    st.setCity("Bandra");
	    st.setImage(image);
	   
	    
	  String  path = "C:\\Users\\anura\\OneDrive\\Desktop\\abhi.txt";
	   reader= new  FileReader(path);
	   
	   new  char[file.length];
	 
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
	       Factory.close();
	    
	    }
	}

}
