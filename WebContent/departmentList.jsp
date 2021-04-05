<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>부서 목록</h2>
	<table border="1">
		<thead>
			<td>부서번호</td>
			<td>부서명</td>
			<td>위치</td>
		</thead>
		<tbody>
			<c:forEach var="dept" items="${list }">
				<tr>
					<td>${dept.deptNo }</td>
					<td><a href="DeptListServlet?deptNo=${dept.deptNo }">${dept.deptName }</td>
					<td>${dept.floor }</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr><td colspan="3"><a href="deptInsert.jsp">부서 추가</a></tr>
		</tfoot>
	</table>
</body>
</html>