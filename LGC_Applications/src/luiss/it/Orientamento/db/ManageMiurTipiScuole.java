package luiss.it.Orientamento.db;

import org.hibernate.Session;

import luiss.it.Orientamento.dao.MiurTipiScuole;


public class ManageMiurTipiScuole {
	
	public MiurTipiScuole getByID(String id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		MiurTipiScuole data =  (MiurTipiScuole) session.get(MiurTipiScuole.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	

	  
	public static void main(String args[]) {  
		
		System.out.println(new ManageMiurTipiScuole().getByID("PS").getDes());

	}

}
