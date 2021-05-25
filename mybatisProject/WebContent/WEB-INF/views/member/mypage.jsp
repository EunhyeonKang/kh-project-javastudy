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
	<form action="/update" method="post">
		<fieldset>
			아이디 : <input type="text" name="memberId" value="${member.memberId }" readonly><br>
			비밀번호  : <input type="password" name="memberPw" value="${member.memberPw }"><br>
			이름 : <input type="text" name="memberName" value="${member.memberName }"><br>
			전화번호 : <input type="text" name="phone" value="${member.phone }"><br>
			주소 : <input type="text" name="address" value="${member.address }"><br>
			성별 : 
			<c:choose>
				<c:when test='${member.gender.equals("남") }'>
					<label>
						<input type="radio" name="gender" value="남" checked>
						남자
					</label>
					<label>
						<input type="radio" name="gender" value="여">
						여자
					</label>
				</c:when>
				<c:otherwise>
					<label>
						<input type="radio" name="gender" value="남">
						남자
					</label>
					<label>
						<input type="radio" name="gender" value="여" checked>
						여자
					</label>
				</c:otherwise>
			</c:choose>
			<br>
			<input type="submit" value="정보수정">
		</fieldset>
	</form>
</body>
</html>