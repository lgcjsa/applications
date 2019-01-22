package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.TipiTitoloSup;

public class ManageTipiTitoloSup {
	
	public TipiTitoloSup getByID(String id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		TipiTitoloSup data =  (TipiTitoloSup) session.get(TipiTitoloSup.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<TipiTitoloSup> getAll() {
		
		List<TipiTitoloSup> list = new ArrayList<TipiTitoloSup>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from TipiTitoloSup ORDER BY DES ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
		
		List<TipiTitoloSup> list = new ManageTipiTitoloSup().getAll();
		
		Iterator<TipiTitoloSup> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((TipiTitoloSup)i.next()).getDes());
		}
		
	}

}
