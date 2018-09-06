package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.core.baseService.BaseService;
import com.zhiyou100.pojo.House;

public interface HouseService extends BaseService<House> {
	List<House> findAll();
}
