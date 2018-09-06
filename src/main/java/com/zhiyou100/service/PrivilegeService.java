package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.pojo.Privilege;
import com.zhiyou100.pojo.Role;

public interface PrivilegeService {

	List<Privilege> findAllByRole(Role r);
}
