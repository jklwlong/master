package demo;

import java.util.Random;

public class Test6 {
	// éÙ×Ó
	public static int jz = 5;
	// Ïã½¶
	public static int xj = 3;
	// Æ»¹û
	public static int pg = 2;

	public static void main(String[] args) {
		Random rd = new Random();
		int tempInt = rd.nextInt(10);//1
		
		System.out.print("tempInt====" + tempInt);
		if (tempInt >= 0 && tempInt <= jz) {//0.5
			System.out.println("éÙ×Ó");
		} else if (tempInt > jz && tempInt <= xj + jz) {//0.3
			System.out.println("Ïã½¶");
		} else if (tempInt > xj && tempInt <= pg + xj + jz) {//0.2
			System.out.println("Æ»¹û");
		}
	}

}
