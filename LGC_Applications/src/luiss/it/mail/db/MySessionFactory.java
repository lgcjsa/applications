package luiss.it.mail.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	  
	private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("MAIL.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
	
}
