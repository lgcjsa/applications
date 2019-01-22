package luiss.it.mail.db;

import org.hibernate.Session;

import luiss.it.mail.dao.Testi;


public class ManageTesti {
	
	public Testi getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Testi data =  (Testi) session.get(Testi.class, id);
		session.getTransaction().commit();
		session.close();
		return data;

	}  	

	  
	public static void main(String args[]) {  
		
		System.out.println(new ManageTesti().getByID(4).getTesto());

	}

}
