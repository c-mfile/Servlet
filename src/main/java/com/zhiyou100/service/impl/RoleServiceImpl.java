package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.RoleDao;
import com.zhiyou100.dao.impl.RoleDaoImpl;
import com.zhiyou100.pojo.Role;
import com.zhiyou100.service.RoleService;

public class RoleServiceImpl implements RoleService {
	RoleDao roleDao = new RoleDaoImpl();

	public Role findById(int id) {
		// TODO Auto-generated method stub
		return roleDao.findById(id);
	}

	public void add(Role e) {
		// TODO Auto-generated method stub
		roleDao.add(e);
	}

	public void update(Role e) {
		// TODO Auto-generated method stub
		roleDao.update(e);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		roleDao.delete(id);
	}

	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

}
