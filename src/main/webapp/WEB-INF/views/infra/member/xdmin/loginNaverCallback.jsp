<!doctype html>
<html lang="ko">
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<form name="form">
	<input type="hidden" name="ifmmName"/>
	<input type="hidden" name="ifmmId"/>
	<input type="hidden" name="ifmpNumber"/>
	<input type="hidden" name="ifmeEmailFull"/>
	<input type="hidden" name="ifmmGenderCd"/>
	<input type="hidden" name="ifmmDob"/>
</form>
<script type="text/javascript">
	var naver_id_login = new naver_id_login("YOUR_CLIENT_ID", "YOUR_CALLBACK_URL");
	// 접근 토큰 값 출력
	/* alert(naver_id_login.oauthParams.access_token); */
	// 네이버 사용자 프로필 조회
	naver_id_login.get_naver_userprofile("naverSignInCallback()");
	// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
	function naverSignInCallback() {
/* 	  
		alert(naver_id_login.getProfileData('email'));
		alert(naver_id_login.getProfileData('nickname'));
		alert(naver_id_login.getProfileData('age'));
 */
		$("input[name=ifmmId]").val(naver_id_login.getProfileData('id'));
		$("input[name=ifmmName]").val(naver_id_login.getProfileData('name'));
		$("input[name=ifmpNumber]").val(naver_id_login.getProfileData('mobile'));
		$("input[name=ifmeEmailFull]").val(naver_id_login.getProfileData('email'));
		
		
		$("input[name=ifmmGenderCd]").val(naver_id_login.getProfileData('gender'));
		
		$("input[name=ifmmDob]").val(naver_id_login.getProfileData('birthday'));// 05-05
		
		$("input[name=age]").val(naver_id_login.getProfileData('age'));
		$("input[name=birthyear]").val(naver_id_login.getProfileData('birthyear')); 2002
 
	}

	$("form[name=form]").attr("action", "/member/loginNaverProc").submit();
//	window.location.href = "/member/loginNaverProc";
  
</script>
</body>
</html>