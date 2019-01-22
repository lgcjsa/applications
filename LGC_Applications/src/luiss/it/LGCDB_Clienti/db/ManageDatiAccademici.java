package luiss.it.LGCDB_Clienti.db;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import luiss.it.LGCDB_Clienti.dao.DatiAccademici;

public class ManageDatiAccademici {
	
	public DatiAccademici getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		DatiAccademici data =  (DatiAccademici) session.get(DatiAccademici.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	public void insert(DatiAccademici instance) {

		instance.setDataInsert(new Timestamp(System.currentTimeMillis()));
		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(instance);
		tx.commit();
		session.close();
		
	}

	public void update(DatiAccademici instance) {

		instance.setDataUpdate(new Timestamp(System.currentTimeMillis()));
		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(instance);
		tx.commit();
		session.close();
		
	}

	public void delete(DatiAccademici instance) {

		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(instance);
		tx.commit();
		session.close();
		
	}

}
