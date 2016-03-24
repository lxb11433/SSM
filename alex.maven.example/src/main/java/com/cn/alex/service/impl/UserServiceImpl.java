package com.cn.alex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.alex.dao.IUserDao;
import com.cn.alex.model.User;
import com.cn.alex.service.IUserService;
@Service("userService") 
public class UserServiceImpl implements IUserService {

	@Autowired  
    private IUserDao userDao;  
	@Override
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);  
	}

}
