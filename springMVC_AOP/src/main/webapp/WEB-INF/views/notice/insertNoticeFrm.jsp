<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지사항 작성</h1>
	<hr>
	<form action="/insertNotice.do">
		제목 : <input type="text" name="noticeTitle"><br>
		내용 : <input type="text" name="noticeContent" width="500"><br>
		작성자 : <input type="text" name="writer" placeholder="회원아이디 입력"><br>
		<input type="submit" value="제출"><br>
		<input type="reset" value="초기회"><br>
	</form>
</body>
</html>