<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" %>
<%
String username=(String)session.getAttribute("username");
if(username==null){
	out.println("���ǷǷ��û������¼");
	return ;
}
%>