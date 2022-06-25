<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" 
	import="cn.edu.hit.dao.*,cn.edu.hit.dao.Impl.*,cn.edu.hit.entity.*,java.util.List"%>
	<%@include file="check.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GBK">
<title>Insert title here</title>
</head>
<body>
<%
String sid=request.getParameter("sid");
StudentDao dao=new StudentDaoImpl();
Student s=dao.getBySid(sid);
String sname=s.getSname();
String gender=s.getGender();
String major=s.getMajor();
String birthday=s.getBirthday();
int age=s.getAge();
%>
<form action="StudentServlet" method="post">
	<input type="hidden" name="from" value="modify"/>
			<table border="1">
				<tr>
					<td>学号</td>
					<td><input type="text" name="sid" value="<%=sid %>" readonly/></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="sname" value="<%=sname%>"/></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input name="gender" type="radio" value="男" <%if(gender.equals("男")) out.print("checked"); %>/>男
						<input name="gender" type="radio" value="女" <%if(gender.equals("女")) out.print("checked");%>/>女
					</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" name="age" value="<%=age%>"/></td>
				</tr>
				<tr>
					<td>生日</td>
					<td><input type="text" name="birthday" value="<%=birthday%>"/></td>
				</tr>
				<tr>
					<td>专业</td>
					<td>
						<select name="major">
							<option <%if(major.equals("电子与通信工程")) out.print("selected"); %>>电子与通信工程</option>
							<option <%if(major.equals("计算机科学与技术")) out.print("selected"); %>>计算机科学与技术</option>
							<option <%if(major.equals("软件工程")) out.print("selected"); %>>软件工程</option>
							<option <%if(major.equals("网络空间安全")) out.print("selected"); %>>网络空间安全</option>
							<option <%if(major.equals("化学工程与工艺")) out.print("selected"); %>>化学工程与工艺</option>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="修改"/></td>
				</tr>
			</table>
		</form>
</body>
</html>