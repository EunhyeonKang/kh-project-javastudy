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
	<h1>게시판 목록</h1>
	<table border="1">
		<tr>
			<th>게시판번호</th><th>제목</th><th>작성자</th><th>내용</th><th>날짜</th>
		</tr>
		<c:forEach items="${list }" var="board" varStatus="i">
			<tr>
<%-- 				<td>${i.count }</td> --%>
				<td>${board.boardNo }</td>
				<td><a href="/boardView.do?boardNo=${board.boardNo }">${board.boardTitle }</a></td>
				<td>${board.boardWriter }</td>
				<td>${board.boardContent }</td>
				<td>${board.boardDate }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>