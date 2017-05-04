package demo;

import com.gr.common.utils.RedisUtil;

public class Test4 {
	public static void main(String[] args) {
		RedisUtil.setString("jkl", RedisUtil.EXRP_HOUR, "111222233333");
		System.out.println(RedisUtil.getString("jkl"));
	}
}
