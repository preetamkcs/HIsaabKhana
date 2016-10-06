package com.preetam.core;

import org.hibernate.Session;

import com.preetam.beans.UserInfo;
import com.preetam.dao.CommonDao;
import com.preetam.hibernate.HibernateSessionFactory;

public class Common {
	private static Common instance=null;
	private Common() {
	}
	public static Common getInstace() {
		return instance==null?new Common():instance;
	}
	public static void cleanUp(Session session) {
		if(session!=null && session.isOpen())
			session.close();
	}
	public boolean isSessionValid(UserInfo usrInfo,String sessionId) {
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			return CommonDao.getInstace().isLoggedIn(usrInfo.getUserId(),sessionId,session);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			cleanUp(session);
		}
	}
	
}
