package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.DisciplineSportive;


public class ManageDisciplineSportive {
	
	public DisciplineSportive getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		DisciplineSportive data =  (DisciplineSportive) session.get(DisciplineSportive.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<DisciplineSportive> getAll() {
		
		List<DisciplineSportive> list = new ArrayList<DisciplineSportive>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from DisciplineSportive ORDER BY Sport").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageDisciplineSportive().getByID(1).getSport());
		
		List<DisciplineSportive> list = new ManageDisciplineSportive().getAll();
		
		Iterator<DisciplineSportive> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((DisciplineSportive)i.next()).getSport());
		}
		
	}

}
