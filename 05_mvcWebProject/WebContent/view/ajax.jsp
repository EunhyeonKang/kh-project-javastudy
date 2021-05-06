<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<legend>AJAX</legend>
			<div>
				<h3>1. 서버로 데이터 보내기</h3>
				<input type="text" id="ajax1">
				<button class="btn btn-info" onclick="jsAjax();">보내기(JS)</button>
				<button class="btn btn-danger" id="jQ1">보내기(jQuery)</button>
			</div>
			<div>
				<h3>2. 서버에서 기본형 데이터 받기</h3>
				<button class="btn btn-danger" id="jQ2">데이터 받기</button>
				<p class="ajaxResult"></p>
			</div>
			<div>
				<h3>3. 서버로 기본형 데이터 보내고 기본형 데이터 받기</h3>
				<input type="text" id="firstNum">
				<input type="text" id="secondNum">
				<button class="btn btn-danger" id="jQ3">두 수의 합 받기</button>
				<p class="ajaxResult"></p>
			</div>
			<div>
				<h3>4. 서버로 객체 데이터 보내기</h3>
				<input type="text" id="name"><br>
				<input type="text" id="age"><br>
				<input type="text" id="addr"><br>
				<button class="btn btn-danger" id="jQ4">객체 보내기</button>
			</div>
			<div>
				<h3>5. 서버로 기본형 데이터를 보내고, 결과로 객체 받기</h3>
				<input type="text" id="ajax5">
				<button class="btn btn-danger" id="jQ5">조회</button>
				<p class="ajaxResult"></p>
			</div>
			<div>
				<h3>6. 서버에서 리스트타입 결과 받기</h3>
				<button class="btn btn-danger" id="jQ6">조회</button>
				<p class="ajaxResult"></p>
			</div>
		</fieldset>
	</div>
	<script>
		function jsAjax(){
			//1. XMLHttpRequest 객체 생성
			var xhttp = new XMLHttpRequest();
			var msg = document.getElementById("ajax1").value;//input입력값
			//2. 요청정보를 설정
			xhttp.open("GET","/ajaxTest1?msg="+msg,true);
			//3. 데이터 처리에 따라 동작할 함수 설정
			xhttp.onreadystatechange = function(){
				if(this.readyState == 4 &&this.status == 200){//정상적으로 처리되었을 때 호출되는 함수
					console.log("서버 전송 성공");					
				}else if(this.readyStates==4 &&this.status==404){
					console.log("서블릿 없음");
				}
			}
			//4. 서버에 요청
			xhttp.send();
		}
	 	$("#jQ1").click(function(){
			var msg = $("#ajax1").val();
			$.ajax({
				url : "/ajaxTest1",
				data : {msg:msg},
				type : "get",
				sucess : function(){
					console.log("서버 전송 성공");
				},
				error : function(){
					console.log("에러가 났어요 도와주세요~");
				},
				complete : function(){
					console.log("성공/실패 여부와 상관없이 호출");
				}
				
			})
		}); 
		$("#jQ2").click(function(){
			var result = $(this).next();
			$.ajax({
				url : "/ajaxTest2",
				type : "get",
				success : function(data){	//서버가 주는 데이터가 매개변수로 들어옴
					result.html(data);
				},
				error : function(){
					console.log("실패");
				}
			})
			
		})
		$("#jQ3").click(function(){
			var num1 = $("#firstNum").val();
			var num2 = $("#secondNum").val();
			var result = $(this).next();
			$.ajax({
				url : "/ajaxTest3",
				type : "get",
				data : {firstNum : num1, secondNum : num2},
				success : function(data){	//서버가 주는 데이터가 매개변수로 들어옴
					result.html(data);
				},
				error : function(){
					console.log("실패");
				}
			})
			
		})
		$("#jQ4").click(function(){
			var name = $("#name").val();
			var age = $("#age").val();
			var addr = $("#addr").val();
			//객체 생성
			var student = {name:name,age:age,addr:addr};
			$.ajax({
				url : "/ajaxTest4",
				type : "post",
				data : student,
				success : function(){
					console.log("성공");
				}
			})
		})
		$("#jQ5").click(function(){
			var memberId = $("#ajax5").val();
			var result = $(this).next();
			$.ajax({
				url : "/ajaxTest5",
				type : "get",
				data : {memberId:memberId},
				success : function(data){
					//리턴된 data는 객체타입으로 꺼내서 사용해야함
					if(data == null){
						result.html("회원 정보가 없습니다.")
					}else{
						result.empty();
						var memberNo = data.memberNo;
						result.append("회원번호 : "+memberNo+"<br>");
						var memberId = data.memberId;
						result.append("회원아이디 : "+memberId+"<br>");
						var memberName1 = data.memberName1;
						result.append("회원이름1 : "+memberName1+"<br>");
						var memberName2 = data.memberName2;
						result.append("회원이름2 : "+memberName2+"<br>");
						var memberName3 = decodeURIComponent(data.memberName2);
						result.append("회원이름3 : "+memberName3);
					}
				}
			})
		})
		$("#jQ6").click(function(){
			var result = $(this).next();
			$.ajax({
				url : "/ajaxTest6",
				type : "get",
				success : function(data){
					if(data.logth != 0){
						var html = "";
						for(var i=0;i<data.length;i++){
							var memberNo = data[i].memberNo;
							var memberName = decodeURIComponent(data[i].memberName);
							var phone = data[i].phone;
							html+="회원번호 : " +memberNo+" / 이름 : "+memberName + " / 전화번호 : "+phone+"<br>";
							if(i==4){
								break;
							}
						}
						result.html(html);
					}else{
						result.html("회원정보가 없습니다.");
					}
				}
			})
		})
	</script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>