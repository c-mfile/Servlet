package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.PrivilegeDao;
import com.zhiyou100.pojo.Privilege;
import com.zhiyou100.pojo.Role;
import com.zhiyou100.util.DBUtil;

public class PrivilegeDaoImpl implements PrivilegeDao {

	public List<Privilege> findAllByRole(Role r) {
		List<Privilege> privileges = new ArrayList<Privilege>();
		try{
			Connection conn = DBUtil.getConnection();
			String sql="SELECT P.P_ID,P.P_NAME,P.P_SOURCENAME,P.P_SOURCEURL FROM ROLE R,ROLE_PRIVILEGE RP,PRIVILEGE P "
					+ "WHERE R.R_ID=RP.R_ID AND RP.P_ID=P.P_ID AND R.R_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getrId());
			ResultSet set = ps.executeQuery();
			while(set.next()){
				int pId = set.getInt(1);
				String name = set.getString(2);
				String sourcename = set.getString(3);
				String sourceurl = set.getString(4);
				Privilege p = new Privilege(pId, name, sourcename, sourceurl);
				privileges.add(p);
			}
			return privileges;
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return null;
	}

}
