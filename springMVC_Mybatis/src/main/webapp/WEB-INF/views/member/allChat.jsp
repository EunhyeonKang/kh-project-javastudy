<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
<style>
	.chatting{
		width:500px;
		display: none;
	}
	.messageArea{
		overflow-y : auto;
		border : 1px solid block;
		height : 500px;
		display: flex;
		flex-direction: column;
		background-color : #b2c7d9;
	}
	.messageArea>p{
		text-align:center;
		width:100%;
	}
	#sendMsg{
		width:80%;
	}
	#sendBtn{
		width:20%;
	}
	.chat{
		margin-bottom: 10px;
		padding : 8px;
		border-radius: 3px;
	}
	.right{
		background-color: #ffeb33;
		align-self:flex-end;
	}
	.left{
		background-color: #ffffff;
		align-self:flex-start;
	}
</style>
<script>
	var ws;
	var memberId;
	function initChat(param){
		memberId = param;
		//웹소켓 연결시도
		ws = new WebSocket("ws://192.168.94.129:8082/chat.do");
		//소켓 연결 성공시 실행될 함수 지정
		ws.onopen = startChat;
		//소켓으로 서버가 데이터를 전송하면 로직을 수행할 함수
		ws.onmessage = receiveMsg;
		//소켓연결이 종료되면 수행할 함수 지정
		ws.onclose = endChat;
		$(".chatting").slideDown();
	}
	function startChat(){
		var data = {type:"enter",msg:memberId}
		ws.send(JSON.stringify(data)); //자바스크립트 객체를 문자열로 변환해서 서버로 전송
		appendChat("<p>채팅방에 입장했습니다</p>")
	}
	function receiveMsg(param){
		appendChat(param.data);
	}
	function endChat(){
		appendChat("<p>채팅이 종료되었습니다.</p>")
	}
	function appendChat(msg){
		$(".messageArea").append(msg);
		$(".messageArea").scrollTop($(".messageArea")[0].scrollHeight);
	}
	function sendMsg(){
		var msg = $("#sendMsg").val();
		if(msg != ''){
			var data ={type:"chat",msg:msg};
			//소켓 서버로 문자열 전송
			ws.send(JSON.stringify(data));
			//내화면에 출력
			appendChat("<div class='chat right'>"+msg+"</div>");
		}
	}
	$(function(){
		$("#sendMsg").keydown(function(){
			if(key.keyCode ==13){
				sendMsg();
			}
		})
	});
</script>
</head>
<body>
	<button onclick="initChat('${sessionScope.m.memberId}')">채팅시작</button>
	<hr>
	<div class="chatting">
		<div class="messageArea"></div>
		<div class="sendBox">
			<input type="text" id="sendMsg">
			<button id="sendBtn" onclick="sendMsg();">전송</button>
		</div>
	</div>
</body>
</html>