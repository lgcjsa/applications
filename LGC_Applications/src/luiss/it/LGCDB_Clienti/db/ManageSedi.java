package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.Sedi;


public class ManageSedi {
	
	public Sedi getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Sedi data =  (Sedi) session.get(Sedi.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<Sedi> getByID_Contesti(int id) {
		
		List<Sedi> list = new ArrayList<Sedi>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Sedi WHERE ID_Contesti =" + id + " AND Visibile = 'S' ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	
	  
	public static void main(String args[]) {
		
		List<Sedi> list = new ManageSedi().getByID_Contesti(6);
		
		Iterator<Sedi> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Sedi)i.next()).getDescrizione());
		}
		
	}

}
