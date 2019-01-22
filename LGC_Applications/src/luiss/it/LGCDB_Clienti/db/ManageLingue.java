package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.Lingue;


public class ManageLingue {
	
	public Lingue getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Lingue data =  (Lingue) session.get(Lingue.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public Lingue getByCodice(String cod) {
		
		List<Lingue> list = new ArrayList<Lingue>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Lingue WHERE Codice = '" + cod + "' ").list();
		session.getTransaction().commit();
		session.close();
		return list.get(0);

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageLingue().getByID(2).getLingua());
		System.out.println(new ManageLingue().getByCodice("IT").getLingua());
		
	}

}
