package luiss.it.LGCDB_Clienti.db;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import luiss.it.LGCDB_Clienti.dao.Persone;

public class ManagePersone {
	
	public Persone getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Persone data =  (Persone) session.get(Persone.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	public void insert(Persone instance) {

		instance.setDataInsert(new Timestamp(System.currentTimeMillis()));
		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(instance);
		tx.commit();
		session.close();
		
	}

	public void update(Persone instance) {

		instance.setDataUpdate(new Timestamp(System.currentTimeMillis()));
		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(instance);
		tx.commit();
		session.close();
		
	}

	public void delete(Persone instance) {

		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(instance);
		tx.commit();
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public boolean esiste(String cf) {
		
		List<Persone> list = new ArrayList<Persone>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Persone WHERE Codice_Fiscale = '" + cf + "' ").list();
		session.getTransaction().commit();
		session.close();
		return list.size() > 0;

	}  	

}
