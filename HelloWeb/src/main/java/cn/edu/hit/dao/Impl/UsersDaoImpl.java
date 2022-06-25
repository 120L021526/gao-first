package cn.edu.hit.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.hit.dao.UsersDao;
//import cn.edu.hit.entity.Student;
import cn.edu.hit.utils.DBUtils;

public class UsersDaoImpl implements UsersDao {
	
	@Override
	public boolean login(String username, String pwd) {
		ResultSet rs = DBUtils.executeQuery("select count(*) from users where username = '" + username + "'and pwd='" +pwd+"'");
		int count=0;
		try {
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0?true:false;
	}

}
