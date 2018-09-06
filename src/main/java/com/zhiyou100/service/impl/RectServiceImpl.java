package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.RectDao;
import com.zhiyou100.dao.impl.RectDaoImpl;
import com.zhiyou100.pojo.Rect;
import com.zhiyou100.service.RectService;

public class RectServiceImpl implements RectService {
	RectDao rectDao = new RectDaoImpl();

	public Rect findById(int id) {
		// TODO Auto-generated method stub
		return rectDao.findById(id);
	}

	public void add(Rect e) {
		// TODO Auto-generated method stub
		rectDao.add(e);
	}

	public void update(Rect e) {
		// TODO Auto-generated method stub
		rectDao.update(e);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		rectDao.delete(id);
	}

	public List<Rect> findAll() {
		// TODO Auto-generated method stub
		return rectDao.findAll();
	}

}
