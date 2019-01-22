package luiss.it.Orientamento.dao;
// Generated 28-nov-2018 11.18.04 by Hibernate Tools 5.2.6.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class MiurScuole.
 * @see luiss.it.Orientamento.dao.MiurScuole
 * @author Hibernate Tools
 */
public class MiurScuoleHome {

	private static final Log log = LogFactory.getLog(MiurScuoleHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(MiurScuole transientInstance) {
		log.debug("persisting MiurScuole instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MiurScuole instance) {
		log.debug("attaching dirty MiurScuole instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MiurScuole instance) {
		log.debug("attaching clean MiurScuole instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MiurScuole persistentInstance) {
		log.debug("deleting MiurScuole instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MiurScuole merge(MiurScuole detachedInstance) {
		log.debug("merging MiurScuole instance");
		try {
			MiurScuole result = (MiurScuole) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MiurScuole findById(long id) {
		log.debug("getting MiurScuole instance with id: " + id);
		try {
			MiurScuole instance = (MiurScuole) sessionFactory.getCurrentSession()
					.get("luiss.it.Orientamento.dao.MiurScuole", id);
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

	public List findByExample(MiurScuole instance) {
		log.debug("finding MiurScuole instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("luiss.it.Orientamento.dao.MiurScuole")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
