package cn.edu.hit.test;
import java.util.Scanner;
import cn.edu.hit.dao.*;
import cn.edu.hit.dao.impl.*;
import cn.edu.hit.dao.StudentDao;
import cn.edu.hit.entity.*;
import cn.edu.hit.utils.DBUtils;

import java.util.List;
public class test {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int flag=0;
		String sid;
		String sname;
		int age;
		String birthday;
	lab:	while(true) {
			System.out.println("1: Search Student");
			System.out.println("2: Get one Student by sid");
			System.out.println("3: Add Student");
			System.out.println("4: Modify Student");
			System.out.println("5: Remove Student");
			System.out.println("6: Exit System");
			flag=input.nextInt();
			StudentDao dao=new StudentDaoimpl();
			switch(flag) {
			case 1:
				List<Student> stuList = dao.getAll("select * from student");
				System.out.println("sid\tsname\tage\tbirthday");
				for(Student s:stuList){
					System.out.println(s.getSid()+"\t"+s.getSname()+"\t"+s.getAge()+"\t"+s.getBirthday()+"\t");
				}
				break;
			case 2:
				System.out.println("Input sid: ");
				sid=input.next();
				dao.getBySid(sid);
				break;
			case 3:
				System.out.println("Input sid: ");
				sid=input.next();
				System.out.println("Input sname: ");
				sname=input.next();
				System.out.println("Input age: ");
				age=input.nextInt();
				System.out.println("Input birthday");
				birthday=input.next();
				//StudentDao dao=new StudentDaoimpl();
				dao.add(new Student(sid, sname, age, birthday));
				System.out.println("增加成功");
				break;
			case 4:
				System.out.println("Input sid: ");
				sid=input.next();
				boolean a=false;
				boolean b=false;
				List<Student> stuList1 = dao.getAll("select * from student");
				for(Student s:stuList1)
				{
					a=s.getSid().equals(sid);
					if(a) {
						System.out.println("Input sname: ");
						sname=input.next();
						System.out.println("Input age: ");
						age=input.nextInt();
						System.out.println("Input birthday");
						birthday=input.next();
						dao.modify(new Student(sid, sname, age, birthday));
						b=a;
					}
				}
				if(b==false)
					System.out.println("找不到此学生，请再输入你的选择");
				break;
			case 5:
				System.out.println("Input sid: ");
				sid=input.next();
				System.out.println("是否要删除该学生？");
				String in;
				in=input.next();
				if(in.equals("yes")) {
				dao.remove(sid);
				}
				break;
			default:
				DBUtils.close();
				break lab;
					
			}
		}
		input.close();
	}

}
