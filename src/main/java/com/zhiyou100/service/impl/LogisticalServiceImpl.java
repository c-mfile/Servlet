package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.LogisticaDao;
import com.zhiyou100.dao.impl.LogisticalDaoImpl;
import com.zhiyou100.pojo.Logistica;
import com.zhiyou100.service.LogisticalService;

public class LogisticalServiceImpl implements LogisticalService {
	LogisticaDao logisticaDao = new LogisticalDaoImpl();

	public Logistica findById(int id) {
		// TODO Auto-generated method stub
		return logisticaDao.findById(id);
	}

	public void add(Logistica e) {
		// TODO Auto-generated method stub
		logisticaDao.add(e);
	}

	public void update(Logistica e) {
		// TODO Auto-generated method stub
		logisticaDao.update(e);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		logisticaDao.delete(id);
	}

	public List<Logistica> findAll() {
		// TODO Auto-generated method stub
		return logisticaDao.findAll();
	}

}
