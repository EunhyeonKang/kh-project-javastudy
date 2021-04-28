<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.iei.member.vo.Member"%>
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
	<h1>전체회원출력</h1>
	<hr>
	<table>
		<tr>
			<th>회원번호</th><th>아이디</th><th>이름</th><th>전화번호</th><th>가입일</th>
		</tr>
		<%for(Member m : list){ %>
		<tr>
			<td><%=m.getMemberNo() %></td>
			<td><%=m.getMemberId() %></td>
			<td><%=m.getMemberName() %></td>
			<td><%=m.getPhone() %></td>
			<td><%=m.getEnrollDate() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>