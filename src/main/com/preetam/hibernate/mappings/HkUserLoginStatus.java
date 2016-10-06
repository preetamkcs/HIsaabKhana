package com.preetam.hibernate.mappings;

import java.sql.Timestamp;

/**
 * HkUserLoginStatus entity. @author MyEclipse Persistence Tools
 */

public class HkUserLoginStatus implements java.io.Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Integer userId;
	private String loginStatus;
	private Timestamp activityDate;
	private String sessionId;

	// Constructors

	/** default constructor */
	public HkUserLoginStatus() {
	}

	/** minimal constructor */
	public HkUserLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	/** full constructor */
	public HkUserLoginStatus(Integer userId, String loginStatus,
			Timestamp activityDate,String sessionId) {
		this.userId = userId;
		this.loginStatus = loginStatus;
		this.activityDate = activityDate;
		this.sessionId=sessionId;
	}
	
	public HkUserLoginStatus update(HkUserLoginStatus from) {
		if (from!=null)
			if (from.getId()!=null)
				id=from.getId();
			if (from.getActivityDate()!=null)
				activityDate=from.getActivityDate();
			if (from.getLoginStatus()!=null)
				loginStatus=from.getLoginStatus();
			if (from.getSessionId()!=null)
				sessionId=from.getSessionId();
			if (from.getUserId()!=null)
				userId=from.getUserId();
		return this;
	}
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginStatus() {
		return this.loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public Timestamp getActivityDate() {
		return this.activityDate;
	}

	public void setActivityDate(Timestamp activityDate) {
		this.activityDate = activityDate;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionId() {
		return sessionId;
	}

}