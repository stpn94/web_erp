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
     <legend>사원 정보</legend>
         <ul>
            <li>
               <label for="empno">사원번호</label>
               <input type="text" name="empno" size="20" id="empno" value = "${emp.empNo }" readonly>
            </li>
            <li>
               <label for="empname">사원명</label>
               <input type="text" name="empname" size="20" id="empname" value = "${emp.empName}" readonly>
            </li>
            <li>
               <label for="title">직책</label>
               <input type="text" name="title" size="20" id="title" value = "${param.title}" readonly>
            </li>
            <li>
               <label for="manager">직속상사</label>
               <input type="text" name="manager" size="20" id="manager" value = "${emp.manager.empNo}" readonly>
               
            </li>
            <li>
               <label for="salary">급여</label>
               <input type="text" name="salary" size="20" id="salary" value = "${emp.salary}" readonly>
            </li>
            <li>
               <label for="dept">부서</label>
               <input type="text" name="dept" size="20" id="dept" value = "${param.dept}" readonly>
            </li>
            <li>
               <a href = "EmpDelServlet?empno=${emp.empNo }">삭제</a>
               <a href = "empUpdate.jsp?empno=${emp.empNo }&empname=${emp.empName}&title=${emp.title.no}&manager=${param.manager}
               &salary=${emp.salary }&dept=${param.dept }">수정</a>
            </li>
         </ul>
      </fieldset>
</body>
</html>