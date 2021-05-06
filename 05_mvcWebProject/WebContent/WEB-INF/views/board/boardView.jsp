<%@page import="board.model.vo.Board"%>
<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Board b = (Board)request.getAttribute("b");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
		<fieldset>
			<legend>공지사항</legend>
			<table class="table" id="boardView" style="width:100%;">
				<tr class="table-info">
					<th colspan="4"><%=b.getBoardTitle() %></th>
				</tr>
				<tr class="table-light">
					<th>작성자</th>
					<th><%=b.getBoardWriter() %></th>
					<th>작성일</th>
					<th><%=b.getBoardDate() %></th>
				</tr>
				<tr class="table-light">
					<th>첨부파일</th>
					<th colspan="3">
						<%if(b.getFilename()!=null){ %>
						<img src="/img/file.png" width="16px">
						<a href="/fileDown?boardNo=<%=b.getBoardNo() %>">
						<%=b.getFilename() %></a>
						<%} %>
					</th>
				</tr>
				<tr class="table-light">
					<th>내용</th>
					<th colspan="3">
						<%=b.getBoardContentBr() %>
					</th>
				</tr>
				<tr class="table-light">
					<th colspan="4" style="text-align:center;">
						<button class="btn btn-info" onclick="history.go(-1;)">이전화면</button>
						<%if(m!=null && m.getMemberId().equals(b.getBoardWriter())){ %>
						<a class="btn btn-info" href="/noticeUpdateFrm?noticeNo=<%=b.getBoardNo() %>">수정하기</a>
						<a class="btn btn-info" href="/noticeDelete?noticeNo=<%=b.getBoardNo() %>">삭제하기</a>
						<%} %>
					</th>
				</tr>
			</table>
		</fieldset>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>