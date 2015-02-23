<%@ page language = "java" import="java.sql.*" contentType = "text/html;charset=euc-kr" %>
<%
		session.invalidate();
%>
<script>alert('로그아웃 되었습니다.');
		location.href="../loginpage.html";</script>