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
					<td>ѧ��</td>
					<td><input type="text" name="sid" value="<%=sid %>" readonly/></td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" name="sname" value="<%=sname%>"/></td>
				</tr>
				<tr>
					<td>�Ա�</td>
					<td><input name="gender" type="radio" value="��" <%if(gender.equals("��")) out.print("checked"); %>/>��
						<input name="gender" type="radio" value="Ů" <%if(gender.equals("Ů")) out.print("checked");%>/>Ů
					</td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" name="age" value="<%=age%>"/></td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" name="birthday" value="<%=birthday%>"/></td>
				</tr>
				<tr>
					<td>רҵ</td>
					<td>
						<select name="major">
							<option <%if(major.equals("������ͨ�Ź���")) out.print("selected"); %>>������ͨ�Ź���</option>
							<option <%if(major.equals("�������ѧ�뼼��")) out.print("selected"); %>>�������ѧ�뼼��</option>
							<option <%if(major.equals("�������")) out.print("selected"); %>>�������</option>
							<option <%if(major.equals("����ռ䰲ȫ")) out.print("selected"); %>>����ռ䰲ȫ</option>
							<option <%if(major.equals("��ѧ�����빤��")) out.print("selected"); %>>��ѧ�����빤��</option>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="�޸�"/></td>
				</tr>
			</table>
		</form>
</body>
</html>