package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.core.baseDao.BaseDao;
import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;

public interface UserDao extends BaseDao<User> {
	/**
	 * 用户登录的方法
	 * @param name
	 * @param password
	 * @return User
	 */
	User login(String name,String password);
	
	/**
	 * 通过用户id查询角色信息
	 * @param id
	 * @return
	 */
	Role findRole(int id);
}
