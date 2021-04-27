<%@page import="kr.or.iei.member.vo.Member"%>
<%@page import="kr.or.iei.member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //1.인코딩
    request.setCharacterEncoding("utf-8");
    //2.값추출
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    //3.로직처리
    MemberDao dao = new MemberDao();
    Member member =dao.selectOneMember(id,pw);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인결과</h1>
	<hr>
	<%if(member!=null) {%>
	<h2>[<%=member.getMemberName() %>]님 환영합니다.</h2>
	<%}else { %>
	<h2>아이디 또는 비밀번호를 확인하세요!</h2>
	<%} %>
</body>
</html>