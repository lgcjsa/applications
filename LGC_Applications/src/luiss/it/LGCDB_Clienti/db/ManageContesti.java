package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.Contesti;


public class ManageContesti {
	
	public Contesti getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Contesti data =  (Contesti) session.get(Contesti.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public Contesti getByCodice(String codice) {
		
		List<Contesti> list = new ArrayList<Contesti>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Contesti WHERE Codice = '" + codice + "' ").list();
		session.getTransaction().commit();
		session.close();
		return list.get(0);

	}  		
	  
	@SuppressWarnings("unchecked")
	public List<Contesti> getAll() {
		
		List<Contesti> list = new ArrayList<Contesti>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Contesti ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageContesti().getByID(1).getDescrizione());
		System.out.println(new ManageContesti().getByCodice("SUMMER").getDescrizione());
		

	}

}
