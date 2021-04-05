<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
         <legend>부서정보</legend>
         <ul>
            <li>
               <label for="deptno">부서번호</label>
               <input type="text" name="deptno" size="20" id="deptno" value = "${dept.deptNo }" readonly>
            </li>
            <li>
               <label for="deptname">부서명</label>
               <input type="text" name="deptname" size="20" id="deptname" value = "${dept.deptName}" readonly>
            </li>
            <li>
               <label for="floor">위치</label>
               <input type="text" name="floor" size="20" id="floor" value = "${dept.floor}" readonly>
            </li>
            <li>
               <a href = "DeptDelServlet?deptNo=${dept.deptNo }">삭제</a>
               <a href = "deptUpdate.jsp?deptno=${dept.deptNo }&deptname=${dept.deptName}&floor=${dept.floor}">수정</a>
            </li>
         </ul>
      </fieldset>
</body>
</html>