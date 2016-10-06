package com.preetam.hibernate.mappings;

import java.sql.Timestamp;

import com.preetam.beans.UserInfo;

/**
 * HkUser entity. @author MyEclipse Persistence Tools
 */

public class HkUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2920334709415125715L;
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
	private String password;

	// Constructors

	/** default constructor */
	public HkUser() {
	}

	/** minimal constructor */
	public HkUser(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password= password;
		this.regstrationDate=new Timestamp(System.currentTimeMillis());
		this.status = "ACTIVE";
	}

	/** full constructor */
	public HkUser(String userName, String firstName, String lastName,
			String email, Integer mobile, String address, String userType,
			String avatar, String gender, String password,String status) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.userType = userType;
		this.avatar = avatar;
		this.gender = gender;
		this.status = status;
		this.password=password;
	}
	public UserInfo getUserInfo() {
		return new UserInfo(userId, userName, firstName, lastName, email, mobile, address, userType, avatar, gender, regstrationDate, status);
	}
	
	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMobile() {
		return this.mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setRegstrationDate(Timestamp regstrationDate) {
		this.regstrationDate = regstrationDate;
	}

	public Timestamp getRegstrationDate() {
		return regstrationDate;
	}

}