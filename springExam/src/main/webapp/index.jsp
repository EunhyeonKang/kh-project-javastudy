<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>실습</h1>
	<hr>
	<form action="/login.do">
		이메일 : <input type="text" name="email"><br>
		비밀번호 : <input type="password" name="userPw"><br>
		<input type="submit" value="로그인"><input type="reset" value="초기화"><br>
		<a href="/joinFrm.do">회원가입</a>
		<a href="/userCheck.do">아이디/비밀번호 찾기</a>	
	</form>
	
</body>
</html>