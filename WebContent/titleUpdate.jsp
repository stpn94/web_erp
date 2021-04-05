<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="TitleUpdateServlet" method="get">
<fieldset>
         <legend>직책정보</legend>
         <ul>
            <li>
               <label for="tno">직책번호</label>
               <input type="text" name="tno" size="20" id="tno" value = "${param.no }" readonly>
            </li>
            <li>
               <label for="tname">직책명</label>
               <input type="text" name="tname" size="20" id="tname" value = "${param.name}" >
            </li>
            <li>
               <input type="submit" value="수정">
            </li>
         </ul>
      </fieldset>
${title }
</body>
</html>