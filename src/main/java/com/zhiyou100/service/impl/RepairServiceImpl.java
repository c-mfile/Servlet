package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.RepairDao;
import com.zhiyou100.dao.impl.RepairDaoImpl;
import com.zhiyou100.pojo.Repair;
import com.zhiyou100.service.RepairService;

public class RepairServiceImpl implements RepairService {
	RepairDao repairDao = new RepairDaoImpl();

	public Repair findById(int id) {
		// TODO Auto-generated method stub
		return repairDao.findById(id);
	}

	public void add(Repair e) {
		// TODO Auto-generated method stub
		repairDao.add(e);
	}

	public void update(Repair e) {
		// TODO Auto-generated method stub
		repairDao.update(e);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		repairDao.delete(id);
	}

	public List<Repair> findAll() {
		// TODO Auto-generated method stub
		return repairDao.findAll();
	}

}
