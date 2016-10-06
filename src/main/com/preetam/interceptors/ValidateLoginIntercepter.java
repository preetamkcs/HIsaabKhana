package com.preetam.interceptors;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.preetam.beans.UserInfo;
import com.preetam.core.Common;

public class ValidateLoginIntercepter extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(ValidateLoginIntercepter.class);
	@Override
	public String intercept(ActionInvocation actionInvoc) throws Exception {
			logger.info("INTERCEPTING REQUEST FOR A VALID SESSION...");
			HttpSession session= ServletActionContext.getRequest().getSession();
			UserInfo infoBean=(UserInfo)session.getAttribute("userInfo");
			if(infoBean!=null && Common.getInstace().isSessionValid(infoBean, session.getId())){
				logger.info("[ACCESS AUTHORIZED]");
				return actionInvoc.invoke();
			}
			else {
				logger.info("[ACCESS RESTRICTED!]");
				return "login";
			}
	}

}
