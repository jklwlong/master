package com.gr.user.service;

import java.util.List;
import java.util.Map;

import com.gr.common.domain.UserDomain;

public interface UserService {

	List<UserDomain> queryAll();

	Map<String, String> queryOne();

	void insertAll();

}
