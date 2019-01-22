package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.Comuni;


public class ManageComuni {
	
	public Comuni getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Comuni data =  (Comuni) session.get(Comuni.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<Comuni> getByID_Province(int id) {
		
		List<Comuni> list = new ArrayList<Comuni>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Comuni WHERE ID_Province =" + id + " ORDER BY Comune").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	
	@SuppressWarnings("unchecked")
	public Comuni getByCodiceCatastale(String codice) {
		
		List<Comuni> list = new ArrayList<Comuni>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Comuni WHERE Codice_Catastale = '" + codice + "' ORDER BY Comune").list();
		session.getTransaction().commit();
		session.close();
		return list.get(0);

	}  		
	
	@SuppressWarnings("unchecked")
	public List<Comuni> getAll() {
		
		List<Comuni> list = new ArrayList<Comuni>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Comuni ORDER BY Comune").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageComuni().getByID(10).getComune());
		
		List<Comuni> list = new ManageComuni().getAll();
		
		Iterator<Comuni> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Comuni)i.next()).getComune());
		}
		
		System.out.println(new ManageComuni().getByCodiceCatastale("A662").getComune());
		
	}

}
