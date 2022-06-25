<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" %>
<%
String username=(String)session.getAttribute("username");
if(username==null){
	out.println("你是非法用户，请登录");
	return ;
}
%>