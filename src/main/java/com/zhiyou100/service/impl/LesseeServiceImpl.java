package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.LesseeDao;
import com.zhiyou100.dao.impl.LesseeDaoImpl;
import com.zhiyou100.pojo.Lessee;
import com.zhiyou100.service.LesseeService;

public class LesseeServiceImpl implements LesseeService {
	LesseeDao lesseeDao = new LesseeDaoImpl();

	public Lessee findById(int id) {
		// TODO Auto-generated method stub
		return lesseeDao.findById(id);
	}

	public void add(Lessee e) {
		// TODO Auto-generated method stub
		lesseeDao.add(e);
	}

	public void update(Lessee e) {
		// TODO Auto-generated method stub
		lesseeDao.update(e);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		lesseeDao.delete(id);
	}

	public List<Lessee> findAll() {
		// TODO Auto-generated method stub
		return lesseeDao.findAll();
	}

}
