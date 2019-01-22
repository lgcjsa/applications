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
 * Home object for domain model class LivelliSportivi.
 * @see luiss.it.LGCDB_Clienti.dao.LivelliSportivi
 * @author Hibernate Tools
 */
public class LivelliSportiviHome {

	private static final Log log = LogFactory.getLog(LivelliSportiviHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(LivelliSportivi transientInstance) {
		log.debug("persisting LivelliSportivi instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(LivelliSportivi instance) {
		log.debug("attaching dirty LivelliSportivi instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LivelliSportivi instance) {
		log.debug("attaching clean LivelliSportivi instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(LivelliSportivi persistentInstance) {
		log.debug("deleting LivelliSportivi instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LivelliSportivi merge(LivelliSportivi detachedInstance) {
		log.debug("merging LivelliSportivi instance");
		try {
			LivelliSportivi result = (LivelliSportivi) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LivelliSportivi findById(java.lang.Integer id) {
		log.debug("getting LivelliSportivi instance with id: " + id);
		try {
			LivelliSportivi instance = (LivelliSportivi) sessionFactory.getCurrentSession()
					.get("luiss.it.LGCDB_Clienti.dao.LivelliSportivi", id);
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

	public List findByExample(LivelliSportivi instance) {
		log.debug("finding LivelliSportivi instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("luiss.it.LGCDB_Clienti.dao.LivelliSportivi").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
