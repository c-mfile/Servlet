package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.PrivilegeDao;
import com.zhiyou100.dao.impl.PrivilegeDaoImpl;
import com.zhiyou100.pojo.Privilege;
import com.zhiyou100.pojo.Role;
import com.zhiyou100.service.PrivilegeService;

public class PrivilegeServiceImpl implements PrivilegeService {
	PrivilegeDao privilegeDao = new PrivilegeDaoImpl();

	public List<Privilege> findAllByRole(Role r) {
		// TODO Auto-generated method stub
		return privilegeDao.findAllByRole(r);
	}

}
