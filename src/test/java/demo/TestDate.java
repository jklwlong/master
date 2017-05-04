package demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		String before = "2013-5-15"; 
        String now = "2013-5-17"; 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        try { 
            Date d1 = sdf.parse(before); 
            Date d2 = sdf.parse(now); 
            long daysBetween = (d2.getTime() - d1.getTime() + 1000000) 
                    / (3600 * 24 * 1000); 
            System.out.println(daysBetween<5); 
        } catch (Exception e) { 
            System.out.println(e.getMessage()); 
        } 
	}
	
}
