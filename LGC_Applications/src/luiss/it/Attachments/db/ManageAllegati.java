package luiss.it.Attachments.db;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import luiss.it.Attachments.dao.Allegati;
import luiss.it.Attachments.db.MySessionFactory;

public class ManageAllegati {
	
	public Allegati getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Allegati data =  (Allegati) session.get(Allegati.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	public void insert(Allegati instance) {

		instance.setDataInserimento(new Timestamp(System.currentTimeMillis()));
		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(instance);
		tx.commit();
		session.close();
		
	}

	public void update(Allegati instance) {

		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(instance);
		tx.commit();
		session.close();
		
	}

	public void delete(Allegati instance) {

		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(instance);
		tx.commit();
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Allegati> getAll() {
		
		List<Allegati> list = new ArrayList<Allegati>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Allegati ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	} 
	
	public static void main(String args[]) {
		
		List<Allegati> list = new ManageAllegati().getAll();
		
		Iterator<Allegati> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Allegati)i.next()).getDescrizione());
		}
		
	}

}
