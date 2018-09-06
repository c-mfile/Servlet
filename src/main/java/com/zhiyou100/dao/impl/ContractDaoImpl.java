package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.ContractDao;
import com.zhiyou100.pojo.Contract;
import com.zhiyou100.util.DBUtil;

public class ContractDaoImpl implements ContractDao {

	/**
	 * 通过id查询租赁合同信息
	 */
	public Contract findById(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM CONTRACT WHERE C_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			if(set.next()){
				Contract c = findContract(set);
				return c;
			}			
			return null;
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return null;
	}

	/*
	 * 添加合同信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#add(java.lang.Object)
	 */
	public void add(Contract e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="INSERT INTO CONTRACT VALUES(SEQ_CONTRACT_ID.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";;
			PreparedStatement ps = conn.prepareStatement(sql);
			Date date = new Date(System.currentTimeMillis());
			ps.setInt(1, e.gethId());
			ps.setInt(2, e.getlId());
			ps.setDate(3, date);
			ps.setDate(4, e.getcStartTime());
			ps.setDate(5, e.getcEndTime());
			ps.setInt(6, e.getcAlquliter());
			ps.setString(7, e.getcPay());
			ps.setInt(8, e.getcDeptsito());
			ps.setInt(9, e.getcPaynum());
			ps.setString(10, e.getcName());
			ps.setInt(11, e.getcStatus());
			ps.executeUpdate();
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}

	}

	/*
	 * 修改合同信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#update(java.lang.Object)
	 */
	public void update(Contract e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="UPDATE CONTRACT SET H_ID=?,L_ID=?,C_DATE=?,"
					+ "C_STARTTIME=?,C_ENDTIME=?,C_ALQUILTER=?,C_PAY=?,"
					+ "C_DEPTSITO=?,C_PAYNUM=?,C_NAME=?,C_STATUS=? WHERE C_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.gethId());
			ps.setInt(2, e.getlId());
			ps.setDate(3, e.getcDate());
			ps.setDate(4, e.getcStartTime());
			ps.setDate(5, e.getcEndTime());
			ps.setInt(6, e.getcAlquliter());
			ps.setString(7, e.getcPay());
			ps.setInt(8, e.getcDeptsito());
			ps.setInt(9, e.getcPaynum());
			ps.setString(10, e.getcName());
			ps.setInt(11, e.getcStatus());
			ps.setInt(12, e.getcId());
			ps.executeUpdate();			
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
	}

	/*
	 * 删除合同信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#delete(int)
	 */
	public void delete(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="DELETE FROM CONTRACT WHERE C_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
					
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}

	}

	/*
	 * 查询所有租房合同信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.dao.ContractDao#findAll()
	 */
	public List<Contract> findAll() {
		List<Contract> cs = new ArrayList<Contract>();
		try{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM CONTRACT");
			ResultSet set = ps.executeQuery();
			while(set.next()){
				Contract c = findContract(set);
				cs.add(c);
			}
			return cs;
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return cs;
	}
	
	/*
	 * 通过set获取Contract对象
	 */
	public static Contract findContract(ResultSet set) throws SQLException{
		int cid = set.getInt(1);
		int hid = set.getInt(2);
		int lid = set.getInt(3);
		Date date = set.getDate(4);
		Date startTime = set.getDate(5);
		Date endTime = set.getDate(6);
		int alquilter = set.getInt(7);
		String pay = set.getString(8);
		int deptsito = set.getInt(9);
		int paynum = set.getInt(10);
		String name = set.getString(11);
		int status = set.getInt(12);
		Contract c = new  Contract(cid, hid, lid, date, startTime, endTime, alquilter, pay, deptsito, paynum, name, status);
		return c;
	}

}
