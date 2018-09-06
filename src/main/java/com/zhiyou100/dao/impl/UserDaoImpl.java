package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.UserDao;
import com.zhiyou100.pojo.Role;
import com.zhiyou100.pojo.User;
import com.zhiyou100.util.DBUtil;
/**
 * UserDaoImpl方法
 * @author cm
 *
 */
public class UserDaoImpl implements UserDao {
	/*
	 * 通过id查询user的方法
	 */
	public User findById(int id) {
		User u = null;
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM USER1 WHERE U_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			if(set.next()){
				int uid = set.getInt(1);
				String username = set.getString(2);
				String password = set.getString(3);
				String name = set.getString(4);
				String tel = set.getString(5);
				String status = set.getString(6);
				u = new User(uid, username, password, name, tel, status);
				return u;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return u;
	}
	/*
	 * 添加user的方法
	 * @see com.zhiyou100.core.baseDao.BaseDao#add()
	 */
	public void add(User e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="INSERT INTO USER1 VALUES(SEQ_USER_ID.NEXTVAL,?,?,?,?,?)";
			String forRole = "INSERT INTO USER_ROLE VALUES(SEQ_USER_ID.CURRVAL,3)";
			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement forR = conn.prepareStatement(forRole);
			ps.setString(1, e.getuUsername());
			ps.setString(2, e.getuPassword());
			ps.setString(3, e.getuName());
			ps.setString(4, e.getuTel());
			ps.setString(5, e.getuStatus());
			ps.executeUpdate();
			forR.executeUpdate();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
	}
	/*
	 * 修改user信息的方法
	 * @see com.zhiyou100.core.baseDao.BaseDao#update()
	 */
	public void update(User e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="UPDATE USER1 SET U_USERNAME=?,U_PASSWORD=?,U_NAME=?,U_TEL=?,U_STATUS=? WHERE U_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getuUsername());
			ps.setString(2, e.getuPassword());
			ps.setString(3, e.getuName());
			ps.setString(4, e.getuTel());
			ps.setString(5, e.getuStatus());
			ps.setInt(6, e.getuId());
			ps.executeUpdate();
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
	}
	/*
	 * 删除user的方法
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#delete()
	 */
	public void delete(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM USER1 WHERE U_ID=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
	}
	/*
	 * 登录的方法
	 */
	public User login(String name, String password) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM USER1 WHERE U_USERNAME=? AND U_PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet set = ps.executeQuery();
			if(set.next()){
				int id = set.getInt(1);
				String username = set.getString(2);
				String pw = set.getString(3);
				String na = set.getString(4);
				String tel = set.getString(5);
				String status = set.getString(6);
				User u = new User(id, username, pw, na, tel, status);
				return u;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return null;
	}
	/*
	 * 查询所有用户信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#findAll()
	 */
	public List<User> findAll() {
		try{
			List<User> users = new ArrayList<User>();
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER1");
			ResultSet set = ps.executeQuery();
			while(set.next()){
				int id = set.getInt(1);
				String username = set.getString(2);
				String password = set.getString(3);
				String name = set.getString(4);
				String tel = set.getString(5);
				String status = set.getString(6);
				User u = new User(id, username, password, name, tel, status);
				users.add(u);
			}
			return users;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return null;
	}
	public Role findRole(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT R.R_ID,R.R_NAME,R.R_DESC FROM USER1 U,USER_ROLE UR,ROLE R "
					+ "WHERE U.U_ID=UR.U_ID AND R.R_ID=UR.R_ID AND U.U_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			if(set.next()){
				int rid = set.getInt(1);
				String name = set.getString(2);
				String desc = set.getString(3);
				Role r = new Role(rid, name, desc);
				return r;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return null;
	}
}
