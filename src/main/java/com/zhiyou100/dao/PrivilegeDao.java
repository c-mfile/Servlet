package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.pojo.Privilege;
import com.zhiyou100.pojo.Role;

public interface PrivilegeDao {
	/*
	 * 查询角色的所有权限信息
	 */
	List<Privilege> findAllByRole(Role r);
}
