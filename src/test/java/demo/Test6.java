package demo;

import java.util.Random;

public class Test6 {
	// ����
	public static int jz = 5;
	// �㽶
	public static int xj = 3;
	// ƻ��
	public static int pg = 2;

	public static void main(String[] args) {
		Random rd = new Random();
		int tempInt = rd.nextInt(10);//1
		
		System.out.print("tempInt====" + tempInt);
		if (tempInt >= 0 && tempInt <= jz) {//0.5
			System.out.println("����");
		} else if (tempInt > jz && tempInt <= xj + jz) {//0.3
			System.out.println("�㽶");
		} else if (tempInt > xj && tempInt <= pg + xj + jz) {//0.2
			System.out.println("ƻ��");
		}
	}

}
