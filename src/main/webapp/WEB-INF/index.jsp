<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Country Query Assignment</h1>

<table style="text-align:center; font-family: sans-serif">
<tr>
	<th>Region</th>
	<th>Number of Countries</th>
	
</tr>
<c:forEach items="${countries}" var="country">
<tr>
	<td><c:out value="${country[0]}"></c:out></td>
	<td><c:out value="${country[1]}"></c:out></td>
</tr>
</c:forEach>
</table>

</body>
</html>