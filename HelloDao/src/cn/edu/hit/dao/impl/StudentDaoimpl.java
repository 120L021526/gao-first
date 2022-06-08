package cn.edu.hit.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hit.dao.StudentDao;
import cn.edu.hit.entity.Student;
import cn.edu.hit.utils.DBUtils;

public class StudentDaoimpl implements StudentDao {

	@Override
	public List<Student> getAll(String sql) {
		ResultSet rs = DBUtils.executeQuery(sql);
		List<Student> stuList = new ArrayList<>();
		String sid, sname, birthday;
		int age;
		try {
			while(rs.next()) {
				sid = rs.getString(1);
				sname = rs.getString(2);
				age = rs.getInt(3);
				birthday = rs.getString(4);
				stuList.add(new Student(sid, sname, age, birthday));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuList;
	}

	@Override
	public Student getBySid(String sid) {
		ResultSet rs = DBUtils.executeQuery("select * from student where sid = '" + sid + "'");
		String sname, birthday;
		int age;
		Student s = null;
		try {
			if(rs.next()) {
				sid = rs.getString(1);
				sname = rs.getString(2);
				age = rs.getInt(3);
				birthday = rs.getString(4);
				s = new Student(sid, sname, age, birthday);
				System.out.println(s.getSid()+"\t"+s.getSname()+"\t"+s.getAge()+"\t"+s.getBirthday()+"\t");
			}
			else
				System.out.println("找不到此学生，请再输入你的选择");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public int add(Student s) {
		String sid = s.getSid();
		String sname = s.getSname();
		int age = s.getAge();
		String birthday = s.getBirthday();
		String sql = "insert into student(sid, sname, age, birthday) values('" + sid + "','" + sname + "'," + age + ",'" + birthday + "')";
		return DBUtils.executeUpdate(sql);		
	}

	@Override
	public int modify(Student s) {
		String sid = s.getSid();
		String sname = s.getSname();
		int age = s.getAge();
		String birthday = s.getBirthday();
			String sql = "update student set sname = '" + sname 
					+ "', age = " + age 
					+ ", birthday = '" + birthday 
					+ "' where sid = '" + sid + "'";
			return DBUtils.executeUpdate(sql);
	}

	@Override
	public int remove(String sid) {
		String sql = "delete from student where sid = '" + sid + "'";
		return DBUtils.executeUpdate(sql);
	}

}

