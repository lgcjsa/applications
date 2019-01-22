package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.LivelliSportivi;


public class ManageLivelliSportivi {
	
	public LivelliSportivi getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		LivelliSportivi data =  (LivelliSportivi) session.get(LivelliSportivi.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<LivelliSportivi> getAll() {
		
		List<LivelliSportivi> list = new ArrayList<LivelliSportivi>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from LivelliSportivi ORDER BY Livello").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageLivelliSportivi().getByID(1).getLivello());
		
		List<LivelliSportivi> list = new ManageLivelliSportivi().getAll();
		
		Iterator<LivelliSportivi> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((LivelliSportivi)i.next()).getLivello());
		}
		
	}

}
