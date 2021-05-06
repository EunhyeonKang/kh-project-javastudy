<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
		<fieldset>
			<legend>전체회원정보</legend>
			<table class="table-hover" style="width:100%">
				<tr class="table-primary">
					<td>선택</td><td>회원번호</td><td>아이디</td><td>이름</td><td>번호</td>
					<td>주소</td><td>가입일</td><td>회원등급</td><td>등급변경</td>
				</tr>
				<%for(Member member : list) {%>
				<tr class="table-light">
					<td><input type="checkbox" class="chk"></td>
					<td><%=member.getMemberNo() %></td>
					<td><%=member.getMemberId() %></td>
					<td><%=member.getMemberName() %></td>
					<td><%=member.getPhone() %></td>
					<td><%=member.getAddress() %></td>
					<td><%=member.getEnrollDate() %></td>
					<td>
						<select class="form-control" style="width:80%; display:inline-block">
						<%if(member.getMemberLevel()==1) { %>
							<option value="1" selected>관리자</option>
							<option value="2">정회원</option>
							<option value="3">준회원</option>
						<%}else if(member.getMemberLevel()==2){ %>
							<option value="1">관리자</option>
							<option value="2" selected>정회원</option>
							<option value="3">준회원</option>
						<%}else if(member.getMemberLevel()==3){ %>
							<option value="1">관리자</option>
							<option value="2">정회원</option>
							<option value="3" selected>준회원</option>
						<%} %>
							
						</select>
					</td>
					<td>
						<button class="btn btn-outline-warning btn-sm changeLevel">등급변경</button>
					</td>
				</tr>
				<%}%>
				<tr>
					<th colspan="9">
						<button class="btn btn-warning btn-block checkedChangeLevel">선택회원 등급변경</button>
					</th>
				</tr>
			</table>
		</fieldset>
	</div>
	<script>
		$(".changeLevel").click(function(){
			var memberLevel = $(this).parent().prev().children().val();
			console.log(memberLevel);
			var memberNo = $(this).parent().parent().children().eq(1).html();
			console.log(memberNo);
			location.href="/changeLevel?memberNo="+memberNo+"&memberLevel="+memberLevel;
		});
		$(".checkedChangeLevel").click(function(){
			var inputs = $(".chk:checked");
			var num = new Array();
			var level = new Array();
			inputs.each(function(idx,item){
				num.push($(item).parent().next().html());
				level.push($(item).parent().parent().find("select").val());
			});
			console.log(num);
			console.log(level);
			location.href="/checkedChangeLevel?num="+num.join("/")+"&level="+level.join("/");
		});
	</script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>