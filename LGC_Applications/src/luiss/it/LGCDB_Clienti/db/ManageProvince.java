package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.Province;


public class ManageProvince {
	
	public Province getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Province data =  (Province) session.get(Province.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<Province> getByID_Regione(int id) {
		
		List<Province> list = new ArrayList<Province>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Province WHERE ID_Regioni =" + id + " ORDER BY Provincia").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	
	@SuppressWarnings("unchecked")
	public List<Province> getAll() {
		
		List<Province> list = new ArrayList<Province>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Province ORDER BY Provincia").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageProvince().getByID(10).getProvincia());
		
		List<Province> list = new ManageProvince().getByID_Regione(1);
		
		Iterator<Province> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Province)i.next()).getProvincia());
		}
		
		list = new ManageProvince().getAll();
		
		i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((Province)i.next()).getProvincia());
		}
		
	}

}
