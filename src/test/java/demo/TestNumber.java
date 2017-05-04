package demo;


public class TestNumber {

	public static void main(String[] args) {
		String a = null;
		try {
			Double.valueOf(a);
		} catch (Exception e) {
			throw e;
		}
		
	}

}
