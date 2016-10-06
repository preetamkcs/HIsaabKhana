package com.preetam.hibernate.mappings;

/**
 * HkShareMap entity. @author MyEclipse Persistence Tools
 */

public class HkShareMap implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private HkUser user;
	private HkTransaction txn;
	private String shareType;
	private String status;

	// Constructors

	/** default constructor */
	public HkShareMap() {
	}

	/** full constructor */
	public HkShareMap(HkUser user, HkTransaction txn, String shareType,
			String status) {
		this.setUser(user);
		this.setTxn(txn);
		this.shareType = shareType;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShareType() {
		return this.shareType;
	}

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUser(HkUser user) {
		this.user = user;
	}

	public HkUser getUser() {
		return user;
	}

	public void setTxn(HkTransaction txn) {
		this.txn = txn;
	}

	public HkTransaction getTxn() {
		return txn;
	}

}