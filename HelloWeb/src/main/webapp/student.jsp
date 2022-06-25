<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="cn.edu.hit.dao.*,cn.edu.hit.dao.Impl.*,cn.edu.hit.entity.*,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>成绩详情</title>
</head>
<body>
<a href="add.html">增加学生</a>
<form method="post">
请输入学号:
<input type="text" name="sid"/>
<input type="submit" value="查询">
</form>
<table width="722" border="1">
  <tr>
    <td width="72">学号</td>
    <td width="133">姓名</td>
    <td width="76">年龄</td>
    <td width="82">性别</td>
    <td width="81">生日</td>
    <td width="116">专业</td>
    <td width="116">删除</td>
    <td width="116">修改</td>
  </tr>
  <%
  String sid, sname, gender, birthday, major;
  request.setCharacterEncoding("GBK");
  sid= request.getParameter("sid");
  if(sid==null){
	  sid="";
  }else{
	  sid=sid.trim();
  }
  StudentDao dao = new StudentDaoImpl();
  List<Student> stuList = dao.getAll("select * from student where sid like '%" + sid + "%'");
  int age;
  for(Student s : stuList) {
  	sid = s.getSid();
	sname = s.getSname();
	age = s.getAge();
	birthday = s.getBirthday();
	gender = s.getGender();
	major = s.getMajor();
  %>
  <tr>
    <td><%=sid%></td>
    <td><%=sname%></td>
    <td><%=age%></td>
    <td><%=gender%></td>
    <td><%=birthday%></td>
    <td><%=major%></td>
    <td><a href="StudentServlet?sid=<%=sid%>" onClick="return confirm('确定删除吗？')">删除</a></td>
    <td><a href="modify.jsp?sid=<%=sid%>">修改</a></td>
  </tr>
  <%
  }
  %>
</table>
</body>
</html>