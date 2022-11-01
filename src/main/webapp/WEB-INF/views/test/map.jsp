<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Kakao 지도 시작하기</title>
</head>
<body>

      		<c:set var="type" value="1"/>		<!-- #-> -->
        	<c:set var="name" value="uploadImgProfile"/>		<!-- #-> -->
        	
        	<c:set var="${name }" value="0"/>


	<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cc0680fedff73402526955076f9c7d53"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
	</script>
</body>
</html>