<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

</head>
<body>
<h1>학원정보 조회하기</h1>
<hr>
	<div>
		<input type="text" id="ajax1">
		<button class="" id="jQ1">조회하기</button>
		<p class="ajaxResult"></p>
	</div>
	<script>
	$("#jQ1").click(function(){
		var khId = $("#ajax1").val();
		var result = $(this).next();
		$.ajax({
			url : "/ajaxSelect",
			type : "get",
			data : {khId:khId},
			success : function(data){
				//리턴된 data는 객체타입으로 꺼내서 사용해야함
				if(data == null){
					result.html("회원 정보가 없습니다.")
				}else{
					result.empty();
					var name = decodeURIComponent(data.khName);
					result.append("<li>이름 : "+name+"</li>");
					var addr = decodeURIComponent(data.addr)
					result.append("<li>주소 : "+addr+"</li>");
					var fax = data.fax;
					result.append("<li>번호 : "+fax+"</li>");
				
				}
			}
		})
	})
	</script>
</body>
</html>