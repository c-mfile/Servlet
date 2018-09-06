package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.ContractDao;
import com.zhiyou100.dao.impl.ContractDaoImpl;
import com.zhiyou100.pojo.Contract;
import com.zhiyou100.service.ContractService;

public class ContractServiceImpl implements ContractService {

	ContractDao coutractDao = new ContractDaoImpl();
	
	public Contract findById(int id) {
		// TODO Auto-generated method stub
		return coutractDao.findById(id);
	}

	public void add(Contract e) {
		// TODO Auto-generated method stub
		coutractDao.add(e);
	}

	public void update(Contract e) {
		// TODO Auto-generated method stub
		coutractDao.update(e);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		coutractDao.delete(id);
	}

	public List<Contract> findAll() {
		// TODO Auto-generated method stub
		return coutractDao.findAll();
	}

}
