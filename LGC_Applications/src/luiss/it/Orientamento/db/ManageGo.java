package luiss.it.Orientamento.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import luiss.it.Orientamento.dao.Go;
import luiss.it.TRIENNALI_INT.dao.Cdlscelta;

public class ManageGo {
	  
	public void insert(Go instance) {

		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(instance);
		tx.commit();
		session.close();
		
	}
	  
	@SuppressWarnings("unchecked")
	public boolean exists(Go go) {
		
		List<Cdlscelta> list = new ArrayList<Cdlscelta>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Go WHERE Codice_Fiscale = :cf AND ID_Periodi_GO = :periodo ")
				.setParameter("cf", go.getCodiceFiscale())
				.setParameter("periodo", go.getIdPeriodiGo())
				.list();
		session.getTransaction().commit();
		session.close();
		System.out.println(list.size());
		return list.size() > 0;

	}  		
	public Go getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Go data =  (Go) session.get(Go.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	} 
}
