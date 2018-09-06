package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.HouseDao;
import com.zhiyou100.pojo.House;
import com.zhiyou100.util.DBUtil;

import oracle.sql.CHAR;

public class HouseDaoImpl implements HouseDao {

	/*
	 * 通过id查询房屋信息
	 * @see com.zhiyou100.core.baseDao.BaseDao#findById(int)
	 */
	public House findById(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM HOUSE WHERE H_ID=?");
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			if(set.next()){
				return findHouse(set);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return null;
	}

	/*
	 * 查询所有房屋信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.dao.HouseDao#findAll()
	 */
	public List<House> findAll() {
		List<House> houses = new ArrayList<House>();
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT * FROM HOUSE";
			Statement st = conn.createStatement();
			ResultSet set = st.executeQuery(sql);
			while(set.next()){
				House h = findHouse(set);
				houses.add(h);
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return houses;
	}

	/*
	 * 添加房屋信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#add(java.lang.Object)
	 */
	public void add(House e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql="INSERT INTO HOUSE VALUES(SEQ_HOUSE_ID.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			String area = e.gethArea();
			String estate = e.gethEstate();
			String unitnumber = e.gethUnIntegerNumber();
			int floor = e.gethFloor();
			String roomno = e.gethRoomno();
			String acreage = e.gethAcreage();
			String direction = e.gethDirection();
			String fitment = e.gethFitment();
			boolean isdoubleair = e.ishIsdoubleair();
			int limit = e.gethLimit();
			String facility = e.gethFacility();
			int price = e.gethPrice();
			int status = e.gethStatus();
			String img = e.gethImg();
			String address = e.gethAddress();
			Date addtime = e.gethAddtime();
			Date updatetime = e.gethUpdateTime();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, area);
			ps.setString(2, estate);
			ps.setString(3, unitnumber);
			ps.setInt(4, floor);
			ps.setString(5, roomno);
			ps.setString(6, acreage);
			ps.setString(7, direction);
			ps.setString(8, fitment);
			ps.setBoolean(9, isdoubleair);
			ps.setInt(10, limit);
			ps.setString(11, facility);
			ps.setInt(12, price);
			ps.setInt(13, status);
			ps.setString(14, img);
			ps.setString(15, address);
			ps.setDate(16, addtime);
			ps.setDate(17, updatetime);
			ps.executeUpdate();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		
	}

	/*
	 * 修改房屋信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#update(java.lang.Object)
	 */
	public void update(House e) {
		try{
			Connection conn = DBUtil.getConnection();
			String sql = "UPDATE HOUSE SET H_AREA=?,H_ESTATE=?,H_UNITNUMBER=?,H_FLOOR=?,H_ROOMNO=?,"
					+ "H_ACREAGE=?,H_DIRECTION=?,H_FITMENT=?,H_ISDOUBLEAIR=?,H_LIMIT=?,H_FACILITY=?,H_PRICE=?,H_STATUS=?,H_IMG=?,H_ADDRESS=?,H_UPDATETIME=? WHERE H_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(e);
			String area = e.gethArea();
			String estate = e.gethEstate();
			String unitnumber = e.gethUnIntegerNumber();
			int floor = e.gethFloor();
			String roomno = e.gethRoomno();
			String acreage = e.gethAcreage();
			String direction = e.gethDirection();
			String fitment = e.gethFitment();
			boolean isdoubleair = e.ishIsdoubleair();
			int limit = e.gethLimit();
			String facility = e.gethFacility();
			int price = e.gethPrice();
			int status = e.gethStatus();
			String img = e.gethImg();
			String address = e.gethAddress();
			Date updatetime = e.gethUpdateTime();
			ps.setString(1, area);
			ps.setString(2, estate);
			ps.setString(3, unitnumber);
			ps.setInt(4, floor);
			ps.setString(5, roomno);
			ps.setString(6, acreage);
			ps.setString(7, direction);
			ps.setString(8, fitment);
			ps.setBoolean(9, isdoubleair);
			ps.setInt(10, limit);
			ps.setString(11, facility);
			ps.setInt(12, price);
			ps.setInt(13, status);
			ps.setString(14, img);
			ps.setString(15, address);
			ps.setDate(16, updatetime);
			ps.setInt(17, e.gethId());
			ps.executeUpdate();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
	}

	/*
	 * 删除房屋信息
	 * (non-Javadoc)
	 * @see com.zhiyou100.core.baseDao.BaseDao#delete(int)
	 */
	public void delete(int id) {
		try{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM HOUSE WHERE H_ID=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
	}
	
	/*
	 * 通过ResultSet获取house对象信息
	 */
	public static House findHouse(ResultSet set) throws SQLException{
		Integer id = set.getInt(1);
		String area = set.getString(2);
		String estate = set.getString(3);
		String unitnumber = set.getString(4);
		Integer floor = set.getInt(5);
		String roomno = set.getString(6);
		String acreage = set.getString(7);
		String direction = set.getString(8);
		String fitment = set.getString(9);
		Boolean isdoubleair = set.getBoolean(10);
		Integer limit = set.getInt(11);
		String facility = set.getString(12);
		Integer price = set.getInt(13);
		Integer status = set.getInt(14);
		String img = set.getString(15);
		String address = set.getString(16);
		Date addtime = set.getDate(17);
		Date updatetime = set.getDate(18);
		House h = new House(id, area, estate, unitnumber, floor, roomno, acreage, direction, fitment, isdoubleair, limit, facility, price, status, img, address, addtime, updatetime);
		return h;
	}

}
