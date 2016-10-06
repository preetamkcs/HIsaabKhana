package com.preetam.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.preetam.hibernate.mappings.HkUserLoginStatus;

/**
 * A data access object (DAO) providing persistence and search support for
 * HkUserLoginStatus entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.preetam.hibernate.mappings.HkUserLoginStatus
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class HkUserLoginStatusDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HkUserLoginStatusDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String LOGIN_STATUS = "loginStatus";
	public static final String SESSION_ID = "sessionId";

	public void save(HkUserLoginStatus transientInstance) {
		log.debug("saving HkUserLoginStatus instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(HkUserLoginStatus persistentInstance) {
		log.debug("deleting HkUserLoginStatus instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HkUserLoginStatus findById(java.lang.Integer id) {
		log.debug("getting HkUserLoginStatus instance with id: " + id);
		try {
			HkUserLoginStatus instance = (HkUserLoginStatus) getSession().get(
					"com.preetam.hibernate.mappings.HkUserLoginStatus", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(HkUserLoginStatus instance) {
		log.debug("finding HkUserLoginStatus instance by example");
		try {
			List results = getSession().createCriteria(
					"com.preetam.hibernate.mappings.HkUserLoginStatus").add(
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
		log.debug("finding HkUserLoginStatus instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from HkUserLoginStatus as model where model."
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

	public List findByLoginStatus(Object loginStatus) {
		return findByProperty(LOGIN_STATUS, loginStatus);
	}

	public List findAll() {
		log.debug("finding all HkUserLoginStatus instances");
		try {
			String queryString = "from HkUserLoginStatus";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public HkUserLoginStatus merge(HkUserLoginStatus detachedInstance) {
		log.debug("merging HkUserLoginStatus instance");
		try {
			HkUserLoginStatus result = (HkUserLoginStatus) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(HkUserLoginStatus instance) {
		log.debug("attaching dirty HkUserLoginStatus instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HkUserLoginStatus instance) {
		log.debug("attaching clean HkUserLoginStatus instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}