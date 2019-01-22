package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.AnniAccademici;

public class ManageAnniAccademici {
	
	public AnniAccademici getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		AnniAccademici data =  (AnniAccademici) session.get(AnniAccademici.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<AnniAccademici> getAll() {
		
		List<AnniAccademici> list = new ArrayList<AnniAccademici>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from AnniAccademici ORDER BY DES DESC ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageAnniAccademici().getByID(1999).getDes());
		
		List<AnniAccademici> list = new ManageAnniAccademici().getAll();
		
		Iterator<AnniAccademici> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((AnniAccademici)i.next()).getDes());
		}

		

	}

}
