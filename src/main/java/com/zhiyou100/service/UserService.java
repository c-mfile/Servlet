package com.zhiyou100.service;

import com.zhiyou100.core.baseService.BaseService;
import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;

public interface UserService extends BaseService<User> {
	User login(String name,String password);
	Role findRole(int id);
}
