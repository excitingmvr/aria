<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@include file="../../../common/xdmin/includeV1/head.jsp"%>

<title>Code</title>		<!-- #-> -->

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
<c:set var="listCodeGender" value="${CodeServiceImpl.selectListCachedCode('3')}"/>
<c:set var="listCodeTelecom" value="${CodeServiceImpl.selectListCachedCode('10')}"/>

<!-- <form name="form" id="form" method="post" enctype="multipart/form-data"> -->
<form id="form" name="form" method="post" autocomplete="off" enctype="multipart/form-data">
<!-- *Vo.jsp s -->
<%@include file="codeVo.jsp"%>		<!-- #-> -->
<!-- *Vo.jsp e -->

<h3 class="mt-3 mb-0">코드 관리</h3>		<!-- #-> -->
 
<div class="container-fluid px-0 px-sm-5 mt-2">
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcgSeq" class="form-label">코드그룹 <span class="text-danger">*</span></label>
			<select id="ifcgSeq" name="ifcgSeq" class="form-select form-select-sm">
				<option>선택하세요</option>
				<c:forEach items="${list}" var="list" varStatus="status">
				<option value="<c:out value="${list.ifcgSeq }"/>"<c:if test="${list.ifcgSeq eq item.ifcgSeq }">selected</c:if>><c:out value="${list.ifcgName }"/></option>
				</c:forEach>
			</select>
			<div class="invalid-feedback" id="ifcgSeqFeedback"></div>
		</div>
		<div class="col-sm-6">
		</div>
	</div>
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdSeq" class="form-label">코드</label>
			<input type="text" id="ifcdSeq" name="ifcdSeq" value="<c:out value="${item.ifcdSeq}"/>" maxlength="20" placeholder="자동생성" class="form-control form-control-sm" readonly>
		</div>
		<div class="col-sm-6">
			<label for="ifcdSeqAnother" class="form-label">코드 (Another)</label>
			<input type="text" id="ifcdSeqAnother" name="ifcdSeqAnother" value="<c:out value="${item.ifcdSeqAnother}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdSeqAnotherFeedback"></div>
		</div>
	</div> 
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdName" class="form-label">코드 이름 (한글) <span class="text-danger">*</span></label>
			<input type="text" id="ifcdName" name="ifcdName" value="<c:out value="${item.ifcdName}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdNameFeedback"></div>
		</div>
		<div class="col-sm-6">
			<label for="ifcdNameEng" class="form-label">코드 이름 (영문)</label>
			<input type="text" id="ifcdNameEng" name="ifcdNameEng" value="<c:out value="${item.ifcdNameEng}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdNameEngFeedback"></div> 
		</div>
	</div> 
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdUseNy" class="form-label">사용여부 <span class="text-danger">*</span></label>
			<select id="ifcdUseNy" name="ifcdUseNy" class="form-select form-select-sm">
				<option value="1" <c:if test="${item.ifcdUseNy eq 1 }">selected</c:if>>Y</option>
				<option value="0" <c:if test="${item.ifcdUseNy eq 0 }">selected</c:if>>N</option>
			</select>
		</div>
		<div class="col-sm-6">
			<label for="ifcdOrder" class="form-label">순서 <span class="text-danger">*</span></label>
			<input type="text" id="ifcdOrder" name="ifcdOrder" value="<c:out value="${item.ifcdOrder}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdOrderFeedback"></div>        
		</div>
	</div>
	<div class="row mt-sm-4">
		<div class="col-sm-6 mt-3 mt-sm-0">
			<label for="ifcdDesc" class="form-label">설명</label>
			<textarea id="ifcdDesc" name="ifcdDesc" class="form-control"><c:out value="${item.ifcdDesc }"/></textarea>
		</div>
		<div class="col-sm-6 mt-3 mt-sm-0">
<%-- 		
			<label for="ifcdDelNy" class="form-label">삭제여부</label>
			<select id="ifcdDelNy" name="ifcdDelNy" class="form-select form-select-sm">
				<option value="0" <c:if test="${item.ifcdDelNy eq 0 }">selected</c:if>>N</option>
				<option value="1" <c:if test="${item.ifcdDelNy eq 1 }">selected</c:if>>Y</option>
			</select>
 --%>		
		</div>
	</div> 
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdNameLang1" class="form-label">다국어1</label>
			<input type="text" id="ifcdNameLang1" name="ifcdNameLang1" value="<c:out value="${item.ifcdNameLang1}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">
		</div>
		<div class="col-sm-6">
			<label for="ifcdNameLang2" class="form-label">다국어2 (varchar type)</label>
			<input type="text" id="ifcdNameLang2" name="ifcdNameLang2" value="<c:out value="${item.ifcdNameLang2}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">        
		</div>
	</div>
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdNameLang3" class="form-label">다국어3</label>
			<input type="text" id="ifcdNameLang3" name="ifcdNameLang3" value="<c:out value="${item.ifcdNameLang3}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">
		</div>
		<div class="col-sm-6">
			<label for="ifcdNameLang4" class="form-label">다국어4 (varchar type)</label>
			<input type="text" id="ifcdNameLang4" name="ifcdNameLang4" value="<c:out value="${item.ifcdNameLang4}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">        
		</div>
	</div>
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdNameLang5" class="form-label">다국어5</label>
			<input type="text" id="ifcdNameLang5" name="ifcdNameLang5" value="<c:out value="${item.ifcdNameLang5}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">
		</div>
		<div class="col-sm-6">
			<label for="ifcdNameLang6" class="form-label">다국어6 (varchar type)</label>
			<input type="text" id="ifcdNameLang6" name="ifcdNameLang6" value="<c:out value="${item.ifcdNameLang6}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">        
		</div>
	</div>
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdReferenceV1" class="form-label">예비1 (varchar type)</label>
			<input type="text" id="ifcdReferenceV1" name="ifcdReferenceV1" value="<c:out value="${item.ifcdReferenceV1}"/>" maxlength="20" placeholder="영대소문자,숫자" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceV1Feedback"></div>
		</div>
		<div class="col-sm-6">
			<label for="ifcdReferenceV2" class="form-label">예비2 (varchar type)</label>
			<input type="text" id="ifcdReferenceV2" name="ifcdReferenceV2" value="<c:out value="${item.ifcdReferenceV2}"/>" maxlength="20" placeholder="영대소문자,숫자" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceV2Feedback"></div>      
		</div>
	</div>	
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdReferenceV3" class="form-label">예비3 (varchar type)</label>
			<input type="text" id="ifcdReferenceV3" name="ifcdReferenceV3" value="<c:out value="${item.ifcdReferenceV3}"/>" maxlength="20" placeholder="영대소문자,숫자" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceV3Feedback"></div>
		</div>
		<div class="col-sm-6">
			<label for="ifcdReferenceV4" class="form-label">예비4 (varchar type)</label>
			<input type="text" id="ifcdReferenceV4" name="ifcdReferenceV4" value="<c:out value="${item.ifcdReferenceV4}"/>" maxlength="20" placeholder="영대소문자,숫자" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceV4Feedback"></div>
		</div>
	</div>	
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdReferenceI1" class="form-label">예비1 (Int type)</label>
			<input type="text" id="ifcdReferenceI1" name="ifcdReferenceI1" value="<c:out value="${item.ifcdReferenceI1}"/>" maxlength="20" placeholder="숫자" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceI1Feedback"></div>
		</div>
		<div class="col-sm-6">
			<label for="ifcdReferenceI2" class="form-label">예비2 (Int type)</label>
			<input type="text" id="ifcdReferenceI2" name="ifcdReferenceI2" value="<c:out value="${item.ifcdReferenceI2}"/>" maxlength="20" placeholder="숫자" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceI2Feedback"></div>        
		</div>
	</div>	
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdReferenceI3" class="form-label">예비3 (Int type)</label>
			<input type="text" id="ifcdReferenceI3" name="ifcdReferenceI3" value="<c:out value="${item.ifcdReferenceI3}"/>" maxlength="20" placeholder="숫자" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceI3Feedback"></div>
		</div>
		<div class="col-sm-6">
			<label for="ifcdReferenceI4" class="form-label">예비4 (Int type)</label>
			<input type="text" id="ifcdReferenceI4" name="ifcdReferenceI4" value="<c:out value="${item.ifcdReferenceI4}"/>" maxlength="20" placeholder="숫자" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceI4Feedback"></div>		
		</div>
	</div>

<c:if test="${not empty item.ifcdSeq }">		<!-- #-> -->
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
            <button type="button" class="btn btn-danger btn-sm" name="" id="btnDelete"><i class="fa-solid fa-x"></i></button>
            <button type="button" class="btn btn-danger btn-sm" name="" id="btnUelete"><i class="far fa-trash-alt"></i></button>
            <button type="button" class="btn btn-success btn-sm" name="" id="btnSave"><i class="fa-regular fa-bookmark"></i></button>
        </div>
    </div>
</div>

<%-- <c:out value="${Code.selectListCachedCode("15") }"/> --%>

</form>
<form name="formVo" id="formVo" method="post">
<!-- *Vo.jsp s -->
<%@include file="codeVo.jsp"%>		<!-- #-> -->
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
		 $("#ifmmDob").datepicker();
	}); 


	var goUrlList = "/code/codeList"; 			/* #-> */
	var goUrlInst = "/code/codeInst"; 			/* #-> */
	var goUrlUpdt = "/code/codeUpdt";			/* #-> */
	var goUrlUele = "/code/codeUele";			/* #-> */
	var goUrlDele = "/code/codeDele";			/* #-> */
	
	var seq = $("input:hidden[name=ifcdSeq]");				/* #-> */
	
	var form = $("form[name=form]");
	var formVo = $("form[name=formVo]");
	
	
	$("#btnSave").on("click", function(){
		if (seq.val() == "0" || seq.val() == ""){
	   		// insert
	   		if (validationInst() == false) return false;
 			setCheckboxValue($("#ifmmEmailConsent"), $("#ifmmEmailConsentNy"));
			setCheckboxValue($("#ifmmSmsConsent"), $("#ifmmSmsConsentNy"));
	   		form.attr("action", goUrlInst).submit();
	   	} else {
	   		// update
	   		/* keyName.val(atob(keyName.val())); */
	   		if (validationUpdt() == false) return false;
	   		form.attr("action", goUrlUpdt).submit();
	   	}
	}); 
	
	
	setCheckboxValue = function(obj, targetObj) {
	   if(obj.is(":checked")){
		   targetObj.val("1");
	    } else {
	    	targetObj.val("0");
	    }
	}
	
	
	validationInst = function() {
	   	if(validationUpdt() == false) return false;
	}

	
	validationUpdt = function() {
		if(!checkOnlyEnglishNumber('ifcdSeqAnother', 2, 1, "코드 (Another)는 영대소문자, 숫자만 입력 가능합니다.")) return false;
		if(!checkOnlyKoreanEnglishNumber('ifcdName', 2, 0, "코드 이름 (한글)은 한글, 영문대소문자, 숫자만 입력 가능합니다.")) return false;
		if(!checkOnlyEnglishNumber('ifcdNameEng', 2, 1, "코드 이름 (영문)는 영대소문자, 숫자만 입력 가능합니다.")) return false;
		if(!checkOnlyNumber('ifcdOrder', 2, 0, 0, 255, "순서는 숫자만 입력 가능합니다.")) return false;
		if(!checkOnlyEnglishNumber('ifcdReferenceV1', 2, 1, "예비1 (varchar type)은 영문대소문자, 숫자만 입력 가능합니다.")) return false;
 		if(!checkOnlyEnglishNumber('ifcdReferenceV2', 2, 1, "예비2 (varchar type)은 영문대소문자, 숫자만 입력 가능합니다.")) return false;
 		if(!checkOnlyEnglishNumber('ifcdReferenceV3', 2, 1, "예비3 (varchar type)은 영문대소문자, 숫자만 입력 가능합니다.")) return false;
 		if(!checkOnlyEnglishNumber('ifcdReferenceV4', 2, 1, "예비4 (varchar type)은 영문대소문자, 숫자만 입력 가능합니다.")) return false;
 		if(!checkOnlyNumber('ifcdReferenceI1', 2, 1, -128, 127, "예비1 (Int type)은 숫자만 입력 가능합니다.")) return false;
 		if(!checkOnlyNumber('ifcdReferenceI2', 2, 1, -128, 127, "예비2 (Int type)은 숫자만 입력 가능합니다.")) return false;
 		if(!checkOnlyNumber('ifcdReferenceI3', 2, 1, -128, 127, "예비3 (Int type)은 숫자만 입력 가능합니다.")) return false;
 		if(!checkOnlyNumber('ifcdReferenceI4', 2, 1, -128, 127, "예비4 (Int type)은 숫자만 입력 가능합니다.")) return false;		
	}
	
	
	$("#btnList").on("click", function(){
		formVo.attr("action", goUrlList).submit();
	}); 
	
	
	$("#btnUelete").on("click", function(){
		$("input:hidden[name=exDeleteType]").val(1);
		$(".modal-title").text("확 인");
		$(".modal-body").text("해당 데이터를 삭제하시겠습니까 ?");
		$("#btnModalUelete").show();
		$("#btnModalDelete").hide();
		$("#modalConfirm").modal("show");
	});
	

	$("#btnDelete").on("click", function(){
		$("input:hidden[name=exDeleteType]").val(2);
		$(".modal-title").text("확 인");
		$(".modal-body").text("해당 데이터를 삭제하시겠습니까 ?");
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
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('ifmaZipcodeArray0').value = data.zonecode;
                document.getElementById("ifmaAddress1Array0").value = roadAddr;
                /* document.getElementById("").value = data.jibunAddress; */
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                  
                if(roadAddr !== ''){
                    document.getElementById("ifmaAddress3Array0").value = extraRoadAddr;
                } else {
                    document.getElementById("ifmaAddress3Array0").value = '';
                }
                
/*  
                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
 */               
				
 				/* lat and lng from address s */
 				
				// 주소-좌표 변환 객체를 생성
				var geocoder = new daum.maps.services.Geocoder();
				
				// 주소로 좌표를 검색
				geocoder.addressSearch(roadAddr, function(result, status) {
				 
					// 정상적으로 검색이 완료됐으면,
					if (status == daum.maps.services.Status.OK) {
						
						document.getElementById("ifmaLatArray0").value=result[0].y;
						document.getElementById("ifmaLngArray0").value=result[0].x;
						
/* 						
						var coords = new daum.maps.LatLng(result[0].y, result[0].x);
				
						y = result[0].x;
						x = result[0].y;
				
						// 결과값으로 받은 위치를 마커로 표시합니다.
						var marker = new daum.maps.Marker({
							map: map,
							position: coords
						});
				
						// 인포윈도우로 장소에 대한 설명표시
						var infowindow = new daum.maps.InfoWindow({
							content: '<div style="width:150px;text-align:center;padding:5px 0;">좌표위치</div>'
						});
				
						infowindow.open(map,marker);
				
						// 지도 중심을 이동
						map.setCenter(coords);
						
						document.getElementById("ifmaLatArray0").value=x;
						document.getElementById("ifmaLngArray0").value=y;
 */						
					}
				});
				/* lat and lng from address e */

       }
   
        }).open();
        

    }
	

	$("#btnAddressClear").on("click", function(){	
		$("#ifmaZipcodeArray0").val('');
		$("#ifmaAddress1Array0").val('');
		$("#ifmaAddress2Array0").val('');
		$("#ifmaAddress3Array0").val('');
	});
	
	
	upload = function(seq, div) {
		
		$("#ulFile" + seq).children().remove();
		
		var fileCount = $("input[type=file]")[seq].files.length;
		
		if(checkUploadedTotalFileNumber(fileCount, seq) == false) { return false; }
		
		var totalFileSize;
		for (var i = 0 ; i < fileCount ; i++) {
			if(div == 1) {
				if(checkUploadedAllExt($("input[type=file]")[seq].files[i].name, seq) == false) { return false; }
			} else if (div == 2){
				if(checkUploadedImageExt($("input[type=file]")[seq].files[i].name, seq) == false) { return false; }
			} else {
				return false;
			}
			
			if(checkUploadedEachFileSize($("input[type=file]")[seq].files[i].name, seq) == false) { return false; }
			totalFileSize += $("input[type=file]")[seq].files[i].size;
		}
		
		if(checkUploadedTotalFileSize(totalFileSize, seq) == false) { return false; }
		
		for (var i = 0 ; i < fileCount ; i++) {
			addUploadLi(seq, i, $("input[type=file]")[seq].files[i].name);
		}
	}
	
	
	addUploadLi = function (seq, index, name){
		
		var ul_list = $("#ulFile0");
		
		li = '<li id="li_'+seq+'_'+index+'" class="list-group-item d-flex justify-content-between align-items-center">';
		li = li + name;
		li = li + '<span class="badge bg-danger rounded-pill" onClick="delLi('+ seq +','+ index +')"><i class="fa-solid fa-x" style="cursor: pointer;"></i></span>';
		li = li + '</li>';
		
		$("#ulFile"+seq).append(li);
	}
	
	
	delLi = function(seq, index) {
		$("#li_"+seq+"_"+index).remove();
	}
	
	
</script>

</body>
</html>