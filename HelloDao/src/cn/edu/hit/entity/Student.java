package cn.edu.hit.entity;

public class Student {
	private String sid;
	private String sname;
	private int age;
	private String birthday;

	public Student() {
		super();
	}

	public Student(String sid, String sname, int age, String birthday) {
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.birthday = birthday;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}
