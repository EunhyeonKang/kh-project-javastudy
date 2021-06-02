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
	<h1>마이페이지</h1>
	<hr>
	<form action="/updateMember.do">
		<fieldset>
			아이디 : <input type="text" name="memberId" value="${member.memberId}" readonly><br>
			<button type="button" onclick="pwCheck();">비밀번호 변경</button><br>
			<a href="/updatePasswordFrm.do?memberId=${member.memberId }">비밀번호변경</a><br>
			이름 : <input type="text" name="memberName" value="${member.memberName }" readonly><br>
			전화버호 : <input type="text" name="phone" value="${member.phone }"><br>
			주소 : <input type="text" name="address" value="${member.address }"><br>
			성별 : 
			<c:choose>
				<c:when test='${member.gender.equals("남") }'>
				<input type="radio" name="gender" value="남 " checked>
				남자
				<input type="radio" name="gender" value="여">
				여자
				</c:when>
				<c:otherwise>
				<input type="radio" name="gender" value="남 "	>
				남자
				<input type="radio" name="gender" value="여"checked>
				여자
				</c:otherwise>
			</c:choose>
			<br>
			<input type="submit" value="정보수정">
		</fieldset>
	</form>
	<script>
		function pwCheck(){
			location.href="/pwCheck.do";
		}
	</script>
</body>
</html>