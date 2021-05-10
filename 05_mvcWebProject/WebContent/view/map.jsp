<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=vbqtvmhi5r&submodules=geocoder"></script>

</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
		<h3>1.다음 주소 찾기</h3>
		<div>
			<input type="text" id="postCode" class="short form-control" readonly>
			<button onclick="addrSearch();" class="btn btn-primary">주소검색</button>
		</div>
		<div>
			<input type="text" id="roadAddr" class="form-control" placeholder="도로명 주소">
		</div>
		<div>
			<input type="text" id="jibunAddr" class="form-control" placeholder="지번 주소">
		</div>
		<div>
			<input id="datailAddr" type="text" placeholder="상세주소" class="form-control">
		</div>
		<h3>2.네이버지도 API</h3>
		<div id="map" style="width:100%; height:500px;"></div>
	</div>
	<script>
		//네이버지도
		window.onload=function(){
			//아무설정 없이 지도객체를 만드는 경우 서울시청이 지도의 중심
			var map = new naver.maps.Map('map',{
				center : new naver.maps.LatLng(37.533807,126.896772),
				zoom : 17,
				zoomControl:true,
				zoomControlOptions :{
					position : naver.maps.Position.TOP_RIGHT,
					style : naver.maps.ZoomControlStyle.SMALL
				}
			});
			var marker = new naver.maps.Marker({
				position : new naver.maps.LatLng(37.533807,126.896772),
				map : map
			});
			var contentString = [
				'<div class="iw_inner">',
				'	<h3>KH정보교육원</h3>',
				'	<p>서울시 영등포구 선유동2로 57 이레빌딩 19F,20F</p>',
				'</div>'
			].join("");
			var infoWindow = new naver.maps.InfoWindow();
			naver.maps.Event.addListener(marker,"click",function(e){
				if(infoWindow.getMap()){
					infoWindow.close();
				}else{
					infoWindow = new naver.maps.InfoWindow({
						content : contentString
					});
					infoWindow.open(map,marker);
				}
			});
			naver.maps.Event.addListener(map,"click",function(e){
				marker.setPosition(e.coord);	//마커위치를 클린한 위치로 이동
				if(infoWindow.getMap()){
					infoWindow.close();
				}
				//reverseGeocoder를 이용해서 위/경도값을 주소로 변환
				naver.maps.Service.reverseGeocode({
					location : new naver.maps.LatLng(e.coord.lat(),e.coord.lng()),
				},function(status,response){
					if(status!=naver.maps.Service.Status.OK){
						return alert("주소를 찾을 수 없습니다.");
					}
					var result = response.result;
					items = result.items;
					var address = items[1].address;
					contentString=[
						'<div class="iw_inner">',
						'<p>'+address+'</p>',
						'</div>'
					].join("");
				});
			});
		}
	
		function addrSearch(){
			new daum.Postcode({
				oncomplete : function(data){
					$("#postCode").val(data.zonecode);
					$("#roadAddr").val(data.roadAddress);
					$("#jibunAddr").val(data.jibunAddress);
					$("#datailAddr").focus();
				}
			}).open();
		}
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>