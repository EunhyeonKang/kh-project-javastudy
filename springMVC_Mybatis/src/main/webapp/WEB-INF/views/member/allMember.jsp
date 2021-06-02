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
	<h1>전체회원정보</h1>
	<hr>
	<table border="1">
		<tr>
			<th>번호</th><th>아이디</th><th>이름</th><th>전화번호</th><th>주소</th><th>성별</th>
			<c:forEach items="${list }" var="member" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>${member.memberId }</td>
					<td>${member.memberName }</td>
					<td>${member.phone }</td>
					<td>${member.address }</td>
					<td>${member.gender }</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>