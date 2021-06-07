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
	<h1>${sessionScope.m.memberName }님의 쿠폰 정보</h1>
	<hr>
	<table border="1">
		<tr>
			<th>쿠폰번호</th><th>쿠폰이름</th><th>쿠폰내용</th><th>시작일</th><th>만료일</th><th>상태</th>
		</tr>
		<c:forEach items="${list }" var="coupon" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${coupon.couponName }</td>
				<td>${coupon.couponContent }</td>
				<td>${coupon.startDate }</td>
				<td>${coupon.endDate }</td>
				<td>${coupon.status }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>