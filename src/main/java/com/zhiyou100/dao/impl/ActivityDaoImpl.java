package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.ActivityDao;
import com.zhiyou100.pojo.Activity;
import com.zhiyou100.util.DBUtil;

public class ActivityDaoImpl implements ActivityDao {

	/*
	 * 通过id查询活动信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#findById(int)
	 */
	public Activity findById(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM ACTIVITY WHERE A_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			if(set.next()){
				Integer aid = set.getInt(1);
				Date date = set.getDate(2);
				String theme = set.getString(3);
				String content = set.getString(4);
				String site = set.getString(5);
				Integer cost = set.getInt(6);
				String organizer = set.getString(7);
				Activity a = new Activity(aid, date, theme, content, site, cost, organizer);
				return a;
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return null;
	}

	/*
	 * 添加活动信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#add(java.lang.Object)
	 */
	public void add(Activity e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="INSERT INTO ACTIVITY VALUES(SEQ_ACTIVITY_ID.NEXTVAL,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, e.getaDate());
			ps.setString(2, e.getaTheme());
			ps.setString(3, e.getaContet());
			ps.setString(4, e.getaSite());
			ps.setInt(5, e.getaCost());
			ps.setString(6, e.getaOrganizer());
			ps.executeUpdate();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
	}

	/*
	 * 修改活动信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#update(java.lang.Object)
	 */
	public void update(Activity e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql = "UPDATE ACTIVITY SET A_DATE=?,A_THEME=?,A_CONTENT=?,A_SITE=?,A_COST=?,A_ORGANIZER=? WHERE A_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, e.getaDate());
			ps.setString(2, e.getaTheme());
			ps.setString(3, e.getaContet());
			ps.setString(4, e.getaSite());
			ps.setInt(5, e.getaCost());
			ps.setString(6, e.getaOrganizer());
			ps.setInt(7, e.getaId());
			ps.executeUpdate();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
	}

	/*
	 * 删除活动信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#delete(int)
	 */
	public void delete(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="DELETE FROM ACTIVITY WEHRE A_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();			
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}

	}

	/*
	 * 查询所有活动信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#findAll()
	 */
	public List<Activity> findAll() {
		List<Activity> as = new ArrayList<Activity>();
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM ACTIVITY";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			while(set.next()){
				Integer id = set.getInt(1);
				Date date = set.getDate(2);
				String theme = set.getString(3);
				String content = set.getString(4);
				String site = set.getString(5);
				Integer cost = set.getInt(6);
				String organizer = set.getString(7);
				Activity a = new Activity(id, date, theme, content, site, cost, organizer);
				as.add(a);
			}
			return as;
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return null;
	}

}
