package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.HouseDao;
import com.zhiyou100.dao.impl.HouseDaoImpl;
import com.zhiyou100.pojo.House;
import com.zhiyou100.service.HouseService;

public class HouseServiceImpl implements HouseService {
	HouseDao houseDao = new HouseDaoImpl();
	
	public House findById(int id) {
		// TODO Auto-generated method stub
		return houseDao.findById(id);
	}

	public List<House> findAll() {
		// TODO Auto-generated method stub
		return houseDao.findAll();
	}

	public void add(House e) {
		// TODO Auto-generated method stub
		houseDao.add(e);
	}

	public void update(House e) {
		// TODO Auto-generated method stub
		houseDao.update(e);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		houseDao.delete(id);
	}

}
