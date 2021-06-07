<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
</head>

<form action="/dmList.do" method="get" name="frm">
	받는사람 : ${sessionScope.m.memberId} <br>
	내용 : <br>	
	<textarea placeholder="내용을 입력해주세요" name="content" id = "msg" cols="40" rows="10" style="resize: none;"></textarea> <br>
	<input type="hidden" name="mid" value="">
	<input type="hidden" name="command" value="SendMessage">	
	<input type="submit" id="send" value="보내기">	
	<input type="reset" value="다시쓰기">
</form>
<script>
	$("#send").click(function(){
		var msg = $("[name=content]").val();
		$.ajax({
			url : "/dmSend.do",
			data : {msg:msg},
			type : "get",
			success : function(data){
				console.log("sdflsjd");
			}
		})
	})
</script>
</body>
</html>