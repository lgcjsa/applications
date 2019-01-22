package luiss.it.LGCDB_Clienti.db;

import org.hibernate.Session;

import luiss.it.LGCDB_Clienti.dao.Config;


public class ManageConfig {
	
	public Config getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Config data =  (Config) session.get(Config.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	

}
