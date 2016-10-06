package com.preetam.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private Integer userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private Integer mobile;
	private String address;
	private String userType;
	private String avatar;
	private String gender;
	private Timestamp regstrationDate;
	private String status;

	public UserInfo(Integer userId, String userName, String firstName,
			String lastName, String email, Integer mobile, String address,
			String userType, String avatar, String gender,
			Timestamp regstrationDate, String status) {
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.userType = userType;
		this.avatar = avatar;
		this.gender = gender;
		this.regstrationDate = regstrationDate;
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMobile() {
		return mobile;
	}
	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Timestamp getRegstrationDate() {
		return regstrationDate;
	}
	public void setRegstrationDate(Timestamp regstrationDate) {
		this.regstrationDate = regstrationDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
