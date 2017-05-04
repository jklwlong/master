package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.gr.common.domain.UserDomain;

public class TestJson {
	public static void main(String[] args) {
		UserDomain u = new UserDomain();
		UserDomain u1 = new UserDomain();
		UserDomain u2 = null;
		List<UserDomain> user = new ArrayList<UserDomain>();
		u.setId("1");
		u.setAge("15");
		u.setEmail("11111");
		u.setUsername("aaa");
		user.add(u);
		u1.setId("2");
		u1.setAge("15");
		u1.setEmail("22222");
		u1.setUsername("bbb");
		user.add(u1);
		String jsonString = JSON.toJSONString(user);
		String jsonString1= JSON.toJSONString(u);
		UserDomain a = JSON.parseObject(jsonString1,UserDomain.class);
//		List<UserDomain> user1 = JSON.parseArray(jsonString, UserDomain.class);
//		u2.setAge("11");
		System.out.println(JSON.toJSON(u));
//		Map<String, String> map = new HashMap<String, String>();
//		map.clear();
//		map.put("a", "2");
		System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
		
	}
}
