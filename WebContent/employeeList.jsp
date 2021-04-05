<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${list }
	<h2>사원 목록</h2>
	<table border="1">
		<thead>
			<td>사원 번호</td>
			<td>사원 이름</td>
			<td>직책</td>
			<td>직속 상사</td>
			<td>급여</td>
			<td>부서</td>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${list }">
				<tr>
					<td>${emp.empNo }</td>
					
					<td><a href="EmpListServlet?empNo=${emp.empNo }&manager=${emp.manager.empName }&title=${emp.title.name }&dept=${emp.dept.deptName }">${emp.empName }</td>

					<td>${emp.title.name }(${emp.title.no })</td>
					
					<td>
					<c:choose>
						<c:when test="${not empty emp.manager.empName }">
							${emp.manager.empName }
						</c:when>
						<c:otherwise>
							BOSS
						</c:otherwise>
					</c:choose>
					</td>

					<td><fmt:formatNumber value="${emp.salary }" pattern="#,### 원"/></td>

					<td>${emp.dept.deptName }(${emp.dept.deptNo })</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr><td colspan="6"><a href="empInsert.jsp">사원 추가</a></tr>
		</tfoot>
	</table>
</body>
</html>