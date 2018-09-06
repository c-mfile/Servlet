package com.zhiyou100.dao.impl;

import java.io.Reader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.LesseeDao;
import com.zhiyou100.pojo.Lessee;
import com.zhiyou100.util.DBUtil;

public class LesseeDaoImpl implements LesseeDao {

	/*
	 * 通过id查询租户信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#findById(int)
	 */
	public Lessee findById(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM LESSEE WHERE L_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			if(set.next()){
				Lessee ls = findLessee(set);
				return ls;
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return null;
	}

	/*
	 * 添加租户信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#add(java.lang.Object)
	 */
	public void add(Lessee e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql = "INSERT INTO LESSEE VALUES(SEQ_LESSEE_ID.NEXTVAL,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getlName());
			ps.setString(2, e.getlTel());
			ps.setString(3, e.getlSex().toString());
			ps.setString(4, e.getlNativePlace());
			ps.setString(5, e.getlIdcade());
			ps.setDate(6, e.getlAddtime());
			int i = ps.executeUpdate();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
	}

	/*
	 * 修改租户信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#update(java.lang.Object)
	 */
	public void update(Lessee e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="UPDATE LESSEE SET L_NAME=?,L_TEL=?,L_SEX=?,L_NATIVEPLACE=?,L_IDCARD=? WHERE L_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getlName());
			ps.setString(2, e.getlTel());
			ps.setString(3, e.getlSex().toString());
			ps.setString(4, e.getlNativePlace());
			ps.setString(5, e.getlIdcade());
			ps.setInt(6, e.getlId());
			ps.executeUpdate();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}

	}

	/*
	 * 删除租户信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#delete(int)
	 */
	public void delete(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM LESSEE WHERE L_ID=?");
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
	 * 查询所有租户信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.dao.LesseeDao#findAll()
	 */
	public List<Lessee> findAll() {
		List<Lessee> lessees = new ArrayList<Lessee>();
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM LESSEE";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			while(set.next()){
				Lessee ls = findLessee(set);
				lessees.add(ls);
			}
			return lessees;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return lessees;
	}
	/**
	 * 通过ResultSet获取lessee
	 * @param set
	 * @return
	 * @throws SQLException
	 */
	public static Lessee findLessee(ResultSet set) throws SQLException{
		Integer id = set.getInt(1);
		String name = set.getString(2);
		String tel = set.getString(3);
		char sex = set.getString(4).charAt(0);
		String nativePlace = set.getString(5);
		String idCard = set.getString(6);
		Date addTime = set.getDate(7);
		Lessee ls = new Lessee(id, name, tel, sex, nativePlace, idCard, addTime);
		return ls;
	}
}
