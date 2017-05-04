package demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test8 {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		//确定计算方法
		String str = "1";
	 MessageDigest md5=MessageDigest.getInstance("MD5");
//	String newstr=md5.digest(str.getBytes("utf-8"));	 
	 System.out.println(str.intern());
	}

}
