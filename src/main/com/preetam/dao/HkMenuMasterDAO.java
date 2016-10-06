package com.preetam.dao;

import com.preetam.hibernate.mappings.HkMenuMaster;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * HkMenuMaster entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.preetam.hibernate.mappings.HkMenuMaster
 * @author MyEclipse Persistence Tools
 */

public class HkMenuMasterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HkMenuMasterDAO.class);
	// property constants
	public static final String DISPLAY_TEXT = "displayText";
	public static final String PARENT_ID = "parentId";
	public static final String ACTION_URL = "actionUrl";
	public static final String STATUS = "status";
	public static final String DESCRIPTION = "description";

	public void save(HkMenuMaster transientInstance) {
		log.debug("saving HkMenuMaster instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(HkMenuMaster persistentInstance) {
		log.debug("deleting HkMenuMaster instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HkMenuMaster findById(java.lang.Integer id) {
		log.debug("getting HkMenuMaster instance with id: " + id);
		try {
			HkMenuMaster instance = (HkMenuMaster) getSession().get(
					"com.preetam.hibernate.mappings.HkMenuMaster", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(HkMenuMaster instance) {
		log.debug("finding HkMenuMaster instance by example");
		try {
			List results = getSession().createCriteria(
					"com.preetam.hibernate.mappings.HkMenuMaster").add(
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
		log.debug("finding HkMenuMaster instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from HkMenuMaster as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDisplayText(Object displayText) {
		return findByProperty(DISPLAY_TEXT, displayText);
	}

	public List findByParentId(Object parentId) {
		return findByProperty(PARENT_ID, parentId);
	}

	public List findByActionUrl(Object actionUrl) {
		return findByProperty(ACTION_URL, actionUrl);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all HkMenuMaster instances");
		try {
			String queryString = "from HkMenuMaster";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public HkMenuMaster merge(HkMenuMaster detachedInstance) {
		log.debug("merging HkMenuMaster instance");
		try {
			HkMenuMaster result = (HkMenuMaster) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(HkMenuMaster instance) {
		log.debug("attaching dirty HkMenuMaster instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HkMenuMaster instance) {
		log.debug("attaching clean HkMenuMaster instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}