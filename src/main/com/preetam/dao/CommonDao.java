package com.preetam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.preetam.hibernate.mappings.HkUserLoginStatus;

public class CommonDao {
	private static CommonDao instance=null;
	private CommonDao() {
	}
	public static CommonDao getInstace() {
		return instance==null?new CommonDao():instance;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isLoggedIn(Integer userId, String sessionId, Session session) {
		List<HkUserLoginStatus> loginList= session.createCriteria(HkUserLoginStatus.class)
		.add(Restrictions.eq(HkUserLoginStatusDAO.USER_ID,userId))
		.add(Restrictions.eq(HkUserLoginStatusDAO.LOGIN_STATUS,"LOGGED_IN"))
		.add(Restrictions.eq(HkUserLoginStatusDAO.SESSION_ID,sessionId)).setCacheable(true)
		.list();
		return loginList.size()!=0;
	}

}
