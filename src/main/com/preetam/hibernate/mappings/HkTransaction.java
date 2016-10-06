package com.preetam.hibernate.mappings;

import java.sql.Timestamp;

/**
 * HkTransaction entity. @author MyEclipse Persistence Tools
 */

public class HkTransaction implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer txnId;
	private Integer amount;
	private Timestamp date;
	private Integer userId;
	private String description;
	private String status;

	// Constructors

	/** default constructor */
	public HkTransaction() {
	}

	/** minimal constructor */
	public HkTransaction(Integer amount, Timestamp date, Integer userId,
			String status) {
		this.amount = amount;
		this.date = date;
		this.userId = userId;
		this.status = status;
	}

	/** full constructor */
	public HkTransaction(Integer amount, Timestamp date, Integer userId,
			String description, String status) {
		this.amount = amount;
		this.date = date;
		this.userId = userId;
		this.description = description;
		this.status = status;
	}

	// Property accessors

	public Integer getTxnId() {
		return this.txnId;
	}

	public void setTxnId(Integer txnId) {
		this.txnId = txnId;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}