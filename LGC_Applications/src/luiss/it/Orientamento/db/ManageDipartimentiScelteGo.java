package luiss.it.Orientamento.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import luiss.it.Orientamento.dao.DipartimentiScelteGo;

public class ManageDipartimentiScelteGo {
	
	public void delete(DipartimentiScelteGo instance) {

		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(instance);
		tx.commit();
		session.close();
		
	}	
	
	public void insert(DipartimentiScelteGo instance) {

		Session session = MySessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(instance);
		tx.commit();
		session.close();
		
	}
	
	public DipartimentiScelteGo getByID(int id) {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		DipartimentiScelteGo data =  (DipartimentiScelteGo) session.get(DipartimentiScelteGo.class, id);
		session.close();
		return data;

	}  	
	@SuppressWarnings("unchecked")
	public List<DipartimentiScelteGo> getByIdGo(int id) {
		
		String sql =  "FROM DipartimentiScelteGo WHERE ID_GO = :id ";		
		List<DipartimentiScelteGo> list = new ArrayList<DipartimentiScelteGo>();
		Session session = MySessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery(sql).setParameter("id", id).list();
		session.getTransaction().commit();
		session.close();
		return list;

	}  		
}
