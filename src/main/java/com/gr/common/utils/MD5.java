/**
 * www.yuanbaopu.com
 */
package com.gr.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 
 * MD5鍔犲瘑绫�
 * 
 * @author licx
 *
 *         2015骞�8鏈�28鏃�
 */
public class MD5 {
	public static final int LENGTH_16 = 16;
	public static final int LENGTH_32 = 32;

	public static String encode(String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return encode(s, 16);
	}

	public static String encode(String s, int length) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		StringBuffer hexValue = new StringBuffer();
		byte[] md5Bytes = md5.digest(s.getBytes("utf-8"));
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = md5Bytes[i] & 0xFF;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		if (length == 32) {
			return hexValue.toString();
		}
		return hexValue.toString().substring(8, 24);
	}

	public static String[] autoMD5() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String[] str = new String[2];
		Integer ranVal = Integer.valueOf(Math.abs(new Random().nextInt()) % 100000000);
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		StringBuffer hexValue = new StringBuffer();
		byte[] md5Bytes = md5.digest(ranVal.toString().getBytes("utf-8"));
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = md5Bytes[i] & 0xFF;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		str[0] = ranVal.toString();
		str[1] = hexValue.toString().substring(8, 24);
		return str;
	}
}