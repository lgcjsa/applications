package luiss.it.LGCDB_Clienti.db;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import luiss.it.LGCDB_Clienti.dao.Indirizzi;

public class ManageIndirizzi {
	
	public Indirizzi getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Indirizzi data =  (Indirizzi) session.get(Indirizzi.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	public void insert(Indirizzi instance) {

		instance.setDataInsert(new Timestamp(System.currentTimeMillis()));
		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(instance);
		tx.commit();
		session.close();
		
	}

	public void update(Indirizzi instance) {

		instance.setDataUpdate(new Timestamp(System.currentTimeMillis()));
		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(instance);
		tx.commit();
		session.close();
		
	}

	public void delete(Indirizzi instance) {

		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(instance);
		tx.commit();
		session.close();
		
	}

}
