<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="EmpInsertServlet" method="get">
<fieldset>
      <legend>사원 추가</legend>
          <ul>
            <li>
               <label for="empno">사원번호</label>
               <input type="text" name="empno" size="20" id="empno" autofocus required>
            </li>
            <li>
               <label for="empname">사원명</label>
               <input type="text" name="empname" size="20" id="empname">
            </li>
            <li>
               <label for="title">직책</label>
               <input type="text" name="title" size="20" id="title">
            </li>
            <li>
               <label for="manager">직속상사</label>
               <input type="text" name="manager" size="20" id="manager">
            </li>
            <li>
               <label for="salary">급여</label>
               <input type="text" name="salary" size="20" id="salary">
            </li>
            <li>
               <label for="dept">부서</label>
               <input type="text" name="dept" size="20" id="dept">
            </li>
             <li>
            <input type ="submit" value = "추가"><input type="reset" value="취소"> 
            </li>
         </ul>
      </fieldset>
</body>
</html>