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
	<h1>공지사항 상세보기</h1>
	<hr>
	<form action="/updateNotice.do">
		<h4>번호 : <input type="text" name="noticeNo" value="${notice.noticeNo }"></h4>
		<h4>제목 : <input type="text" name="noticeTitle" value="${notice.noticeTitle }"></h4>
		<h4>내용 : <input type="text" name="noticeContent" value="${notice.noticeContent }"></h4>
		<h4>작성자 : <input type="text" name="writer" value="${notice.writer }"></h4>
		<c:choose>
			<c:when test="${empty sessionScope.m }">
				<h3><a href="/notice.do">공지사항 목록</a></h3>
			</c:when>	
			<c:otherwise>
				<h3><input type="submit" value="공지사항 수정"></h3>
				<h4><a href="/deleteNotice.do?noticeNo=${notice.noticeNo }">공지사항 삭제</a></h4>
				<h4><a href="/notice.do">공지사항 목록</a></h4>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>