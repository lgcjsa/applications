package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.Nazioni;


public class ManageNazioni {
	
	public Nazioni getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Nazioni data =  (Nazioni) session.get(Nazioni.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<Nazioni> getByCodice_Catastale(String cod) {
		
		List<Nazioni> list = new ArrayList<Nazioni>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Nazioni WHERE Codice_Catastale = '" + cod + "' ORDER BY Nazione").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	
	@SuppressWarnings("unchecked")
	public List<Nazioni> getAll() {
		
		List<Nazioni> list = new ArrayList<Nazioni>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Nazioni ORDER BY Nazione").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageNazioni().getByID(10).getNazione());
		
		List<Nazioni> list = new ManageNazioni().getByCodice_Catastale("Z700");
		
		Iterator<Nazioni> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Nazioni)i.next()).getNazione());
		}
		
		list = new ManageNazioni().getAll();
		
		i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Nazioni)i.next()).getNazione());
		}
		
	}

}
