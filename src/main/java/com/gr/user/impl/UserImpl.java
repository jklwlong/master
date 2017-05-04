package com.gr.user.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gr.common.domain.UserDomain;
import com.gr.user.mapper.UserMapper;
import com.gr.user.service.UserService;

@Service
@Transactional
public class UserImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Override
	public List<UserDomain> queryAll() {
		// userMapper.insert();
		List<UserDomain> user = userMapper.queryAll();
		Runner1 r = new Runner1();
		Thread t = new Thread(r);
		t.start();
		return user;
	}
	@Override
	public Map<String, String> queryOne() {
		// TODO Auto-generated method stub
		return userMapper.queryOne();
	}
	
	@Override
	public void insertAll() {
		List<UserDomain> user = new ArrayList<UserDomain>();
		for (int i = 0; i < 10; i++) {
			UserDomain u = new UserDomain();
			u.setAge(String.valueOf(i));
			u.setEmail("email" + i);
			u.setUsername("name" + i);
			user.add(u);
		}
		int count = userMapper.insertAll(user);
		System.out.println(count);
	}
	
	class Runner1 implements Runnable {

		public void run() {
//			userMapper.insert();
			System.out.println(11);

		}

	}

}
