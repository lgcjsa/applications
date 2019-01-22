package luiss.it.TRIENNALI_INT.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import luiss.it.TRIENNALI_INT.db.MySessionFactory;
import luiss.it.TRIENNALI_INT.dao.Preweb;
import luiss.it.TRIENNALI_INT.dao.PrewebId;

public class ManagePreweb {
	
	public Preweb getByID(PrewebId id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Preweb data =  (Preweb) session.get(Preweb.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	  
	@SuppressWarnings("unchecked")
	public List<Preweb> getAll() {
		
		List<Preweb> list = new ArrayList<Preweb>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Preweb ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {  
				    
		PrewebId key = new PrewebId();
		
		key.setAnno("2014");
		key.setSessione("05");
		key.setCf("BRBGCM97B24Z110C");
		
		System.out.println(new ManagePreweb().getByID(key).getPrewebCognome());
		
		List<Preweb> list = new ManagePreweb().getAll();
		
		Iterator<Preweb> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Preweb)i.next()).getId().getCf() );
		}
		
	}
	
	public void insert(Preweb instance) {

		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(instance);
		tx.commit();
		session.close();
		
	}

}
