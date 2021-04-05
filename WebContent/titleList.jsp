<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${list }
	<h2>직책 목록</h2>
	<table border="1">
		<thead>
			<td>직책번호</td><td>직책명</td>
		</thead>
		<tbody>
		<c:forEach var="title" items="${list }">
			<tr>
			<td>${title.no } </td>
			<td><a href="TitleListServlet?titleNo=${title.no }">${title.name } </td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
			<tr><td colspan="2"><a href="titleInsert.jsp">직책추가</a></tr>
		</tfoot>
	</table>
</body>
</html>
