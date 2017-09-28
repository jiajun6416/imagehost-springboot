package com.jiajun.imagehosting.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.jiajun.imagehosting.dao.UserDao;
import com.jiajun.imagehosting.domain.UserEntity;
import com.jiajun.imagehosting.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserEntity getByUsernameAndPw(String username, String password) throws Exception {
		Assert.notNull(username, "username can not be null");
		Assert.notNull(password, "password can not be null");
		return userDao.selectByUsernameAndPw(username, password);
	}

	@Override
	public void updateLoginInfo(Integer userId, String loginIp) throws Exception {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userId);
		userEntity.setLastLogin(new Date());
		userEntity.setLoginIp(loginIp);
		userDao.updateByPrimaryKeySelective(userEntity);
	}
}
