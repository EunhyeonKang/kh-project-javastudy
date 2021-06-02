<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form{
		display: none;
		margin-top:100px;
	}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
	현재 비밀번호 입력 : <input type="password" name="pwd">
	<input type="button" value="확인" onclick="checkPw();">
	<form action="/pwChange.do" method="post">
	<input name="memberId" type="hidden" value="${sessionScope.m.memberId}">
	새 비밀번호 입력 : <input type="password" name="memberPw">
	<input type="submit" value="비밀번호 변경">
	</form>
	<script>
		function checkPw(){
			var memberPw = $("[name=pwd]").val();
			var memberId = $("[name=memberId]").val();
			$.ajax({
				url : "/checkPw.do",
				data : {memberId:memberId, memberPw:memberPw},
				type : "post",
				success : function(data){
					if(data==1){
						$("form").show());
					}else{
						alert("비밀번호를 확인해주세요.");
					}
				}
			})
		}
	</script>
</body>
</html>