package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.ActivityDao;
import com.zhiyou100.dao.impl.ActivityDaoImpl;
import com.zhiyou100.pojo.Activity;
import com.zhiyou100.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {

	ActivityDao activityDao = new ActivityDaoImpl();
	
	public Activity findById(int id) {
		// TODO Auto-generated method stub
		return activityDao.findById(id);
	}

	public void add(Activity e) {
		// TODO Auto-generated method stub
		activityDao.add(e);
	}

	public void update(Activity e) {
		// TODO Auto-generated method stub
		activityDao.update(e);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		activityDao.delete(id);
	}

	public List<Activity> findAll() {
		// TODO Auto-generated method stub
		return activityDao.findAll();
	}

}
