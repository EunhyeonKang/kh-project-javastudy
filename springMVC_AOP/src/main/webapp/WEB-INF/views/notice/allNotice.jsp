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
	<h1>공지사항 목록</h1>
	<hr>
	<table border="1">
		<tr>
			<th>번호</th><th>공지사항번호</th><th>제목</th><th>내용</th><th>작성자</th><th>날짜</th>
		</tr>
		<c:forEach items="${list }" var="notice" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td><a href="/detailNotice.do?noticeNo=${notice.noticeNo }">${notice.noticeNo }</a></td>
				<td>${notice.noticeTitle }</td>
				<td>${notice.noticeContent }</td>
				<td>${notice.writer }</td>
				<td>${notice.noticeDate }</td>
			</tr>
		</c:forEach>
		<c:choose>
			<c:when test="${empty sessionScope.m }">
				<h3><a href="/">로그인 하러 가기</a></h3>
			</c:when>
			<c:otherwise>
				<h3><a href="/">홈으로 가기</a></h3>
			</c:otherwise>
		</c:choose>
	</table>
	
</body>
</html>