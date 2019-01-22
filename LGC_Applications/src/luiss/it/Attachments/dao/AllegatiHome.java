package luiss.it.Attachments.dao;
// Generated 5-nov-2018 9.08.29 by Hibernate Tools 5.2.6.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Allegati.
 * @see luiss.it.Attachments.dao.Allegati
 * @author Hibernate Tools
 */
public class AllegatiHome {

	private static final Log log = LogFactory.getLog(AllegatiHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Allegati transientInstance) {
		log.debug("persisting Allegati instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Allegati instance) {
		log.debug("attaching dirty Allegati instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Allegati instance) {
		log.debug("attaching clean Allegati instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Allegati persistentInstance) {
		log.debug("deleting Allegati instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Allegati merge(Allegati detachedInstance) {
		log.debug("merging Allegati instance");
		try {
			Allegati result = (Allegati) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Allegati findById(java.lang.Integer id) {
		log.debug("getting Allegati instance with id: " + id);
		try {
			Allegati instance = (Allegati) sessionFactory.getCurrentSession().get("luiss.it.Attachments.dao.Allegati",
					id);
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

	public List findByExample(Allegati instance) {
		log.debug("finding Allegati instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("luiss.it.Attachments.dao.Allegati")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
