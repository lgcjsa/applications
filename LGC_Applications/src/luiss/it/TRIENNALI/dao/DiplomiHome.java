package luiss.it.TRIENNALI.dao;
// Generated 29-nov-2018 18.33.35 by Hibernate Tools 5.2.6.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Diplomi.
 * @see luiss.it.TRIENNALI.dao.Diplomi
 * @author Hibernate Tools
 */
public class DiplomiHome {

	private static final Log log = LogFactory.getLog(DiplomiHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Diplomi transientInstance) {
		log.debug("persisting Diplomi instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Diplomi instance) {
		log.debug("attaching dirty Diplomi instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Diplomi instance) {
		log.debug("attaching clean Diplomi instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Diplomi persistentInstance) {
		log.debug("deleting Diplomi instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Diplomi merge(Diplomi detachedInstance) {
		log.debug("merging Diplomi instance");
		try {
			Diplomi result = (Diplomi) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Diplomi findById(java.lang.String id) {
		log.debug("getting Diplomi instance with id: " + id);
		try {
			Diplomi instance = (Diplomi) sessionFactory.getCurrentSession().get("luiss.it.TRIENNALI.dao.Diplomi", id);
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

	public List findByExample(Diplomi instance) {
		log.debug("finding Diplomi instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("luiss.it.TRIENNALI.dao.Diplomi")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
