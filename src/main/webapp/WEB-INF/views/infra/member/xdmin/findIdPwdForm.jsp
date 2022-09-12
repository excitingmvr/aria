<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!-- head s -->
<%@include file="../include/head.jsp"%>
<!-- head e -->

<style type="text/css">
	
	.my-wrap {
		width: 380px;		
	}
	
</style>
	
</head>
<body>

<!-- contents s -->
<div class="container my-wrap">
	<div class="row row-cols-1 gy-3">
		<div class="col text-center">
			<img alt="" src="/resources/xdmin/image/logo_login_300_200.png">
		</div>
		<div class="col">
			<h4>Find ID/Password</h4>
		</div>
		<div class="col">
			<input type="text" class="form-control" id="" placeholder="Name">
		</div>
		<div class="col">
			<input type="text" class="form-control" id="" placeholder="Email">
		</div>
		<div class="col" id="">
			<div class="alert alert-primary" role="alert">
 				ID : asdf***SDFG	
			</div>
		</div>
		<div class="d-grid gap-2 mt-3">
			<button class="btn btn-secondary" type="button">Find ID</button>
			<button class="btn btn-primary opacity-50" type="button">Reset Password</button>
			<button class="btn btn-danger opacity-50" type="button">Reset</button>
		</div>
	</div>
</div>
<!-- contents e -->

<!-- modalBase s -->
<%@include file="../include/modalBase.jsp"%>
<!-- modalBase e -->

<!-- linkJs s -->
<%@include file="../include/linkJs.jsp"%>
<!-- linkJs e -->

<script type="text/javascript">
	
</script>

</body>
</html>