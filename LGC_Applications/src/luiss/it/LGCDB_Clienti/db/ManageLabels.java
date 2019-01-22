package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.Labels;


public class ManageLabels {
	
	public Labels getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Labels data =  (Labels) session.get(Labels.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public Labels getLabels(int cod, String lingua) {
		
		List<Labels> list = new ArrayList<Labels>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Labels WHERE Codice_Label =" + cod + " AND Lingue_Codice = '" + lingua + "'").list();
		session.getTransaction().commit();
		session.close();
		return list.size() > 0 ? list.get(0) : null;

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageLabels().getByID(1).getLabel());
		System.out.println(new ManageLabels().getLabels(1, "EN").getLabel());
		
	}

}
