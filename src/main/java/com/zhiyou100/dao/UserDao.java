package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.core.baseDao.BaseDao;
import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;

public interface UserDao extends BaseDao<User> {
	/**
	 * �û���¼�ķ���
	 * @param name
	 * @param password
	 * @return User
	 */
	User login(String name,String password);
	
	/**
	 * ͨ���û�id��ѯ��ɫ��Ϣ
	 * @param id
	 * @return
	 */
	Role findRole(int id);
}
