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
	<h1>Mybatis 테스트</h1>
	<hr>
	<c:choose>
		<c:when test="${empty sessionScope.m }">
			<form action="/login" method="post">
				<fieldset>
					<legend>로그인</legend>
					아이디 : <input type="text" name="memberId"><br>
					비밀번호 : <input type="password" name="memberPw"><br>
					<input type="submit" value="로그인">
					<input type="reset" value="초기화"><br>
					<a href="/joinFrm">회원가입</a>
					<a href="/searchFrm">아이디/비밀번호찾기</a>
		 		</fieldset>
			</form>
		</c:when>
		<c:otherwise>
			<h3>[${sessionScope.m.memberName }]님 환영합니다.</h3>
			<a href="/selectAllMember">전체회원조회</a><br>
			<a href="/mypage?memberId=${sessionScope.m.memberId}">마이페이지</a><br>
			<a href="/logout">로그아웃</a><br>
			<a href="/delete?memberId=${sessionScope.m.memberId}">회원탈퇴</a>
		</c:otherwise>
	</c:choose>
</body>
</html>