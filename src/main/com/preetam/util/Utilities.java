package com.preetam.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.struts2.util.tomcat.buf.HexUtils;

public class Utilities {
	public static String MD5Hash(String str) {
		String retval = null;
		try {
			if (str != null)
				retval = HexUtils.toHexString(MessageDigest.getInstance("MD5").digest(str.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return retval;
	}
//	public static void main(String[] args) {
//		System.out.println(MD5Hash("12345678"));
//	}
}
