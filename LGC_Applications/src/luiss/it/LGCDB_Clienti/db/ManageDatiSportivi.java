package luiss.it.LGCDB_Clienti.db;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import luiss.it.LGCDB_Clienti.dao.DatiSportivi;

public class ManageDatiSportivi {
	
	public DatiSportivi getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		DatiSportivi data =  (DatiSportivi) session.get(DatiSportivi.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	public void insert(DatiSportivi instance) {

		instance.setDataInsert(new Timestamp(System.currentTimeMillis()));
		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(instance);
		tx.commit();
		session.close();
		
	}

	public void update(DatiSportivi instance) {

		instance.setDataUpdate(new Timestamp(System.currentTimeMillis()));
		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(instance);
		tx.commit();
		session.close();
		
	}

	public void delete(DatiSportivi instance) {

		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(instance);
		tx.commit();
		session.close();
		
	}

}
