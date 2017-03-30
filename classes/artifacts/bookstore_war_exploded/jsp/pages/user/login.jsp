<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城会员登录页面</title>
	<%@ include file="/jsp/base/base.jsp"%>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="${base}/static/img/logo.jpg" width="200px" height="92px">
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录时光书城</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>书城会员</h1>
								<a href="${base}/jsp/pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">${empty msg?"请输入用户名和密码！":msg}</span>
							</div>
							<div class="form">
								<form action="${base}/login" method="get">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" value="${param.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				时光书城.Copyright &copy;2017
			</span>
		</div>
</body>
</html>