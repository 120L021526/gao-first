<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="GBK">
		<title>Insert title here</title>
		<script type="text/javascript">
		function check(f){
			var username=f.username.value;
			var pwd=f.pwd.value;
			if(username==""||pwd==""){
				alert("用户名或密码不能为空");
				f.username.focus();
				return false;
			}
			return true;
		}
		</script>
	</head>
	<body>
	<%
	String username = "";
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
	for(Cookie c : cookies) {
		if(c.getName().equals("username")) {
			username = c.getValue();
		}
	}
	}
	%>
	
		<form action="LoginServlet" method="post" onsubmit="return check(this)"/>
			<table border="1">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" value="<%=username%>"/></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="text" name="pwd"/></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="rem" value="yes"/>记住用户名</td>
					<td><input type="submit" value="登录"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>