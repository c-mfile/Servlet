package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.UserDao;
import com.zhiyou100.dao.impl.UserDaoImpl;
import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;
import com.zhiyou100.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	
	public User findById(int id) {
		return userDao.findById(id);
	}

	public User login(String name, String password) {
		// TODO Auto-generated method stub
		return userDao.login(name, password);
	}

	public void add(User e) {
		// TODO Auto-generated method stub
		userDao.add(e);
	}

	public void update(User e) {
		// TODO Auto-generated method stub
		userDao.update(e);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	public Role findRole(int id) {
		// TODO Auto-generated method stub
		return userDao.findRole(id);
	}

}
