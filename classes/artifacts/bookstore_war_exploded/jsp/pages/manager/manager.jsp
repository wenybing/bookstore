<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
	<%@include file="/jsp/base/base.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
		<img class="logo_img" alt="" src="${base}/static/img/logo.jpg" width="258px" height="80px">
			<span class="wel_word">后台管理系统</span>
		<%@ include file="/jsp/base/book-info.jsp"%>
	</div>
	
	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
	</div>
	
	<div id="bottom">
		<span>
			时光书城.Copyright &copy;2017
		</span>
	</div>
</body>
</html>