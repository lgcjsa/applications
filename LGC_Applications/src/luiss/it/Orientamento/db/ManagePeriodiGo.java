package luiss.it.Orientamento.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.Orientamento.dao.PeriodiGo;


public class ManagePeriodiGo {
	
	@SuppressWarnings("unchecked")
	public List<PeriodiGo> getAll() {
		
		List<PeriodiGo> list = new ArrayList<PeriodiGo>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from PeriodiGo WHERE Visibile='S' ORDER BY Giorno ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		

	public PeriodiGo getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		PeriodiGo data =  (PeriodiGo) session.get(PeriodiGo.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	} 	  
	public static void main(String args[]) {  
		
		Iterator<PeriodiGo> i = new ManagePeriodiGo().getAll().iterator();
		
		while (i.hasNext()) {
			System.out.println(i.next().getDescrizione());
		}

	}

}
