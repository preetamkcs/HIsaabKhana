package com.preetam.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.preetam.hibernate.mappings.HkUser;

/**
 * A data access object (DAO) providing persistence and search support for
 * HkUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.preetam.hibernate.mappings.HkUser
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class HkUserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(HkUserDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String EMAIL = "email";
	public static final String MOBILE = "mobile";
	public static final String ADDRESS = "address";
	public static final String USER_TYPE = "userType";
	public static final String AVATAR = "avatar";
	public static final String GENDER = "gender";
	public static final String PASSWORD = "password";
	public static final String STATUS = "status";

	public void save(HkUser transientInstance) {
		log.debug("saving HkUser instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(HkUser persistentInstance) {
		log.debug("deleting HkUser instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HkUser findById(java.lang.Integer id) {
		log.debug("getting HkUser instance with id: " + id);
		try {
			HkUser instance = (HkUser) getSession().get(
					"com.preetam.hibernate.mappings.HkUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(HkUser instance) {
		log.debug("finding HkUser instance by example");
		try {
			List results = getSession().createCriteria(
					"com.preetam.hibernate.mappings.HkUser").add(
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
		log.debug("finding HkUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from HkUser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByUserType(Object userType) {
		return findByProperty(USER_TYPE, userType);
	}

	public List findByAvatar(Object avatar) {
		return findByProperty(AVATAR, avatar);
	}

	public List findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all HkUser instances");
		try {
			String queryString = "from HkUser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public HkUser merge(HkUser detachedInstance) {
		log.debug("merging HkUser instance");
		try {
			HkUser result = (HkUser) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(HkUser instance) {
		log.debug("attaching dirty HkUser instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HkUser instance) {
		log.debug("attaching clean HkUser instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}