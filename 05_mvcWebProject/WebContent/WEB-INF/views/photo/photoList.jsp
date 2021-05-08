<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    int totalCount = (Integer)request.getAttribute("totalCount");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#more-btn{
		margin-top : 100px;
	}
	.photoWrapper{
		padding-top : 20px;
		clear : right;
		display : flex;
		justify-content : space-around;
		flex-wrap : wrap;
	}
	.photo{
		border : 1px solid #ccc;
		margin-top : 30px;
		width : 18%;
		height : 122px;
		overflow : hidden;
		transition-duration : 1s;
	}
	.photo>img{
		width:100%;
		height : 100px;
	}
	.photo>p{
		text-align : center;
		font-size : 10px;
	}
	.photo>img>hover{
		transform : scale(1.4);
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
		<fieldset>
			<legend>사진게시판</<legend>
			<%if(m!=null){ %>
			<div>
				<a class="btn btn-info writeBtn" href="/photoWriteFrm">글쓰기</a>
			</div>
			<%} %>
			<div class="photoWrapper">
			</div>
			
				<button class="btn btn-outline-info btn-block" 
						currentCount="0" 
						value="" 
						totalCount="<%=totalCount%>"
						id = "more-btn">더보기</button>
		</fieldset>
	</div>
	<script>
		$(function(){
			more(1);
			$("#more-btn").click(function(){
				more($(this).val());
			});
		})
		function more(start){
			$.ajax({
				url : "/photoMore",
				data : {start:start},
				type : "post",
				success : function(data){
					for(var i=0;i<data.length;i++){
						var p =data[i];
						var html ="";
						html += "<div class='photo'>";
						html += "<img src='/upload/photo/"+p.filepath+"'>";
						html += "<p class='caption'>"+p.photoContent+"</p></div>";
						$(".photoWrapper").append(html);
					}
					//이미지 추가가 끝나고나면 더보기 버튼의 value, 값 조정
					$("#more-btn").val(Number(start)+5);
					var curr = Number($("#more-btn").attr("currentCount"));
					$("#more-btn").attr("currentCount",curr+data.length);
					var totalCount = $("#more-btn").attr("totalCount");
					var currCount = $("#more-btn").attr("currentCount");
					if(currCount==totalCount){
						$("#more-btn").attr("disabled",true);
					}
					
				}
			})
		}
	</script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>