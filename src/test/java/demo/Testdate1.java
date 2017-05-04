package demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Testdate1 {
	public static void main(String[] args) throws Exception {
		String start = "2012-02-01";
		String end = "2012-03-02";
		List<String> lDate = findDates(start, end);
		for (String date : lDate) {
			System.out.println(date);
		}
	}

	/**
	 * 获取一个时间段内所有的日期
	 * 
	 * @param dBegin
	 * @param dEnd
	 * @return
	 */
	public static List<String> findDates(String start, String end) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dBegin = sdf.parse(start);
			Date dEnd = sdf.parse(end);
			List<String> lDate = new ArrayList<String>();
			lDate.add(start);
			Calendar calBegin = Calendar.getInstance();
			calBegin.setTime(dBegin);
			Calendar calEnd = Calendar.getInstance();
			calEnd.setTime(dEnd);
			// 测试此日期是否在指定日期之后
			while (dEnd.after(calBegin.getTime())) {
				calBegin.add(Calendar.DAY_OF_MONTH, 1);
				lDate.add(sdf.format(calBegin.getTime()));
			}
			return lDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
