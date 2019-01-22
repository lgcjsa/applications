package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.Controlli;


public class ManageControlli {
	
	public Controlli getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Controlli data =  (Controlli) session.get(Controlli.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	} 
	
	@SuppressWarnings("unchecked")
	public List<Controlli> getAll(int id) {
		
		List<Controlli> list = new ArrayList<Controlli>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Controlli WHERE ID_Contesti = " + id + " ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
		
		List<Controlli> list = new ManageControlli().getAll(2);
		
		Iterator<Controlli> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Controlli)i.next()).getInputName());
		}

	}

}
