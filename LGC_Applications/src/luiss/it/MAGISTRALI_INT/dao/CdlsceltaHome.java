package luiss.it.MAGISTRALI_INT.dao;
// Generated 15-nov-2018 17.05.57 by Hibernate Tools 5.2.6.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Cdlscelta.
 * @see luiss.it.MAGISTRALI_INT.dao.Cdlscelta
 * @author Hibernate Tools
 */
public class CdlsceltaHome {

	private static final Log log = LogFactory.getLog(CdlsceltaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Cdlscelta transientInstance) {
		log.debug("persisting Cdlscelta instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Cdlscelta instance) {
		log.debug("attaching dirty Cdlscelta instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cdlscelta instance) {
		log.debug("attaching clean Cdlscelta instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Cdlscelta persistentInstance) {
		log.debug("deleting Cdlscelta instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cdlscelta merge(Cdlscelta detachedInstance) {
		log.debug("merging Cdlscelta instance");
		try {
			Cdlscelta result = (Cdlscelta) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cdlscelta findById(luiss.it.MAGISTRALI_INT.dao.CdlsceltaId id) {
		log.debug("getting Cdlscelta instance with id: " + id);
		try {
			Cdlscelta instance = (Cdlscelta) sessionFactory.getCurrentSession()
					.get("luiss.it.MAGISTRALI_INT.dao.Cdlscelta", id);
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

	public List findByExample(Cdlscelta instance) {
		log.debug("finding Cdlscelta instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("luiss.it.MAGISTRALI_INT.dao.Cdlscelta")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
