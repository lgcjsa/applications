package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.Regioni;


public class ManageRegioni {
	
	public Regioni getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Regioni data =  (Regioni) session.get(Regioni.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<Regioni> getByID_Nazione(int id) {
		
		List<Regioni> list = new ArrayList<Regioni>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Regioni WHERE ID_Nazioni =" + id + " ORDER BY Regione").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	
	@SuppressWarnings("unchecked")
	public List<Regioni> getAll() {
		
		List<Regioni> list = new ArrayList<Regioni>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Regioni ORDER BY Regione").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageRegioni().getByID(10).getRegione());
		
		List<Regioni> list = new ManageRegioni().getByID_Nazione(1);
		
		Iterator<Regioni> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Regioni)i.next()).getRegione());
		}
		
		list = new ManageRegioni().getAll();
		
		i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Regioni)i.next()).getRegione());
		}
		
	}

}
