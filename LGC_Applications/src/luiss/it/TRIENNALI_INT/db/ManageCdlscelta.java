package luiss.it.TRIENNALI_INT.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.TRIENNALI_INT.dao.Cdlscelta;
import luiss.it.TRIENNALI_INT.dao.CdlsceltaId;


public class ManageCdlscelta {
	
	public Cdlscelta getByID(CdlsceltaId id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Cdlscelta data =  (Cdlscelta) session.get(Cdlscelta.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	  
	@SuppressWarnings("unchecked")
	public List<Cdlscelta> getAll() {
		
		List<Cdlscelta> list = new ArrayList<Cdlscelta>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Cdlscelta WHERE Selezionabile = 'S' ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {  
				    
		CdlsceltaId key = new CdlsceltaId();
		
		key.setFac("3");
		key.setCds("GS");
		
		System.out.println(new ManageCdlscelta().getByID(key).getDescrizione());
		
		List<Cdlscelta> list = new ManageCdlscelta().getAll();
		
		Iterator<Cdlscelta> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Cdlscelta)i.next()).getId().getCds());
		}
		
	}

}
