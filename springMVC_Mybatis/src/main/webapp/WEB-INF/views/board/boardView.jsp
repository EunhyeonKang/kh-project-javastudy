<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 상세보기</h1>
	<table border="1">
		<tr>
			<th>제목</th>
			<td colspan="3">${board.boardTitle }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${b.boardWriter }</td>
			<th>작성일</th>
			<td>${b.boardDate }</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="3">	
			<c:forEach items="${b.fileList }" var="f">						
					<a href="/boardFileDown.do?fileNo=${f.fileNo} }">${f.filename}</a>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">${b.boardContent }</td>
		</tr>
	</table>
</body>
</html>