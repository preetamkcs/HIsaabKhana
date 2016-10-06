package com.preetam.dao;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.preetam.beans.LoginBean;
import com.preetam.beans.RegistrationBean;
import com.preetam.exception.HKErrorCode;
import com.preetam.exception.HKErrorMessage;
import com.preetam.exception.HKException;
import com.preetam.hibernate.mappings.HkUser;
import com.preetam.hibernate.mappings.HkUserLoginStatus;
import com.preetam.util.Utilities;

public class UserDao {
	private Logger logger = Logger.getLogger(this.getClass());
	private static UserDao instance = null;

	private UserDao() {
	}

	public static UserDao getInstance() {
		return instance == null ? new UserDao() : instance;
	}

	public HkUser doRegister(RegistrationBean details, Session session) throws NoSuchAlgorithmException {
		logger.debug("--entering");
		HkUser user = details.getUser();
		user.setPassword(Utilities.MD5Hash(details.getUserName()+':'+details.getPassword()));//FIXME improve hashing...
		session.save(user);
		logger.debug("--exiting--");
		return user;
	}

	@SuppressWarnings("unchecked")
	public Integer isUserAvailble(Session session, RegistrationBean regBean)
			throws HKException {
		Integer retval=null;
		try {

			Criteria crit = session.createCriteria(HkUser.class);
			Junction junc = Restrictions.disjunction().add(
					Restrictions.eq("userName", regBean.getUserName()));
			if (regBean.getEmail() != null)
				junc.add(Restrictions.eq("email", regBean.getEmail()));
			if (regBean.getMobile() != null)
				junc.add(Restrictions.eq("mobile", regBean.getMobile()));

			crit.add(junc).setProjection(
					Projections.projectionList().add(
							Projections.property("userName")).add(
							Projections.property("email")).add(
							Projections.property("mobile")));

			List<Object[]> userPropList = crit.list();
			short[] bitArray = new short[3];

			for (Object[] ob : userPropList) {
				if (regBean.getUserName().equalsIgnoreCase((String)ob[0]))
					bitArray[0] = 1;
				if (regBean.getEmail()!=null && regBean.getEmail().equals(ob[1]))
					bitArray[1] = 1;
				if (regBean.getMobile()!=null && regBean.getMobile() == (Integer) ob[0])
					bitArray[2] = 1;
			}
			retval= Integer.parseInt(""+bitArray[0]+bitArray[1]+bitArray[2],2);
			logger.info("bitArray:"+Arrays.toString(bitArray));
			
		} catch (HibernateException e) {
			throw new HKException(HKErrorMessage.GEN_HIBERNATE_EXCEPTION,
					HKErrorCode.GEN_HIBERNATE_EXCEPTION);
		}
		 return retval;
	}

	@SuppressWarnings("unchecked")
	public List<HkUser> doAuthenticate(LoginBean loginInfo, Session session) {
		Criteria crit=session.createCriteria(HkUser.class).add(Restrictions.eq("password", loginInfo.getPasswordHash()));
		if(loginInfo.getUserName()!=null && !loginInfo.getUserName().trim().isEmpty())
			return crit.add(Restrictions.eq("userName", loginInfo.getUserName())).list();
		else if(loginInfo.getEmail()!=null &&"".equals(loginInfo.getEmail().trim()))
			return crit.add(Restrictions.eq("email", loginInfo.getEmail())).list();
		else if(loginInfo.getMobile()!=null &&"".equals(loginInfo.getMobile()!=0))
			return crit.add(Restrictions.eq("mobile", loginInfo.getMobile())).list();
		else 
			return new ArrayList<HkUser>();
	}

	@SuppressWarnings("unchecked")
	public void setLoginStatus(Session session, HkUserLoginStatus loginStatus) {
		List<HkUserLoginStatus> lastStatus=session.createCriteria(HkUserLoginStatus.class).add(Restrictions.eq(HkUserLoginStatusDAO.USER_ID,loginStatus.getUserId())).setFetchSize(1).list();
		if (lastStatus.size()!=0) 
			session.update(lastStatus.get(0).update(loginStatus));
		else 
			session.save(loginStatus);
	}

	
}
