package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.RepairDao;
import com.zhiyou100.pojo.Repair;
import com.zhiyou100.util.DBUtil;

public class RepairDaoImpl implements RepairDao {

	/*
	 * 通过id查询房屋修缮信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#findById(int)
	 */
	public Repair findById(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM REPAIR WHERE RE_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			if(set.next()){
				int reid = set.getInt(1);
				int msg = set.getInt(2);
				int pr = set.getInt(3);
				String explain = set.getString(4);
				Date time = set.getDate(5);
				String result = set.getString(6);
				String remark = set.getString(7);
				Repair r = new Repair(reid, msg, pr, explain, time, result, remark);
				return r;
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return null;
	}

	/*
	 * 添加房屋修缮信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#add(java.lang.Object)
	 */
	public void add(Repair e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="INSERT INTO REPAIR VALUES(SEQ_REPAIR_ID.NEXTVAL,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getrMessage());
			ps.setInt(2, e.getrPrincipal());
			ps.setString(3, e.getrExplain());
			ps.setDate(4, e.getrTime());
			ps.setString(5, e.getrResult());
			ps.setString(6, e.getrRemark());
			ps.executeUpdate();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}		
	}

	/*
	 * 修改房屋修缮信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#update(java.lang.Object)
	 */
	public void update(Repair e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="UPDATE REPAIR SET R_MESSAGE=?,R_PRINCIPAL=?,R_EXPLAIN=?,R_TIME=?,R_RESULT=?,R_REMARK=? WHERE RE_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getrMessage());
			ps.setInt(2, e.getrPrincipal());
			ps.setString(3, e.getrExplain());
			ps.setDate(4, e.getrTime());
			ps.setString(5, e.getrResult());
			ps.setString(6, e.getrRemark());
			ps.setInt(7, e.getReId());
			ps.executeUpdate();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
	}

	/*
	 * 删除房屋修缮信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#delete(int)
	 */
	public void delete(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="DELETE FROM REPAIR WHERE RE_ID=?";
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
	 * 查询所有房屋修缮信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#findAll()
	 */
	public List<Repair> findAll() {
		List<Repair> rs = new ArrayList<Repair>();
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM REPAIR";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			while(set.next()){
				int id = set.getInt(1);
				int msg = set.getInt(2);
				int pr = set.getInt(3);
				String explain = set.getString(4);
				Date time = set.getDate(5);
				String result = set.getString(6);
				String remark = set.getString(7);
				Repair r = new Repair(id, msg, pr, explain, time, result, remark);
				rs.add(r);
			}
			return rs;
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return rs;
	}

}
