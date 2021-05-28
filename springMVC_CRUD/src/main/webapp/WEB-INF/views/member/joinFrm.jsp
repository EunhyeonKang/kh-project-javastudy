<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="/join.do" method="post">
		아이디 : <input type="text" name="memberId"><br>
		비밀번호 : <input type="password" name="memberPw"><br>
		이름 : <input type="text" name="memberName"><br>
		전화번호 : <input type="text" name="phone"><br>
		주소 : <input type="text" name="address"><br>
		성별 : 
		<input type="radio" name="gender" value="남">남자
		<input type="radio" name="gender" value="여">여자<br>
		<input type="submit" value="회원가입">
		<input type="reset" value="취소">
	</form>
</body>
</html>