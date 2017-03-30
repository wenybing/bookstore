<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@include file="/jsp/base/base.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="${base}/static/img/logo.jpg" width="200px" height="92px">
				<span class="wel_word"></span>
				<%--<div>--%>
					<%--<span>欢迎<span class="um_span">孙悟空</span>光临时光书城</span>--%>
					<%--<a href="${base}/jsp/pages/order/order.jsp">我的订单</a>--%>
					<%--<a href="${base}/jsp/index.jsp">注销</a>&nbsp;&nbsp;--%>
					<%--<a href="${base}/jsp/index.jsp">返回</a>--%>
				<%--</div>--%>
			<%@include file="/jsp/base/user-info.jsp"%>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="${base}/book/findClientBook">转到主页</a></h1>
	
		</div>
		
		<div id="bottom">
			<span>
				时光书城.Copyright &copy;2017
			</span>
		</div>
</body>
</html>