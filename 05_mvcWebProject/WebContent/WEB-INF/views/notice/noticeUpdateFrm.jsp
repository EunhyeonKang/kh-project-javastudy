<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Notice n = (Notice) request.getAttribute("n");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">
		<form action="/noticeUpdate" method="post"
			enctype="multipart/form-data">
			<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo() %>">
			<fieldset>
				<legend>공지사항 수정</legend>
				<table class="table" style="width:100%;">
					<tr class="table-active">
						<th>제목</th>
						<td colspan="3"><input type="text" class="form-control"
							name="noticeTitle" value="<%=n.getNoticeTitle()%>"></td>
					</tr>
					<tr class="table-active">
						<th>작성자</th>
						<td>
							<%=m.getMemberId()%>
						</td>
						<th>첨부파일</th>
						<td style="text-align: left">
							<input type="hidden" name="status" value="stay"> 
							<%if(n.getFilename()!=null) {%>
							<img src="/img/file.png" width="16px" class="delFile">
							<span class="delFile"><%=n.getFilename() %></span>
							<button type="button" id="delBtn" class="btn btn-primary btn-sm delFile">삭제</button>
							<input type="file" name="filename" id="file" style="display:none">
							<input type="hidden" name="oldFilename" value="<%=n.getFilename() %>"> 
							<input type="hidden" name="oldFilepath" value="<%=n.getFilepath() %>"> 
							<%}else{ %>
							<input type="file" name="filename">
							<%} %>
						</td>
					</tr>
					<tr class="table-active">
						<th>내용</th>
						<td colspan="3">
						<textarea name="noticeContent" class="form-control">여기가문제???이것도문제긴하고<%=n.getNoticeContent() %></textarea>
						</td>
					</tr>
					<tr class="table-active">
						<th colspan="4">
							<button type="submit" class="btn btn-danger btn-block">수정하기</button>
						</th>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
	<script>
		$("#delBtn").click(function(){
			if(confirm('첨부파일을 삭제하시겠습니까?')){
				$(".delFile").hide();
				$("#file").show();
				$("[name=status]").val("delete");
			}
		});
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>