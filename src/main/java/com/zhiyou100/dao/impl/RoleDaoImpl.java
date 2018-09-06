package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.RoleDao;
import com.zhiyou100.pojo.Role;
import com.zhiyou100.util.DBUtil;

public class RoleDaoImpl implements RoleDao {

	/*
	 * 通过id查询角色
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#findById(int)
	 */
	public Role findById(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM ROLE WHERE R_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			if(set.next()){
				int rid = set.getInt(1);
				String name= set.getString(2);
				String desc = set.getString(3);
				Role role = new Role(rid, name, desc);
				return role;
			}			
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}		
		return null;
	}

	/*
	 * 添加角色
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#add(java.lang.Object)
	 */
	public void add(Role e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="INSERT INTO ROLE VALUES(SEQ_ROLE_ID.NEXTVAL,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getrName());
			ps.setString(2, e.getrDesc());
			ps.executeUpdate();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
	}

	/*
	 * 修改角色信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#update(java.lang.Object)
	 */
	public void update(Role e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="UPDATE ROLE SET R_NAME=?,R_DESC=? WHERE R_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getrName());
			ps.setString(2, e.getrDesc());
			ps.setInt(3, e.getrId());
			ps.executeUpdate();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
	}

	/*
	 * 删除角色信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#delete(int)
	 */
	public void delete(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="DELETE FROM ROLE WHERE R_ID=?";
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
	 * 查询所有角色信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#findAll()
	 */
	public List<Role> findAll() {
		List<Role> roles = new ArrayList<Role>();
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM ROLE";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			while(set.next()){
				int id = set.getInt(1);
				String name= set.getString(2);
				String desc = set.getString(3);
				Role role = new Role(id, name, desc);
				roles.add(role);
			}
			return roles;
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return roles;
	}

}
