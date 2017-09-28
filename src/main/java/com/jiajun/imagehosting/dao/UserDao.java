package com.jiajun.imagehosting.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jiajun.common.base.BaseDao;
import com.jiajun.imagehosting.domain.UserEntity;

@Repository
public class UserDao extends BaseDao<UserEntity> {

	@Override
	protected String getNamespace() {
		return "userEntityMapper";
	}
	
	public UserEntity selectByUsernameAndPw(String username, String password) {
		Map<String, String> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);
		return (UserEntity) selectObject("selectByUsernameAndPw", params);
	}
}
