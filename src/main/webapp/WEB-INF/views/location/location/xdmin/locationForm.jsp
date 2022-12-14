<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!-- head s -->
<%@include file="../../../common/xdmin/includeV1/head.jsp"%>
<!-- head e -->

<title>Location</title>		<!-- #-> -->

<style type="text/css">

	.addScroll{
		overflow-y:auto;
		height: 90px;
		background-color:#E9ECEF;
	}
 	
	.input-file-button{
		padding: 4px 25px;
		background-color:#FF6600;
		border-radius: 4px;
		color: white;
		cursor: pointer;
	}	

</style>
</head>
<body>

<!-- top s -->
<%@include file="../../../common/xdmin/includeV1/top.jsp"%>
<!-- top e -->

<!-- gnb s -->
<%@include file="../../../common/xdmin/includeV1/gnb.jsp"%>
<!-- gnb e -->

<!-- right menu s -->
<%@include file="../../../common/xdmin/includeV1/right.jsp"%>
<!-- right menu e -->

<!-- contents s -->
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-2 d-none d-md-block">
		
<!-- left menu s -->
<div class="flex-shrink-0 p-3 bg-white">
<!-- 		
   	<a href="/" class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
		<svg class="bi me-2" width="30" height="24"><use xlink:href="#bootstrap"/></svg>
		<span class="fs-5 fw-semibold">Collapsible</span>
   	</a>
 -->		
	<ul class="list-unstyled ps-0">
		<li class="mb-1">
			<button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="fasle">Home</button>
			<div class="collapse" id="home-collapse">
<!-- 
					<button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="true">Home</button>
					<div class="collapse show" id="home-collapse">
 -->
				<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
					<li><a href="#" class="link-dark rounded">Overview</a></li>
					<li><a href="#" class="link-dark rounded">Updates</a></li>
					<li><a href="#" class="link-dark rounded">Reports</a></li>
				</ul>
			</div>
		</li>
		<li class="mb-1">
			<button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">Dashboard</button>
			<div class="collapse" id="dashboard-collapse">
				<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
					<li><a href="#" class="link-dark rounded">Overview</a></li>
					<li><a href="#" class="link-dark rounded">Weekly</a></li>
					<li><a href="#" class="link-dark rounded">Monthly</a></li>
					<li><a href="#" class="link-dark rounded">Annually</a></li>
				</ul>
			</div>
		</li>
		<li class="mb-1">
			<button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">Orders</button>
			<div class="collapse" id="orders-collapse">
				<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
					<li><a href="#" class="link-dark rounded">New</a></li>
					<li><a href="#" class="link-dark rounded">Processed</a></li>
					<li><a href="#" class="link-dark rounded">Shipped</a></li>
					<li><a href="#" class="link-dark rounded">Returned</a></li>
				</ul>
			</div>
		</li>
		<li class="border-top my-3"></li>
		<li class="mb-1">
			<button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">Account</button>
			<div class="collapse" id="account-collapse">
				<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
					<li><a href="#" class="link-dark rounded">New...</a></li>
					<li><a href="#" class="link-dark rounded">Profile</a></li>
					<li><a href="#" class="link-dark rounded">Settings</a></li>
					<li><a href="#" class="link-dark rounded">Sign out</a></li>
				</ul>
			</div>
		</li>
	</ul>
</div>
<!-- left menu e -->

		</div>
		<div class="col-sm-10">

<!-- main s -->


<!-- <form name="form" id="form" method="post" enctype="multipart/form-data"> -->
<form id="form" name="form" method="post" autocomplete="off" enctype="multipart/form-data">
<!-- *Vo.jsp s -->
<%@include file="locationVo.jsp"%>		<!-- #-> -->
<!-- *Vo.jsp e -->

<h3 class="mt-3 mb-0">?????? ??????</h3>		<!-- #-> -->
 
<div class="container-fluid px-0 px-sm-5 mt-2">
    <div class="row mt-sm-4">
        <div class="col-sm-6">
            <label for="ltltName" class="form-label">?????? <span class="text-danger">*</span></label>
            <input type="text" id="ltltName" name="ltltName" value="<c:out value="${item.ltltName}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">
            <div class="invalid-feedback" id="ltltNameFeedback"></div>
        </div>
        <div class="col-sm-6">
			<label for="ltltCeo" class="form-label">?????????</label>
            <input type="text" id="ltltCeo" name="ltltCeo" value="<c:out value="${item.ltltCeo}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">
            <div class="invalid-feedback" id="ltltCeoFeedback"></div>
        </div>
    </div>
    <div class="row mt-sm-4">
        <div class="col-sm-6">
			<label for="ltltStartDate" class="form-label">?????????</label>
            <input type="text" id="ltltEstDate" name="ltltEstDate" value="<c:out value="${item.ltltEstDate}"/>" maxlength="20" placeholder="" class="form-control form-control-sm" readonly>
            <div class="invalid-feedback" id="ltltEstDateFeedback"></div>
        </div>
        <div class="col-sm-6">
            <label for="ltltEstDate" class="form-label">?????????</label>
            <input type="text" id="ltltStartDate" name="ltltStartDate" value="<c:out value="${item.ltltStartDate}"/>" maxlength="20" placeholder="" class="form-control form-control-sm" readonly>
            <div class="invalid-feedback" id="ltltStartDateFeedback"></div>        
        </div>
    </div>
    <div class="row mt-sm-4">
        <div class="col-sm-6">
            <label for="ltltPhone1" class="form-label">?????? <span class="text-danger">*</span></label>
            <input type="text" id="ltltPhone1" name="ltltPhone1" value="<c:out value="${item.ltltPhone1}"/>" maxlength="20" placeholder="?????? (021231234)" class="form-control form-control-sm">
            <div class="invalid-feedback" id="ltltPhone1Feedback"></div>
        </div>
        <div class="col-sm-6">
			<label for="ltltMobile" class="form-label">?????????</label>
            <input type="text" id="ltltMobile" name="ltltMobile" value="<c:out value="${item.ltltMobile}"/>" maxlength="20" placeholder="?????? (01022223333)" class="form-control form-control-sm">
            <div class="invalid-feedback" id="ltltMobileFeedback"></div>        
        </div>
    </div>
    <div class="row mt-sm-4">
        <div class="col-sm-6">
            <label for="ltltFax" class="form-label">??????</label>
            <input type="text" id="ltltFax" name="ltltFax" value="<c:out value="${item.ltltFax}"/>" maxlength="20" placeholder="?????? (021231234)" class="form-control form-control-sm">
            <div class="invalid-feedback" id="ltltFaxFeedback"></div>
        </div>
        <div class="col-sm-6">
			<label for="ltltEmail" class="form-label">?????????</label>
            <input type="text" id="ltltEmail" name="ltltEmail" value="<c:out value="${item.ltltEmail}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">
            <div class="invalid-feedback" id="ltltEmailFeedback"></div>        
        </div>
    </div>
    <div class="row mt-sm-4">
        <div class="col-sm-6">
			<label for="ltltUseNy" class="form-label">???????????? <span class="text-danger">*</span></label>
            <select id="ltltUseNy" name="ltltUseNy" class="form-select form-select-sm">
				<option value="1" <c:if test="${item.ltltUseNy eq 1 }">selected</c:if>>Y</option>
				<option value="0" <c:if test="${item.ltltUseNy eq 0 }">selected</c:if>>N</option>
              </select>  
        </div>
        <div class="col-sm-6">
        </div>
    </div>
    <div class="row mt-sm-4">
        <div class="col-sm-6">
            <label for="ltltZipcode" class="form-label">?????? <span class="text-danger">*</span></label>
            <div class="input-group input-group-sm ">
                <input type="text" id="ltltZipcode" name="ltltZipcode" value="<c:out value="${item.ltltZipcode }"/>" placeholder="????????????" class="form-control" readonly>
                <button type="button" id="btnAddress" class="btn btn-outline-secondary"><i class="fas fa-search"></i></button>
                <button type="button" id="btnAddressClear" class="btn btn-outline-secondary"><i class="fa-solid fa-x"></i></button>
            </div>
            <input type="text" id="ltltAddress1" name="ltltAddress1" value="<c:out value="${item.ltltAddress1 }"/>" maxlength="50" placeholder="??????" class="form-control form-control-sm mt-2" readonly>
            <input type="text" id="ltltAddress2" name="ltltAddress2" value="<c:out value="${item.ltltAddress2 }"/>" maxlength="50" placeholder="????????????" class="form-control form-control-sm mt-2">
            <input type="text" id="ltltAddress3" name="ltltAddress3" value="<c:out value="${item.ltltAddress3 }"/>" maxlength="50" placeholder="????????????" class="form-control form-control-sm mt-2" readonly>
			<div class="invalid-feedback" id="ltltAddressFeedback"></div>
			<div class="row">
				<div class="col-sm-6"><input type="hidden" id="ltltLat" name="ltltLat" value="<c:out value="${item.ltltLat }"/>" maxlength="50" placeholder="??????" class="form-control form-control-sm mt-2" readonly></div>
				<div class="col-sm-6"><input type="hidden" id="ltltLng" name="ltltLng" value="<c:out value="${item.ltltLng }"/>" maxlength="50" placeholder="??????" class="form-control form-control-sm mt-2" readonly></div>
			</div>
			
        </div>
        <div class="col-sm-6">
            <label for="ltltDesc" class="form-label">??????</label>
            <textarea id="ltltDesc" name="ltltDesc" rows="5" class="form-control"><c:out value="${item.ltltDesc }"/></textarea>               
        </div>
    </div>
    <div class="row mt-sm-4">
        <div class="col-sm-6">
			<div id="map" style="height:400px;"></div>
        </div>
        <div class="col-sm-6">
              
        </div>
    </div>

<c:if test="${not empty item.ltltSeq }">	<!-- #-> -->
<!-- regMod s -->
<%@include file="../../../common/xdmin/includeV1/regmod.jsp"%>
<!-- regMod e -->
</c:if>
</div>
 
<div class="container-fluid px-0 px-sm-5 mt-3">
    <div class="row">
        <div class="col-6 text-start">
            <button type="button" class="btn btn-secondary btn-sm" name="" id="btnList"><i class="fa-solid fa-bars"></i></button>
        </div>
        <div class="col-6 text-end">
<c:if test="${not empty item.ltltSeq }">	<!-- #-> -->        
            <button type="button" class="btn btn-danger btn-sm" name="" id="btnDelete"><i class="fa-solid fa-x"></i></button>
            <button type="button" class="btn btn-danger btn-sm" name="" id="btnUelete"><i class="far fa-trash-alt"></i></button>
</c:if>            
            <button type="button" class="btn btn-success btn-sm" name="" id="btnSave"><i class="fa-regular fa-bookmark"></i></button>
        </div>
    </div>
</div>

</form>
<form name="formVo" id="formVo" method="post">
<!-- *Vo.jsp s -->
<%@include file="locationVo.jsp"%>		<!-- #-> -->
<!-- *Vo.jsp e -->
</form>
<!-- main e -->

		</div>
	</div>
</div>
<!-- contents e -->

<!-- footer s -->
<%@include file="../../../common/xdmin/includeV1/footer.jsp"%>
<!-- footer e -->

<!-- modalBase s -->
<%@include file="../../../common/xdmin/includeV1/modalBase.jsp"%>
<!-- modalBase e -->

<!-- linkJs s -->
<%@include file="../../../common/xdmin/includeV1/linkJs.jsp"%>
<!-- linkJs e -->

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=45c6f58ea9a7ecfabff6e596d5079958&libraries=services"></script>

<script>

	$(document).ready(function(){
		$("#ltltEstDate, #ltltStartDate").datepicker();
		 
		setMap();
	}); 

	var state = '<c:out value="${item.ltltSeq }" default="0"/>';
	
	var goUrlList = "/location/locationAjaxList"; 			/* #-> */
	var goUrlInst = "/location/locationInst"; 			/* #-> */
	var goUrlUpdt = "/location/locationUpdt";			/* #-> */
	var goUrlUele = "/location/locationUele";			/* #-> */
	var goUrlDele = "/location/locationDele";			/* #-> */
	
	var seq = $("input:hidden[name=ltltSeq]");		/* #-> */
	
	var form = $("form[name=form]");
	var formVo = $("form[name=formVo]");
	
	
	$("#btnSave").on("click", function(){
		if (seq.val() == "0" || seq.val() == ""){
	   		// insert
	   		if (validationInst() == false) return false;
	   		form.attr("action", goUrlInst).submit();
	   	} else {
	   		// update
	   		/* keyName.val(atob(keyName.val())); */
	   		seq.remove();
	   		if (validationUpdt() == false) return false;
	   		form.attr("action", goUrlUpdt).submit();
	   	}
	}); 
	
	
	validationInst = function() {
	   	if(validationUpdt() == false) return false;
	}


	validationUpdt = function() {
		if(!checkNull('ltltName', 2, "????????? ????????? ?????????")) return false;
		if(!checkOnlyNumber('ltltPhone1', 2, 0, 0, 0, 0, "????????? ????????? ????????? ?????????")) return false;
		if(!checkMobile('ltltMobile', 2, 1, "???????????? ????????? ????????? ????????? ????????? ?????????")) return false;
		if(!checkOnlyNumber('ltltFax', 2, 1, 0, 0, 0, "????????? ????????? ????????? ?????????")) return false;
		if(!checkEmail('ltltEmail', 2, 1, "????????? ????????? ????????? ?????????")) return false;

		if ($("#ltltAddress1").val() == "" || $("#ltltAddress2").val().trim() == "") {
			$("#ltltZipcode").addClass('is-invalid');
			$("#ltltAddress1").addClass('is-invalid');
			$("#ltltAddress2").addClass('is-invalid');
			$("#ltltAddress3").addClass('is-invalid');
			$("#ltltAddressFeedback").text("?????? ??? ??????????????? ????????? ?????????");
			return false;
		} else {
			$("#ltltZipcode").removeClass('is-invalid');
			$("#ltltAddress1").removeClass('is-invalid');
			$("#ltltAddress2").removeClass('is-invalid');
			$("#ltltAddress3").removeClass('is-invalid');
		}
	}
	
	
	$("#btnList").on("click", function(){
		formVo.attr("action", goUrlList).submit();
	}); 
	
	
	$("#btnUelete").on("click", function(){
		$("input:hidden[name=exDeleteType]").val(1);
		$(".modal-title").text("??? ???");
		$(".modal-body").text("?????? ???????????? ???????????????????????? ?");
		$("#btnModalUelete").show();
		$("#btnModalDelete").hide();
		$("#modalConfirm").modal("show");
	});
	

	$("#btnDelete").on("click", function(){
		$("input:hidden[name=exDeleteType]").val(2);
		$(".modal-title").text("??? ???");
		$(".modal-body").text("?????? ???????????? ???????????????????????? ?");
		$("#btnModalUelete").hide();
		$("#btnModalDelete").show();
		$("#modalConfirm").modal("show");
	});
	
	
	$("#btnModalUelete").on("click", function(){
		$("#modalConfirm").modal("hide");
		formVo.attr("action", goUrlUele).submit();
	});
	
	
	$("#btnModalDelete").on("click", function(){
		$("#modalConfirm").modal("hide");
		formVo.attr("action", goUrlDele).submit();
	});
	
	
	$("#btnAddress").on("click", function(){	
	    sample4_execDaumPostcode();
	});	  
	
	
	function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // ???????????? ???????????? ????????? ??????????????? ????????? ????????? ???????????? ??????.

                // ????????? ????????? ?????? ????????? ?????? ????????? ????????????.
                // ???????????? ????????? ?????? ?????? ????????? ??????('')?????? ????????????, ?????? ???????????? ?????? ??????.
                var roadAddr = data.roadAddress; // ????????? ?????? ??????
                var extraRoadAddr = ''; // ?????? ?????? ??????

                // ??????????????? ?????? ?????? ????????????. (???????????? ??????)
                // ???????????? ?????? ????????? ????????? "???/???/???"??? ?????????.
                if(data.bname !== '' && /[???|???|???]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // ???????????? ??????, ??????????????? ?????? ????????????.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // ????????? ??????????????? ?????? ??????, ???????????? ????????? ?????? ???????????? ?????????.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // ??????????????? ?????? ????????? ?????? ????????? ?????????.
                document.getElementById("ltltZipcode").value = data.zonecode;
                document.getElementById("ltltAddress1").value = roadAddr;
                /* document.getElementById("").value = data.jibunAddress; */
                
                // ???????????? ???????????? ?????? ?????? ?????? ????????? ?????????.
                  
                if(roadAddr !== ''){
                    document.getElementById("ltltAddress3").value = extraRoadAddr;
                } else {
                    document.getElementById("ltltAddress3").value = '';
                }
                
/*  
                var guideTextBox = document.getElementById("guide");
                // ???????????? '?????? ??????'??? ????????? ??????, ?????? ???????????? ????????? ?????????.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(?????? ????????? ?????? : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(?????? ?????? ?????? : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
 */               
				
 				/* lat and lng from address s */
				var geocoder = new daum.maps.services.Geocoder();
				geocoder.addressSearch(roadAddr, function(result, status) {
					if (status == daum.maps.services.Status.OK) {
						document.getElementById("ltltLat").value=result[0].y;
						document.getElementById("ltltLng").value=result[0].x;
						
						var moveLatLon = new kakao.maps.LatLng(result[0].y, result[0].x);
					    map.setCenter(moveLatLon);
					    
						var markerPosition  = new kakao.maps.LatLng(result[0].y, result[0].x); 
						var marker = new kakao.maps.Marker({ position: markerPosition });
						marker.setMap(null);   
						marker.setMap(map);
					}
				});
				/* lat and lng from address e */
	       }
        }).open();
    }
	

	$("#btnAddressClear").on("click", function(){	
		$("#ltltZipcode").val('');
		$("#ltltAddress1").val('');
		$("#ltltAddress2").val('');
		$("#ltltAddress3").val('');
	});
	
	
	setMap = function() {
		if(state == "0") {
			getNowLatLng();
		} else {
			var lat = '<c:out value="${item.ltltLat }"/>';
			var lng = '<c:out value="${item.ltltLng}"/>';
			
			/* kakao source s */
			var container = document.getElementById("map");
		 	var options = {
		 			center: new kakao.maps.LatLng(lat, lng),
		 			level: 3
		 		};
			map = new kakao.maps.Map(container, options);
			
			var markerPosition  = new kakao.maps.LatLng(lat, lng); 
			var marker = new kakao.maps.Marker({ position: markerPosition });
			marker.setMap(null);   
			marker.setMap(map);
			/* kakao source e */
		}
	}

	
	function getNowLatLng(){
		if (navigator.geolocation) {
			var options = {timeout:60000};
			navigator.geolocation.getCurrentPosition(showLocation, errorHandler, options);
		} else {
			alert("?????? ?????? ?????? ????????? ??????????????????.");
		}
	}
	
	
	function showLocation(position) {
		var lat = position.coords.latitude;
		var lng = position.coords.longitude;
		
		/* kakao source s */
		var container = document.getElementById("map");
	 	var options = {
	 			center: new kakao.maps.LatLng(lat, lng),
	 			level: 3
	 		};
		map = new kakao.maps.Map(container, options);
		
		var markerPosition  = new kakao.maps.LatLng(lat, lng); 
		var marker = new kakao.maps.Marker({ position: markerPosition });
		marker.setMap(null);   
		marker.setMap(map);
		/* kakao source e */
	}
	
	
	function errorHandler(error) {
		if(error.code == 1) {
			alert("????????????");
		} else if( err.code == 2) {
			alert("????????? ????????? ??? ????????????.");
		}
	}


</script>

</body>
</html>