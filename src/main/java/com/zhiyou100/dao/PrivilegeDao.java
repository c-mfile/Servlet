package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.pojo.Privilege;
import com.zhiyou100.pojo.Role;

public interface PrivilegeDao {
	/*
	 * ��ѯ��ɫ������Ȩ����Ϣ
	 */
	List<Privilege> findAllByRole(Role r);
}
