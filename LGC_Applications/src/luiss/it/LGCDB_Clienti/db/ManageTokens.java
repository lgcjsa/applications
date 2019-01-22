package luiss.it.LGCDB_Clienti.db;

import org.hibernate.Session;
import org.hibernate.Transaction;

import luiss.it.LGCDB_Clienti.dao.Tokens;

public class ManageTokens {
	
	public Tokens getByID(String id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Tokens data =  (Tokens) session.get(Tokens.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	} 	
	
	public boolean exists(String id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Tokens data =  (Tokens) session.get(Tokens.class, id);
		session.getTransaction().commit();
		session.close();
		return data != null;

	} 		
	public void insert(Tokens instance) {

		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(instance);
		tx.commit();
		session.close();
		
	}

	public void update(Tokens instance) {

		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(instance);
		tx.commit();
		session.close();
		
	}

	public void delete(Tokens instance) {

		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(instance);
		tx.commit();
		session.close();
		
	}

}
