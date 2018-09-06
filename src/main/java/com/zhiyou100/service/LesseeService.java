package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.core.baseService.BaseService;
import com.zhiyou100.pojo.Lessee;

public interface LesseeService extends BaseService<Lessee> {

	List<Lessee> findAll();
}
