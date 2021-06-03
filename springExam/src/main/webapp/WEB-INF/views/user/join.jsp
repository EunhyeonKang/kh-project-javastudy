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
	<h1>회원가입하자~~</h1>
	<hr>
	<form action="/join.do" method="post">
		이메일 : <input type="text" name="email"><span id="idChk"></span><br>
		비밀번호 : <input type="password" name="userPw"><br>
		이름 : <input type="text" name="userName"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="회원가입">
	</form>
	<script>
		$("[name=email]").keyup(function(){
			var email = $(this).val();
			
			$.ajax({
				url : "/idCheck.do",
				data : {email:email},
				type : "get",
				success : function(data){
					if(data==1){
						$("#idChk").html("이미 사용중인 이메일 입니다.");
					}else{
						$("#idChk").html("사용가능한 이메일 입니다.");
					}
				}
			})
		})
	</script>
</body>
</html>