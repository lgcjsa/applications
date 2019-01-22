package luiss.it.Orientamento.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import luiss.it.Orientamento.dao.MiurScuole;
import luiss.it.Orientamento.dao.MiurTipiScuole;


public class ManageMiurScuole {
	
	@SuppressWarnings("unchecked")
	public List<String> getRegioni() {
		
		String sql =  "SELECT DISTINCT s.regione FROM MiurScuole s ORDER BY s.regione ";		
		List<String> list = new ArrayList<String>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery(sql).list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	
	@SuppressWarnings("unchecked")
	public List<String> getProvince(String regione) {
		
		String sql =  "SELECT DISTINCT s.prov FROM MiurScuole s WHERE s.regione = :regione ORDER BY s.prov ";		
		List<String> list = new ArrayList<String>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery(sql).setParameter("regione", regione).list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	
	@SuppressWarnings("unchecked")
	public List<String> getComuni(String regione, String provincia) {
		
		String sql =  "SELECT DISTINCT s.comune FROM MiurScuole s WHERE s.regione = :regione AND s.prov = :provincia ORDER BY s.comune ";		
		List<String> list = new ArrayList<String>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery(sql).setParameter("regione", regione).setParameter("provincia", provincia).list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	
	@SuppressWarnings("unchecked")
	public List<MiurTipiScuole> getTipiScuole(String regione, String provincia, String comune) {
		
		String sql =  "SELECT DISTINCT t.tipoScuolaCod FROM MiurTipiScuole t JOIN MiurScuole s ON s.tipoScuolaMiurCod = t.tipoScuolaCod  WHERE REGIONE = :regione AND PROV = :provincia  AND COMUNE = :comune   ORDER BY t.des ";		
		List<String> list = new ArrayList<String>();
		List<MiurTipiScuole> result = new ArrayList<MiurTipiScuole>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery(sql).setParameter("regione", regione).setParameter("provincia", provincia).setParameter("comune", comune).list();
		session.getTransaction().commit();
		session.close();
		Iterator<String> i = list.iterator();
		while(i.hasNext()) {
			result.add(new ManageMiurTipiScuole().getByID(i.next()));
		}
		return result;

	}  		
	
	@SuppressWarnings("unchecked")
	public List<MiurScuole> getScuole(String regione, String provincia, String comune, MiurTipiScuole tipo) {
		
		String sql =  "FROM MiurScuole WHERE REGIONE = :regione  AND PROV = :provincia  AND COMUNE = :comune  AND TIPO_SCUOLA_MIUR_COD = :tipo ORDER BY DENOMINAZIONE ";		
		List<MiurScuole> list = new ArrayList<MiurScuole>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery(sql).setParameter("regione", regione).setParameter("provincia", provincia).setParameter("comune", comune).setParameter("tipo", tipo.getTipoScuolaCod()).list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
	
	public MiurScuole getByID(long id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		MiurScuole data =  (MiurScuole) session.get(MiurScuole.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	

	  
	public static void main(String args[]) {  
		
	}

}
