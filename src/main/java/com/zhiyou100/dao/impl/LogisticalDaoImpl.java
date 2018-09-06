package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.LogisticaDao;
import com.zhiyou100.pojo.Logistica;
import com.zhiyou100.util.DBUtil;

public class LogisticalDaoImpl implements LogisticaDao {

	/*
	 * 通过id查询后勤人员的信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#findById(int)
	 */
	public Logistica findById(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM LOGISTICA WHERE LA_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			if(set.next()){
				Logistica ls = findLogistica(set);
				return ls;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return null;
	}

	/*
	 * 添加后勤人员信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#add(java.lang.Object)
	 */
	public void add(Logistica e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql = "INSERT INTO LOGISTICA VALUES(SEQ_LOG_ID.NEXTVAL,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getLaName());
			ps.setString(2, e.getLaIdcard());
			ps.setString(3, e.getLaTel());
			ps.setString(4, e.getLaSex());
			ps.setString(5, e.getLaDept());
			ps.setDate(6, e.getLaAddTime());
			ps.setInt(7, e.getLaSalary());
			ps.setString(8, e.getLaHogar());
			ps.executeUpdate();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}

	}

	/* 
	 * 修改后勤人员信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#update(java.lang.Object)
	 */
	public void update(Logistica e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="UPDATE LOGISTICA SET LA_NAME=?,LA_IDCARD=?,LA_TEL=?,LA_SEX=?,LA_DEPT=?,LA_SALARY=?,LA_HOGAR=? WHERE LA_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getLaName());
			ps.setString(2, e.getLaIdcard());
			ps.setString(3, e.getLaTel());
			ps.setString(4, e.getLaSex());
			ps.setString(5, e.getLaDept());
			ps.setInt(6, e.getLaSalary());
			ps.setString(7, e.getLaHogar());
			ps.setInt(8, e.getLaId());
			ps.executeUpdate();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}

	}

	/*
	 * 删除后勤人员信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#delete(int)
	 */
	public void delete(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM LOGISTICA WHERE LA_ID=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
	}

	/*
	 * 查询所有后勤人员信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#findAll()
	 */
	public List<Logistica> findAll() {
		List<Logistica> Logisticas = new ArrayList<Logistica>();
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM LOGISTICA";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			while(set.next()){
				Logistica ls = findLogistica(set);
				Logisticas.add(ls);
			}
			return Logisticas;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return Logisticas;
	}
	
	/**
	 * 通过ResultSet获取Logiscas对象
	 * @param set
	 * @return
	 * @throws SQLException
	 */
	public static Logistica findLogistica(ResultSet set) throws SQLException{
		Integer id = set.getInt(1);
		String name = set.getString(2);
		String idcard = set.getString(3);
		String tel = set.getString(4);
		String sex = set.getString(5);
		String dept = set.getString(6);
		Date addTime = set.getDate(7);
		Integer salary = set.getInt(8);
		String hogar = set.getString(9);
		Logistica ls = new Logistica(id, name, idcard, tel, sex, dept, addTime, salary, hogar);
		return ls;
	}
	

}
