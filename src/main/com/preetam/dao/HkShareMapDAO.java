package com.preetam.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.preetam.hibernate.mappings.HkShareMap;

/**
 * A data access object (DAO) providing persistence and search support for
 * HkShareMap entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.preetam.hibernate.mappings.HkShareMap
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("unchecked")
public class HkShareMapDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HkShareMapDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String TXN_ID = "txnId";
	public static final String SHARE_TYPE = "shareType";
	public static final String STATUS = "status";

	public void save(HkShareMap transientInstance) {
		log.debug("saving HkShareMap instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(HkShareMap persistentInstance) {
		log.debug("deleting HkShareMap instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HkShareMap findById(java.lang.Integer id) {
		log.debug("getting HkShareMap instance with id: " + id);
		try {
			HkShareMap instance = (HkShareMap) getSession().get(
					"com.preetam.hibernate.mappings.HkShareMap", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(HkShareMap instance) {
		log.debug("finding HkShareMap instance by example");
		try {
			List results = getSession().createCriteria(
					"com.preetam.hibernate.mappings.HkShareMap").add(
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
		log.debug("finding HkShareMap instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from HkShareMap as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByTxnId(Object txnId) {
		return findByProperty(TXN_ID, txnId);
	}

	public List findByShareType(Object shareType) {
		return findByProperty(SHARE_TYPE, shareType);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all HkShareMap instances");
		try {
			String queryString = "from HkShareMap";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public HkShareMap merge(HkShareMap detachedInstance) {
		log.debug("merging HkShareMap instance");
		try {
			HkShareMap result = (HkShareMap) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(HkShareMap instance) {
		log.debug("attaching dirty HkShareMap instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HkShareMap instance) {
		log.debug("attaching clean HkShareMap instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}