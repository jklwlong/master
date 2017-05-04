package demo;

public class TestThread {

	public static void main(String[] args) throws Exception{
		
		Runner1 r = new Runner1();
		Thread t = new Thread(r);
		Runner1 r1 = new Runner1();
		Thread t1 = new Thread(r1);
		t.start();
		t1.start();
	}
	

}
class Runner1 implements Runnable {

	public void run() {

		System.out.println(11);

	}

}