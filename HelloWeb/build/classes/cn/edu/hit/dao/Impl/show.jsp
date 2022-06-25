<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String sid =(String)request.getAttribute("sid");
String sname =(String)request.getAttribute("sname");
String filePath =(String)request.getAttribute("filePath");
%>
学号：<%=sid %><br>
姓名：<%=sname %><br>
<img src="<%=filePath %>"/>
</body>
</html>