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

<h3 class="mt-3 mb-0">?????? ??????</h3>		<!-- #-> -->
 
<div class="container-fluid px-0 px-sm-5 mt-2">
	<div class="row mt-sm-4">
		<div class="col-sm-6">
<%-- 		
			<label for="ifcgSeq" class="form-label">???????????? <span class="text-danger">*</span></label>
            <input list="datalistOptions" name="ifcgSeq" id="ifcgSeq" placeholder="???????????? ??????" class="form-control form-select-sm">
            <datalist id="datalistOptions">
            	<c:forEach items="${list}" var="list" varStatus="status">
                <option value="<c:out value="${list.ifcgSeq }"/>"<c:if test="${list.ifcgSeq eq item.ifcgSeq }">selected</c:if>><c:out value="${list.ifcgName }"/></option>
                </c:forEach>
            </datalist>
 --%>            
			<label for="ifcgSeq" class="form-label">???????????? <span class="text-danger">*</span></label>
			<select id="ifcgSeq" name="ifcgSeq" class="form-select form-select-sm">
				<option value="">???????????????</option>
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
			<label for="ifcdSeq" class="form-label">??????</label>
			<input type="text" id="ifcdSeq" name="ifcdSeq" value="<c:out value="${item.ifcdSeq}"/>" maxlength="20" placeholder="????????????" class="form-control form-control-sm" readonly>
		</div>
		<div class="col-sm-6">
			<label for="ifcdSeqAnother" class="form-label">?????? (Another)</label>
			<input type="text" id="ifcdSeqAnother" name="ifcdSeqAnother" value="<c:out value="${item.ifcdSeqAnother}"/>" maxlength="20" placeholder="???????????????, ??????" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdSeqAnotherFeedback"></div>
		</div>
	</div> 
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdName" class="form-label">?????? ??????<span class="text-danger">*</span></label>
			<input type="text" id="ifcdName" name="ifcdName" value="<c:out value="${item.ifcdName}"/>" maxlength="20" placeholder="??????, ???????????????, ??????" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdNameFeedback"></div>
		</div>
		<div class="col-sm-6">
			<label for="ifcdNameEng" class="form-label">?????? ?????? (??????)</label>
			<input type="text" id="ifcdNameEng" name="ifcdNameEng" value="<c:out value="${item.ifcdNameEng}"/>" maxlength="20" placeholder="???????????????, ??????" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdNameEngFeedback"></div> 
		</div>
	</div> 
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdUseNy" class="form-label">???????????? <span class="text-danger">*</span></label>
			<select id="ifcdUseNy" name="ifcdUseNy" class="form-select form-select-sm">
				<option value="1" <c:if test="${item.ifcdUseNy eq 1 }">selected</c:if>>Y</option>
				<option value="0" <c:if test="${item.ifcdUseNy eq 0 }">selected</c:if>>N</option>
			</select>
		</div>
		<div class="col-sm-6">
			<label for="ifcdOrder" class="form-label">?????? <span class="text-danger">*</span></label>
			<input type="text" id="ifcdOrder" name="ifcdOrder" value="<c:out value="${item.ifcdOrder}"/>" maxlength="20" placeholder="??????(0~255)" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdOrderFeedback"></div>        
		</div>
	</div>
	<div class="row mt-sm-4">
		<div class="col-sm-6 mt-3 mt-sm-0">
			<label for="ifcdDesc" class="form-label">??????</label>
			<textarea id="ifcdDesc" name="ifcdDesc" class="form-control"><c:out value="${item.ifcdDesc }"/></textarea>
		</div>
		<div class="col-sm-6 mt-3 mt-sm-0">
<%-- 		
			<label for="ifcdDelNy" class="form-label">????????????</label>
			<select id="ifcdDelNy" name="ifcdDelNy" class="form-select form-select-sm">
				<option value="0" <c:if test="${item.ifcdDelNy eq 0 }">selected</c:if>>N</option>
				<option value="1" <c:if test="${item.ifcdDelNy eq 1 }">selected</c:if>>Y</option>
			</select>
 --%>		
		</div>
	</div> 
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdNameLang1" class="form-label">?????????1 (varchar type)</label>
			<input type="text" id="ifcdNameLang1" name="ifcdNameLang1" value="<c:out value="${item.ifcdNameLang1}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">
		</div>
		<div class="col-sm-6">
			<label for="ifcdNameLang2" class="form-label">?????????2 (varchar type)</label>
			<input type="text" id="ifcdNameLang2" name="ifcdNameLang2" value="<c:out value="${item.ifcdNameLang2}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">        
		</div>
	</div>
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdNameLang3" class="form-label">?????????3 (varchar type)</label>
			<input type="text" id="ifcdNameLang3" name="ifcdNameLang3" value="<c:out value="${item.ifcdNameLang3}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">
		</div>
		<div class="col-sm-6">
			<label for="ifcdNameLang4" class="form-label">?????????4 (varchar type)</label>
			<input type="text" id="ifcdNameLang4" name="ifcdNameLang4" value="<c:out value="${item.ifcdNameLang4}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">        
		</div>
	</div>
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdNameLang5" class="form-label">?????????5 (varchar type)</label>
			<input type="text" id="ifcdNameLang5" name="ifcdNameLang5" value="<c:out value="${item.ifcdNameLang5}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">
		</div>
		<div class="col-sm-6">
			<label for="ifcdNameLang6" class="form-label">?????????6 (varchar type)</label>
			<input type="text" id="ifcdNameLang6" name="ifcdNameLang6" value="<c:out value="${item.ifcdNameLang6}"/>" maxlength="20" placeholder="" class="form-control form-control-sm">        
		</div>
	</div>
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdReferenceV1" class="form-label">??????1 (varchar type)</label>
			<input type="text" id="ifcdReferenceV1" name="ifcdReferenceV1" value="<c:out value="${item.ifcdReferenceV1}"/>" maxlength="20" placeholder="???????????????,??????" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceV1Feedback"></div>
		</div>
		<div class="col-sm-6">
			<label for="ifcdReferenceV2" class="form-label">??????2 (varchar type)</label>
			<input type="text" id="ifcdReferenceV2" name="ifcdReferenceV2" value="<c:out value="${item.ifcdReferenceV2}"/>" maxlength="20" placeholder="???????????????,??????" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceV2Feedback"></div>      
		</div>
	</div>	
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdReferenceV3" class="form-label">??????3 (varchar type)</label>
			<input type="text" id="ifcdReferenceV3" name="ifcdReferenceV3" value="<c:out value="${item.ifcdReferenceV3}"/>" maxlength="20" placeholder="???????????????,??????" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceV3Feedback"></div>
		</div>
		<div class="col-sm-6">
			<label for="ifcdReferenceV4" class="form-label">??????4 (varchar type)</label>
			<input type="text" id="ifcdReferenceV4" name="ifcdReferenceV4" value="<c:out value="${item.ifcdReferenceV4}"/>" maxlength="20" placeholder="???????????????,??????" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceV4Feedback"></div>
		</div>
	</div>	
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdReferenceI1" class="form-label">??????1 (Int type)</label>
			<input type="text" id="ifcdReferenceI1" name="ifcdReferenceI1" value="<c:out value="${item.ifcdReferenceI1}"/>" maxlength="4" placeholder="??????" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceI1Feedback"></div>
		</div>
		<div class="col-sm-6">
			<label for="ifcdReferenceI2" class="form-label">??????2 (Int type)</label>
			<input type="text" id="ifcdReferenceI2" name="ifcdReferenceI2" value="<c:out value="${item.ifcdReferenceI2}"/>" maxlength="4" placeholder="??????" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceI2Feedback"></div>        
		</div>
	</div>	
	<div class="row mt-sm-4">
		<div class="col-sm-6">
			<label for="ifcdReferenceI3" class="form-label">??????3 (Int type)</label>
			<input type="text" id="ifcdReferenceI3" name="ifcdReferenceI3" value="<c:out value="${item.ifcdReferenceI3}"/>" maxlength="4" placeholder="??????" class="form-control form-control-sm">
			<div class="invalid-feedback" id="ifcdReferenceI3Feedback"></div>
		</div>
		<div class="col-sm-6">
			<label for="ifcdReferenceI4" class="form-label">??????4 (Int type)</label>
			<input type="text" id="ifcdReferenceI4" name="ifcdReferenceI4" value="<c:out value="${item.ifcdReferenceI4}"/>" maxlength="4" placeholder="??????" class="form-control form-control-sm">
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
<c:if test="${not empty item.ifcdSeq }">	<!-- #-> -->        
            <button type="button" class="btn btn-danger btn-sm" name="" id="btnDelete"><i class="fa-solid fa-x"></i></button>
            <button type="button" class="btn btn-danger btn-sm" name="" id="btnUelete"><i class="far fa-trash-alt"></i></button>
</c:if>
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
	
	var seq = $("input:hidden[name=ifcdSeq]");	/* #-> */
	
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
	   		seq.remove();
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

		if(!checkSelectNull('ifcgSeq', 2, "??????????????? ????????? ?????????.")) return false;
		if(!checkOnlyEnglishNumber('ifcdSeqAnother', 2, 1, "?????? (Another)??? ???????????????, ????????? ?????? ???????????????.")) return false;
		if(!checkOnlyKoreanEnglishNumber('ifcdName', 2, 0, "?????? ????????? ??????, ??????????????????, ????????? ?????? ???????????????.")) return false;
		if(!checkOnlyEnglishNumber('ifcdNameEng', 2, 1, "?????? ?????? (??????)??? ???????????????, ????????? ?????? ???????????????.")) return false;
		if(!checkOnlyNumber('ifcdOrder', 2, 0, 1, 0, 255, "????????? ??????(0~255)??? ?????? ???????????????.")) return false;
		if(!checkOnlyEnglishNumber('ifcdReferenceV1', 2, 1, "??????1 (varchar type)??? ??????????????????, ????????? ?????? ???????????????.")) return false;
 		if(!checkOnlyEnglishNumber('ifcdReferenceV2', 2, 1, "??????2 (varchar type)??? ??????????????????, ????????? ?????? ???????????????.")) return false;
 		if(!checkOnlyEnglishNumber('ifcdReferenceV3', 2, 1, "??????3 (varchar type)??? ??????????????????, ????????? ?????? ???????????????.")) return false;
 		if(!checkOnlyEnglishNumber('ifcdReferenceV4', 2, 1, "??????4 (varchar type)??? ??????????????????, ????????? ?????? ???????????????.")) return false;
 		if(!checkOnlyNumber('ifcdReferenceI1', 2, 1, 1, -128, 127, "??????1 (Int type)??? ??????(-128~127)??? ?????? ???????????????.")) return false;
 		if(!checkOnlyNumber('ifcdReferenceI2', 2, 1, 1, -128, 127, "??????2 (Int type)??? ??????(-128~127)??? ?????? ???????????????.")) return false;
 		if(!checkOnlyNumber('ifcdReferenceI3', 2, 1, 1, -128, 127, "??????3 (Int type)??? ??????(-128~127)??? ?????? ???????????????.")) return false;
 		if(!checkOnlyNumber('ifcdReferenceI4', 2, 1, 1, -128, 127, "??????4 (Int type)??? ??????(-128~127)??? ?????? ???????????????.")) return false;		

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
	
</script>

</body>
</html>