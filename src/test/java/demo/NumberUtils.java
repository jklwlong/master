package demo;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberUtils {
	public static double format(double d, String format) {
		DecimalFormat df = new DecimalFormat(format);
		String ds = df.format(d);
		return Double.parseDouble(ds);
	}
	/**
	 * 姝ゆ硶閬囧埌5杩�
	 * 閫氱敤
	 * @param d
	 * @param format
	 * @return String
	 */
	public static String formatUp(double d, String format) {
		DecimalFormat    df   = new DecimalFormat(format);
		String ds = df.format(d);
		return ds;
	}
	/**
	 * 姝ゆ柟娉曢亣鍒板埌5 鑸嶅幓
	 * @param d
	 * @return
	 */
	public static double format2(double d) {
		// 鍥涜垗鍏叆浜旇�冭檻锛屼簲鍚庨潪闆跺氨杩涗竴锛屼簲鍚庣殕闆剁湅濂囧伓锛屼簲鍓嶄负鍋跺簲鑸嶅幓锛屼簲鍓嶄负濂囪杩涗竴
		BigDecimal big = BigDecimal.valueOf(d);
		big = big.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return big.doubleValue();
	}
	/**
	 * 姝ゆ柟娉曢亣鍒板埌5 鑸嶅幓
	 * @param d
	 * @return
	 */
	public static double formatTo2(double d) {
		DecimalFormat df = new DecimalFormat("0.00");
		String ds = df.format(d);
		return Double.parseDouble(ds);
	}
	
	/**
	 * 姝ゆ柟娉曢亣鍒板埌5鍏�
	 * @param d
	 * @return
	 */
	public static double formatup2(double d) {
		BigDecimal big = BigDecimal.valueOf(d);
		big = big.setScale(2, BigDecimal.ROUND_HALF_UP);
		return big.doubleValue();
	}
	
	/**
	 * 姝ゆ柟娉曢亣鍒板埌5鍏ヤ繚鐣欐暣鏁�
	 * @param d
	 * @return
	 */
	public static double formatup3(double d) {
		BigDecimal big = BigDecimal.valueOf(d);
		big = big.setScale(0, BigDecimal.ROUND_HALF_UP);
		return big.doubleValue();
	}
	
	/**
	 * 姝ゆ柟娉曢亣鍒颁繚鐣欎袱浣嶏紝鐩存帴鍏�,娌℃湁鑸�
	 * @param d
	 * @return
	 */
	public static double getDoubleFormat2Up(double d) {
		BigDecimal big = BigDecimal.valueOf(d);
		big = big.setScale(2, BigDecimal.ROUND_UP);
		return big.doubleValue();
	}

	public static String format2Str(double d) {
		DecimalFormat df = new DecimalFormat("0.0");
		String ds = df.format(d);
		return ds;
	}

	public static String format3Str(double d) {
		DecimalFormat df = new DecimalFormat("0.000");
		String ds = df.format(d);
		return ds;
	}

	public static double format4(double d) {
		DecimalFormat df = new DecimalFormat("0.0000");
		String ds = df.format(d);
		return Double.parseDouble(ds);
	}

	public static double format6(double d) {
		DecimalFormat df = new DecimalFormat("0.000000");
		String ds = df.format(d);
		return Double.parseDouble(ds);
	}

	public static double getDouble(String str) {
		if (str == null || str.equals(""))
			return 0.0;
		double ret = 0.0;
		try {
			ret = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			ret = 0.0;
		}
		return format6(ret);
	}

	public static long getLong(String str) {
		if (str == null || str.equals(""))
			return 0L;
		long ret = 0;
		try {
			ret = Long.parseLong(str);
		} catch (NumberFormatException e) {
			ret = 0;
		}
		return ret;
	}

	public static Long[] getLongs(String[] str) {

		if (str == null || str.length < 1)
			return new Long[] { 0L };
		Long[] ret = new Long[str.length];
		for (int i = 0; i < str.length; i++) {
			ret[i] = getLong(str[i]);
		}
		return ret;
	}
	
	public static Double[] getDoubles(String[] str) {
		if (str == null || str.length < 1)
			return new Double[] { 0d };
		Double[] ret = new Double[str.length];
		for (int i = 0; i < str.length; i++) {
			ret[i] = getDouble(str[i]);
		}
		return ret;
	}

	public static int[] getInts(String[] str) {

		if (str == null || str.length < 1)
			return new int[] { 0 };
		int[] ret = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			ret[i] = getInt(str[i]);
		}
		return ret;
	}

	public static int getInt(String str) {
		if (str == null || str.equals(""))
			return 0;
		int ret = 0;
		try {
			ret = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			ret = 0;
		}
		return ret;
	}

	public static int compare(double x, double y) {
		BigDecimal val1 = new BigDecimal(x);
		BigDecimal val2 = new BigDecimal(y);
		return val1.compareTo(val2);
	}

	/**
	 * @param d
	 * @param len
	 * @return
	 */
	public static double ceil(double d, int len) {
		String str = Double.toString(d);
		int a = str.indexOf(".");
		if (a + 3 > str.length()) {
			a = str.length();
		} else {
			a = a + 3;
		}
		str = str.substring(0, a);
		return Double.parseDouble(str);
	}

	public static double ceil(double d) {
		return ceil(d, 2);
	}

	public static long getRandom(int len) {
		double r = Math.random();
		for (int i = 0; i < len; i++) {
			r = r * 10;
		}
		long ret = (long) r;
		return ret;
	}

	/**
	 * 鐢ㄤ簬涓や釜灏忔暟鐩稿噺锛屼娇鐢╞igdecimai璁＄畻锛岄伩鍏嶅嚭鐜拌宸�
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static double subtract(double num1, double num2) {

		BigDecimal numa = new BigDecimal(num1 * 100000);
		BigDecimal numb = new BigDecimal(num2 * 100000);
		double result = numa.subtract(numb).doubleValue() / 100000;
		return result;
	}

	/**
	 * 涓ゆ暟鐩稿姞
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static double add(double num1, double num2) {

		BigDecimal numa = new BigDecimal(num1 * 100000);
		BigDecimal numb = new BigDecimal(num2 * 100000);
		double result = numa.add(numb).doubleValue() / 100000;
		return result;
	}
	
	/**
	 * 涓ゆ暟鐩镐箻杞崲涓簊tring
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String multiplyToString(double num1, double num2) {
		
		BigDecimal numa = new BigDecimal(num1);
		BigDecimal numb = new BigDecimal(num2);
		return format2Str(numa.multiply(numb).doubleValue());
	}
	
	/**
	 * 涓ゆ暟鐩镐箻
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static double multiply(double num1, double num2) {
		
		BigDecimal numa = new BigDecimal(num1);
		BigDecimal numb = new BigDecimal(num2);
		return format2(numa.multiply(numb).doubleValue());
	}
	
	/**
	 * 涓ゆ暟鐩搁櫎淇濈暀涓や綅灏忔暟
	 * @param d1
	 * @param d2
	 * @param len
	 * @return
	 */
	public static double div(double d1,double d2) {
		BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
       return b1.divide(b2,2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static double getDouble2(String numStr) {
		double num = NumberUtils.getDouble(numStr);
		return format2(num);
	}
	
	/**
	 * 灏忔暟鐐瑰悗鏈夊垯杩�1
	 * @param num
	 * @return
	 */
	public static int getIntWithDouble(double num){
		long num2 =getLong(String.valueOf(num).replaceAll("\\d+\\.", ""));
		if(num2>0){
			 return (int)num+1;
		}
		return getInt((int)num+"");
	}
	
	public static String formartToMoneyStr(double num){
		DecimalFormat fm1=new DecimalFormat("###,###,###");
		return fm1.format(num);
	}
	
}
