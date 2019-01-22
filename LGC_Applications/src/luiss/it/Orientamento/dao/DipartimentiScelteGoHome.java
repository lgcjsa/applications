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
 * Home object for domain model class DipartimentiScelteGo.
 * @see luiss.it.Orientamento.dao.DipartimentiScelteGo
 * @author Hibernate Tools
 */
public class DipartimentiScelteGoHome {

	private static final Log log = LogFactory.getLog(DipartimentiScelteGoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(DipartimentiScelteGo transientInstance) {
		log.debug("persisting DipartimentiScelteGo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DipartimentiScelteGo instance) {
		log.debug("attaching dirty DipartimentiScelteGo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DipartimentiScelteGo instance) {
		log.debug("attaching clean DipartimentiScelteGo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DipartimentiScelteGo persistentInstance) {
		log.debug("deleting DipartimentiScelteGo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DipartimentiScelteGo merge(DipartimentiScelteGo detachedInstance) {
		log.debug("merging DipartimentiScelteGo instance");
		try {
			DipartimentiScelteGo result = (DipartimentiScelteGo) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DipartimentiScelteGo findById(int id) {
		log.debug("getting DipartimentiScelteGo instance with id: " + id);
		try {
			DipartimentiScelteGo instance = (DipartimentiScelteGo) sessionFactory.getCurrentSession()
					.get("luiss.it.Orientamento.dao.DipartimentiScelteGo", id);
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

	public List findByExample(DipartimentiScelteGo instance) {
		log.debug("finding DipartimentiScelteGo instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("luiss.it.Orientamento.dao.DipartimentiScelteGo").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
