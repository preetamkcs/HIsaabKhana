package com.preetam.controller;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.preetam.beans.LoginBean;
import com.preetam.beans.RegistrationBean;
import com.preetam.beans.UserInfo;
import com.preetam.core.Common;
import com.preetam.dao.UserDao;
import com.preetam.exception.HKErrorCode;
import com.preetam.exception.HKErrorMessage;
import com.preetam.exception.HKException;
import com.preetam.hibernate.HibernateSessionFactory;
import com.preetam.hibernate.mappings.HkUser;
import com.preetam.hibernate.mappings.HkUserLoginStatus;
/**
 * 
 * @author Preetam Kumar
 *
 */
public class UserController {
	private Logger logger = Logger.getLogger(this.getClass());
	private static UserController instance; 
	private UserController() {
	}
	
	public static UserController getInstance() {
		return instance==null?new UserController():instance;
	}
	
	public HkUser doRegister(RegistrationBean details) throws HKException {
		Session session=null;
		HkUser user=null;
		try {
			logger.debug("REGISTERATION START");
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			UserDao.getInstance().doRegister(details, session);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw new HKException(HKErrorMessage.GEN_HIBERNATE_EXCEPTION, HKErrorCode.GEN_HIBERNATE_EXCEPTION);
		}catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw new HKException(HKErrorMessage.GEN_SOME_INTERNAL_ERROR, HKErrorCode.GEN_SOME_INTERNAL_ERROR);
		}finally{
			Common.cleanUp(session);
		}
		logger.debug("REGISTERATION END[OK]");
		return user;
	}

	public Integer isUserAvailble(RegistrationBean regBean) {
		Session session=null;
		try {
			session = HibernateSessionFactory.getSession();
			return UserDao.getInstance().isUserAvailble(session,regBean);
		}catch (Exception e) {
			e.printStackTrace();
			
			return -1;
		}finally{
			Common.cleanUp(session);
		}
	}

	public UserInfo doLogin(LoginBean loginInfo,String sessionId) throws HKException {
		Session session=null;
		UserInfo usrInfo=null;
		try {
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			logger.info("AUTHENTICATING USER...");
			List<HkUser> userList=UserDao.getInstance().doAuthenticate(loginInfo,session);
			if(userList.size()!=0){
				usrInfo=userList.get(0).getUserInfo();
				logger.info("USER AUTHENTICATED["+usrInfo.getUserId()+"][OK]");
			}else {
				logger.info("INVALID USER LOGIN DETAILS!");
			}
			if (usrInfo!=null) 
				UserDao.getInstance().setLoginStatus(session, new HkUserLoginStatus(usrInfo.getUserId(), "LOGGED_IN", new Timestamp(System.currentTimeMillis()), sessionId));
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new HKException(HKErrorMessage.GEN_SOME_INTERNAL_ERROR, HKErrorCode.GEN_SOME_INTERNAL_ERROR);
		}finally{
			Common.cleanUp(session);
		}
		return usrInfo;
	}
}
