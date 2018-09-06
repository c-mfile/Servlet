package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.RectDao;
import com.zhiyou100.pojo.Rect;
import com.zhiyou100.util.DBUtil;

public class RectDaoImpl implements RectDao {

	/*
	 * 通过id查询房租信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#findById(int)
	 */
	public Rect findById(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM RECT WHERE R_ID=?");
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			if(set.next()){
				Rect rect = findRect(set);
				return rect;
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return null;
	}

	/*
	 * 添加房租信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#add(java.lang.Object)
	 */
	public void add(Rect e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="INSERT INTO RECT VALUES(SEQ_RECT_ID.NEXTVAL,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.gethId());
			ps.setInt(2, e.getlId());
			ps.setInt(3, e.getrMoney());
			ps.setDate(4, e.getrTime());
			ps.setString(5, e.getrRemark());
			ps.executeUpdate();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}

	}

	/*
	 * 修改房租信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#update(java.lang.Object)
	 */
	public void update(Rect e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="UPDATE RECT SET H_ID=?,L_ID=?,R_MONEY=?,R_REMARK=? WHERE R_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.gethId());
			ps.setInt(2, e.getlId());
			ps.setInt(3, e.getrMoney());
			ps.setString(4, e.getrRemark());
			ps.setInt(5, e.getrId());
			ps.executeUpdate();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}

	}

	/*
	 * 删除房租信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#delete(int)
	 */
	public void delete(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="DELETE FROM RECT WHERE R_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
	}

	/*
	 * 查询所有房租信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#findAll()
	 */
	public List<Rect> findAll() {
		List<Rect> rects = new ArrayList<Rect>();
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM RECT";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			while(set.next()){
				Rect r = findRect(set);
				rects.add(r);
			}
			return rects;
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return rects;
	}
	/**
	 * 通过ResultSet获取rect对象
	 * @param set
	 * @return
	 * @throws SQLException
	 */
	public static Rect findRect(ResultSet set) throws SQLException{
		int rid = set.getInt(1);
		int hid = set.getInt(2);
		int lid = set.getInt(3);
		int money = set.getInt(4);
		Date date = set.getDate(5);
		String remark = set.getString(6);
		Rect r = new Rect(rid, hid, lid, money, date, remark);
		return r;
	}
}
