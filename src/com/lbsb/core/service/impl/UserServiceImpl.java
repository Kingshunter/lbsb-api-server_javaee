package com.lbsb.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbsb.core.dao.UserDao;
import com.lbsb.core.model.User;
import com.lbsb.core.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	

	public User getUserById(int userId) {
		System.out.println("222");
		
		return userDao.getUserById(userId);
	}
	
	
}
