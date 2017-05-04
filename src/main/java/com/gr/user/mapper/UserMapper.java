package com.gr.user.mapper;

import java.util.List;
import java.util.Map;

import com.gr.common.domain.UserDomain;

public interface UserMapper {

	List<UserDomain> queryAll();

	Map<String, String> queryOne();

	void insert();

	int insertAll(List<UserDomain> user);

}
