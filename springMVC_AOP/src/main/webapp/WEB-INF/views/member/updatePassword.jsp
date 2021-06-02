<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호 변경</h1>
	<hr>
	<form action="/orgPassword.do">
		기존 비밀번호 : <input type="password" name="orgPassword">
		<input type="submit" vlaue="확인">
	</form>
	<form action="/newPassword.do">
		새로운 비밀번호 : <input type="text" name="newPassword">
		<input type="submit" vlaue="변경">
	</form>
</body>
</html>