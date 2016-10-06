package com.preetam.exception;

public class HKException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	private int errorCode;

	public HKException(String msg) {
		super(msg);
		message=msg;
	}

	public HKException(String msg, int errCode) {
		super(msg);
		message=msg;
		errorCode=errCode;
	}

}
