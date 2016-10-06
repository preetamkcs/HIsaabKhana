package com.preetam.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.preetam.hibernate.mappings.HkTransaction;

/**
 * A data access object (DAO) providing persistence and search support for
 * HkTransaction entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.preetam.hibernate.mappings.HkTransaction
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class HkTransactionDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HkTransactionDAO.class);
	// property constants
	public static final String AMOUNT = "amount";
	public static final String USER_ID = "userId";
	public static final String DESCRIPTION = "description";
	public static final String STATUS = "status";

	public void save(HkTransaction transientInstance) {
		log.debug("saving HkTransaction instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(HkTransaction persistentInstance) {
		log.debug("deleting HkTransaction instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HkTransaction findById(java.lang.Integer id) {
		log.debug("getting HkTransaction instance with id: " + id);
		try {
			HkTransaction instance = (HkTransaction) getSession().get(
					"com.preetam.hibernate.mappings.HkTransaction", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(HkTransaction instance) {
		log.debug("finding HkTransaction instance by example");
		try {
			List results = getSession().createCriteria(
					"com.preetam.hibernate.mappings.HkTransaction").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding HkTransaction instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from HkTransaction as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all HkTransaction instances");
		try {
			String queryString = "from HkTransaction";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public HkTransaction merge(HkTransaction detachedInstance) {
		log.debug("merging HkTransaction instance");
		try {
			HkTransaction result = (HkTransaction) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(HkTransaction instance) {
		log.debug("attaching dirty HkTransaction instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HkTransaction instance) {
		log.debug("attaching clean HkTransaction instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}