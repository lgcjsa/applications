package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.MiurTipiScuole;

public class ManageMiurTipiScuole {
	
	public MiurTipiScuole getByID(String id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		MiurTipiScuole data =  (MiurTipiScuole) session.get(MiurTipiScuole.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<MiurTipiScuole> getAll() {
		
		List<MiurTipiScuole> list = new ArrayList<MiurTipiScuole>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from MiurTipiScuole ORDER BY DES ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageMiurTipiScuole().getByID("IP").getDes());
		
		List<MiurTipiScuole> list = new ManageMiurTipiScuole().getAll();
		
		Iterator<MiurTipiScuole> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((MiurTipiScuole)i.next()).getDes());
		}
		
	}

}
