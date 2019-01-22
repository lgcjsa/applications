package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.Continenti;


public class ManageContinenti {
	
	public Continenti getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Continenti data =  (Continenti) session.get(Continenti.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<Continenti> getAll() {
		
		List<Continenti> list = new ArrayList<Continenti>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Continenti ORDER BY Continente").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageContinenti().getByID(5).getContinente());
		
		List<Continenti> list = new ManageContinenti().getAll();
		
		Iterator<Continenti> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Continenti)i.next()).getContinente());
		}
		
	}

}
