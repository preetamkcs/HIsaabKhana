package com.preetam.action;

import java.io.File;
import java.io.IOException;

import com.preetam.beans.LoginBean;
import com.preetam.beans.RegistrationBean;
import com.preetam.beans.UserInfo;
import com.preetam.controller.UserController;
import com.preetam.exception.HKErrorMessage;

/**
 * 
 * @author Preetam Kumar
 * 
 */

public class UserAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RegistrationBean regInfo;
	private LoginBean loginInfo;
	private String message;
	private UserInfo userInfo;
	private File video;
	private String videoContentType;
	private String videoFileName;
	
	public String doRegister() {
		try {
			UserController.getInstance().doRegister(getRegInfo());
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(HKErrorMessage.GEN_SOME_INTERNAL_ERROR);
			message=HKErrorMessage.GEN_SOME_INTERNAL_ERROR;
			return ERROR;
		}
		return SUCCESS;
	}
	
	public void checkUserAvailble(){
		try {
			response.getWriter().write(""+UserController.getInstance().isUserAvailble(regInfo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//FIXME
	public String redirectHome() {
		return request.getSession().getAttribute("userInfo")!=null?"homeRedirect":SUCCESS;
	}
	
	public String doLogin() {
		try {
			userInfo= UserController.getInstance().doLogin(loginInfo,request.getSession().getId());
			if(userInfo==null)
				addActionError("Wrong username or password!");
			else 
				request.getSession().setAttribute("userInfo", userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			message=e.getMessage();
		}
		return userInfo!=null?SUCCESS:INPUT;
	}
	
	public String tempUpload() throws IOException{
		try {
			System.out.println(getVideo());
			System.out.println(getVideoContentType());
			System.out.println(getVideoFileName());
		} catch (Exception e) {
			e.printStackTrace();
			return NONE;
		}
		return SUCCESS;
	}
	
	public String logout() {
		request.getSession().invalidate();
		return LOGIN;
	} 
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setRegInfo(RegistrationBean regInfo) {
		this.regInfo = regInfo;
	}

	public RegistrationBean getRegInfo() {
		return regInfo;
	}

	public void setLoginInfo(LoginBean loginInfo) {
		this.loginInfo = loginInfo;
	}

	public LoginBean getLoginInfo() {
		return loginInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setVideo(File video) {
		this.video = video;
	}

	public File getVideo() {
		return video;
	}

	public void setVideoContentType(String videoContentType) {
		this.videoContentType = videoContentType;
	}

	public String getVideoContentType() {
		return videoContentType;
	}

	public void setVideoFileName(String videoFileName) {
		this.videoFileName = videoFileName;
	}

	public String getVideoFileName() {
		return videoFileName;
	}
}
