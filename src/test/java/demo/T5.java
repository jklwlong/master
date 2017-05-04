package demo;

import java.util.Date;

public class T5 {
	public static void main(String[] args) {
		try {
			System.out.println(new Date());
			Thread.sleep(2000);
			System.out.println(new Date());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
