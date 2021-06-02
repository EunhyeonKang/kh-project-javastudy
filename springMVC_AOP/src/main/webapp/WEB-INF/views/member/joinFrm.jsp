<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="/join.do" method="post">
		<span id="idChk"></span>
		아이디 : <input type="text" name="memberId"><span><input type="button" value="중복확인" onclick="checkId();"></span><br>
		비밀번호 : <input type="password" name="memberPw"><br>
		이름 : <input type="text" name="memberName"><br>
		전화번호 : <input type="text" name="phone"><br>
		주소 : <input type="text" name="address"><br>
		성별 : 
		<input type="radio" name="gender" value="남">남자
		<input type="radio" name="gender" value="여">여자<br>
		<input type="submit" value="회원가입">
		<input type="reset" value="취소">
	</form>
	<script>
		function checkId(){
			var memberId = $("[name=memberId]").val();
			$.ajax({
				url : "/checkId.do",
				data : {memberId:memberId},
				type : "post",
				success : function(data){
					if(data==1){
						alert("아이디가 중복되었습니다.");
					}else{
						alert("아이디사용 가능합니다");
					}
				}
			})
		}
		$("[name=memberId]").keyup(function(){
			var memberId = $(this).val();
			$.ajax({
				url:"/idCheck.do",
				data : {memberId:memberId},
				type : "get",
				success: function(data){
					if(data==1){
						$("#idChk").html("이미 사용중인 아이디 입니다.");
					}else{
						$("#idChk").html("사용가능한 아이디 입니다.");
					}
				}
			})
		})
	</script>
</body>
</html>