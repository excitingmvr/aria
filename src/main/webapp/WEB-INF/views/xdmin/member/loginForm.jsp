<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!-- head s -->
<%@include file="../include/head.jsp"%>
<!-- head e -->

<style type="text/css">

	.my-btn-kakao,
	.my-btn-kakao:hover,
	.my-btn-kakao:active,
	.my-btn-kakao:visited,
	.my-btn-kakao:focus {
	    background-color: #F7E600;
	    border-color: #F7E600;
	    color: #3A1D1D;
	}

	.my-btn-naver,
	.my-btn-naver:hover,
	.my-btn-naver:active,
	.my-btn-naver:visited,
	.my-btn-naver:focus {
	    background-color: #2DB400;
	    border-color: #2DB400;
	    color: white;
	}
	

	.my-btn-google,
	.my-btn-google:hover,
	.my-btn-google:active,
	.my-btn-google:visited,
	.my-btn-google:focus {
	    background-color: #ea4335;
	    border-color: #ea4335;
	    color: white;
	}

	.my-btn-facebook,
	.my-btn-facebook:hover,
	.my-btn-facebook:active,
	.my-btn-facebook:visited,
	.my-btn-facebook:focus {
	    background-color: #3b5998;
	    border-color: #3b5998;
	    color: white;
	}
	
	.my-wrap {
		width: 380px;		
	}
</style>
	
</head>
<body>
<!-- contents s -->
<div class="container my-wrap">
<form id="formLogin" name="formLogin" method="post">
	<div class="row row-cols-1 gy-3">
		<div class="col text-center">
			<img alt="" src="/resources/xdmin/image/logo_login_300_200.png">
		</div>		
    	<div class="col">
			<input type="text" id="ifmmId" name="ifmmId" maxlength="20" placeholder="ID" class="form-control" value="xdmin">
		</div>
		<div class="col">
			<input type="password" id="ifmmPassword" name="ifmmPassword" maxlength="20" placeholder="Password" class="form-control" value="aaa">
		</div>
		<div class="col">
			<div class="form-check form-switch">
			  <input type="checkbox" id="autoLogin" name="autoLogin" checked role="switch" class="form-check-input">
			  <label class="form-check-label" for="autoLogin">Auto login</label>
			</div>		
		</div>
		<div class="d-grid gap-2 mt-3">
			<button class="btn btn-secondary" type="button" id="btnLogin" name="">Login</button>
			<a href="/member/findIdPwdForm" class="text-center">Find Id/Password</a>
			<hr>
			cookie.seq: <c:out value="${cookie.cookieSeq.value }"/><br>
			<button class="btn my-btn-kakao" type="button">Kakao</button>
			<button class="btn my-btn-naver" type="button">Naver</button>
			<button class="btn my-btn-google" type="button">Google</button>
			<button class="btn my-btn-facebook" type="button">Facebook</button>
		</div>
	</div>
</form>
</div>
<!-- contents e -->

<!-- modalBase s -->
<%@include file="../include/modalBase.jsp"%>
<!-- modalBase e -->

<!-- linkJs s -->
<%@include file="../include/linkJs.jsp"%>
<!-- linkJs e -->
	
<script type="text/javascript">

	$("#btnLogin").on("click", function(){
		if(validation() == false) return false;
		
		$.ajax({
			async: true 
			,cache: false
			,type: "post"
			/* ,dataType:"json" */
			,url: "/member/loginProc"
			/* ,data : $("#formLogin").serialize() */
			,data : { "ifmmId" : $("#ifmmId").val(), "ifmmPassword" : $("#ifmmPassword").val(), "autoLogin" : $("#autoLogin").is(":checked")}
			,success: function(response) {
				if(response.rt == "success") {
					if(response.changePwd == "true") {
						location.href = URL_CHANGE_PWD_FORM;
					} else {
						location.href = URL_INDEX_ADMIN;
					}
				} else {
					alert("회원없음");
				}
			}
			,error : function(jqXHR, textStatus, errorThrown){
				alert("ajaxUpdate " + jqXHR.textStatus + " : " + jqXHR.errorThrown);
			}
		});
	});

	
	validation = function() {
		if(!checkNull($("#ifmmId"), $.trim($("#ifmmId").val()), "아이디를 입력해 주세요!")) return false;
		if(!checkNull($("#ifmmPassword"), $.trim($("#ifmmPassword").val()), "비밀번호를 입력해 주세요!")) return false;
    }
	

</script>
	
</body>
</html>