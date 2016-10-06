package com.preetam.beans;

import java.io.Serializable;

public class CommonRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}
