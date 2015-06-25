package com.jfshare.user.util;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtils {

	public static String enCode(String password) {
		if(password != null) {
			return DigestUtils.md5Hex(password);
		}
		return null;
	}
	
	public static void main(String[] args) {
		if(args.length > 0) {
			String password = args[0];
			String encodeText = PasswordUtils.enCode(password);
			System.out.println(encodeText);
		} else {
			System.out.println("Faild, please run with a password argument.");
		}
	}
}
