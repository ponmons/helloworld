<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>welcome8.jsp</title>
</head>
<body>
세션의 데이터값 획득 및 출력<br>
${sessionScope.kodb}-${sessionScope.key}-${sessionScope.key2}

<br><hr><br>
<a href="sessionDelete.do">kill</a>

<%-- 
<c:remove var="kodb" scope="session"/>
<c:remove var="key" scope="session"/>
<c:remove var="key2" scope="session"/>
 --%><br>
</body>
</html>









