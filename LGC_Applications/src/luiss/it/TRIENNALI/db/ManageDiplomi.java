package luiss.it.TRIENNALI.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.TRIENNALI.dao.Diplomi;


public class ManageDiplomi {
	
	public Diplomi getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Diplomi data =  (Diplomi) session.get(Diplomi.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<Diplomi> getAll() {
		
		List<Diplomi> list = new ArrayList<Diplomi>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Diplomi ORDER BY Denominazione ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
		
		List<Diplomi> list = new ManageDiplomi().getAll();
		
		Iterator<Diplomi> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Diplomi)i.next()).getDenominazione());
		}
		
	}

}
