package luiss.it.LGCDB_Clienti.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.NazioniEng;


public class ManageNazioniENG {
	
	public NazioniEng getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		NazioniEng data =  (NazioniEng) session.get(NazioniEng.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	
	
	@SuppressWarnings("unchecked")
	public List<NazioniEng> getByCodice_Catastale(String cod) {
		
		List<NazioniEng> list = new ArrayList<NazioniEng>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from NazioniEng WHERE Codice_Catastale = '" + cod + "' ORDER BY Nazione").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	
	@SuppressWarnings("unchecked")
	public List<NazioniEng> getAll() {
		
		List<NazioniEng> list = new ArrayList<NazioniEng>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from NazioniEng ORDER BY Nazione").list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	  
	public static void main(String args[]) {
				    

		
	}

}
