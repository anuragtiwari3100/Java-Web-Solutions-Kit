package tiwari.com.MavProject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//ye project bus resources nahi  the uske ke lie hai
public class App {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        System.out.println("Application is started...");

        // Create Configuration instance and configure Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Build the SessionFactory
        SessionFactory Factory = cfg.buildSessionFactory();

        System.out.println("Hibernate SessionFactory created successfully!"+Factory);
        System.out.println(Factory.isClosed());
        Student st = new Student();
        st.setId(101);
        st.setName("Abhishek");
        st.setCity("Gopalgnaj");
        st.setId(102);
        st.setName("Adrsh");
        st.setCity("Rajkot");
        System.out.println(st);
       Session session =   Factory.openSession();
       //
      Transaction tx = session.beginTransaction();
       session.save(st);
      tx.commit();
       
       session.close();
        
   
    }
}
