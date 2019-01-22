package luiss.it.TRIENNALI_INT.dao;
// Generated 15-nov-2018 17.14.11 by Hibernate Tools 5.2.6.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Preweb.
 * @see luiss.it.TRIENNALI_INT.dao.Preweb
 * @author Hibernate Tools
 */
public class PrewebHome {

	private static final Log log = LogFactory.getLog(PrewebHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Preweb transientInstance) {
		log.debug("persisting Preweb instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Preweb instance) {
		log.debug("attaching dirty Preweb instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Preweb instance) {
		log.debug("attaching clean Preweb instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Preweb persistentInstance) {
		log.debug("deleting Preweb instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Preweb merge(Preweb detachedInstance) {
		log.debug("merging Preweb instance");
		try {
			Preweb result = (Preweb) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Preweb findById(luiss.it.TRIENNALI_INT.dao.PrewebId id) {
		log.debug("getting Preweb instance with id: " + id);
		try {
			Preweb instance = (Preweb) sessionFactory.getCurrentSession().get("luiss.it.TRIENNALI_INT.dao.Preweb", id);
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

	public List findByExample(Preweb instance) {
		log.debug("finding Preweb instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("luiss.it.TRIENNALI_INT.dao.Preweb")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
