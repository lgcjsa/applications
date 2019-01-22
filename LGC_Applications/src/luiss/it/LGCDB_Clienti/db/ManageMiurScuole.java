package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.MiurScuole;


public class ManageMiurScuole {
	
	public MiurScuole getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		MiurScuole data =  (MiurScuole) session.get(MiurScuole.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<MiurScuole> getByRegione(int id) {
		
		List<MiurScuole> list = new ArrayList<MiurScuole>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from MiurScuole WHERE ID_Regioni = " + id + " ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	
	@SuppressWarnings("unchecked")
	public List<MiurScuole> getByProvicina(int id) {
		
		List<MiurScuole> list = new ArrayList<MiurScuole>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from MiurScuole WHERE ID_Province = " + id + " ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	
	@SuppressWarnings("unchecked")
	public List<MiurScuole> getByComune(int id) {
		
		List<MiurScuole> list = new ArrayList<MiurScuole>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from MiurScuole WHERE ID_Comuni = " + id + " ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	
	@SuppressWarnings("unchecked")
	public List<MiurScuole> getByComune(int comune, String tipoScuola) {
		
		List<MiurScuole> list = new ArrayList<MiurScuole>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from MiurScuole WHERE ID_Comuni = " + comune + " AND TIPO_SCUOLA_MIUR_COD = '" + tipoScuola + "' ").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
				    
		System.out.println(new ManageMiurScuole().getByID(17).getDenominazione());
		
		List<MiurScuole> list = new ManageMiurScuole().getByRegione(17);
		
		Iterator<MiurScuole> i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((MiurScuole)i.next()).getDenominazione());
		}
		
		list = new ManageMiurScuole().getByRegione(17);
		
		i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((MiurScuole)i.next()).getDenominazione());
		}
		
		list = new ManageMiurScuole().getByComune(745);
		
		i = list.iterator();
		
		while (i.hasNext()) {
			System.out.println(((MiurScuole)i.next()).getDenominazione());
		}

	}

}
