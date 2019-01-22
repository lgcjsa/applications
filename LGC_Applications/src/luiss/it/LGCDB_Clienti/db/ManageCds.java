package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.Cds;

public class ManageCds {
	
	public Cds getByID(String id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Cds data =  (Cds) session.get(Cds.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<Cds> getAll() {
		
		List<Cds> list = new ArrayList<Cds>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Cds ORDER BY DES ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageCds().getByID("LM3GS").getDes());
		
		List<Cds> list = new ManageCds().getAll();
		
		Iterator<Cds> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Cds)i.next()).getDes());
		}
		
	}

}
