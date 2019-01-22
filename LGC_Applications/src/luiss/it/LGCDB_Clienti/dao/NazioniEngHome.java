package luiss.it.LGCDB_Clienti.dao;
// Generated 11-dic-2018 16.15.37 by Hibernate Tools 5.2.6.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class NazioniEng.
 * @see luiss.it.LGCDB_Clienti.dao.NazioniEng
 * @author Hibernate Tools
 */
public class NazioniEngHome {

	private static final Log log = LogFactory.getLog(NazioniEngHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(NazioniEng transientInstance) {
		log.debug("persisting NazioniEng instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(NazioniEng instance) {
		log.debug("attaching dirty NazioniEng instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NazioniEng instance) {
		log.debug("attaching clean NazioniEng instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(NazioniEng persistentInstance) {
		log.debug("deleting NazioniEng instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NazioniEng merge(NazioniEng detachedInstance) {
		log.debug("merging NazioniEng instance");
		try {
			NazioniEng result = (NazioniEng) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public NazioniEng findById(java.lang.Integer id) {
		log.debug("getting NazioniEng instance with id: " + id);
		try {
			NazioniEng instance = (NazioniEng) sessionFactory.getCurrentSession()
					.get("luiss.it.LGCDB_Clienti.dao.NazioniEng", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(NazioniEng instance) {
		log.debug("finding NazioniEng instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("luiss.it.LGCDB_Clienti.dao.NazioniEng")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
