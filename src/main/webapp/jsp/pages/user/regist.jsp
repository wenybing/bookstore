<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@include file="/jsp/base/base.jsp"%>
<style type="text/css">
	.login_form{
		height:430px;
		margin-top: 25px;
	}
	
</style>
	<script type="text/javascript">
		$(function(){

			$("#sub_btn").click(function(){
				//获取注册信息
				var username = $("input[name='username']").val();
				var password = $("input[name='password']").val();
				var repwd = $("input[name='repwd']").val();
				var email = $("input[name='email']").val();
				var code = $("input[name='code']").val();
				//验证用户注册的信息是否合法
				var usernameReg = /^[a-z0-9_-]{3,16}$/;
				var passwordReg = /^[a-z0-9_-]{6,18}$/;
				var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				if(!usernameReg.test(username)){
					alert("请输入3-16位包含小写字母、数字、_、-的用户名！");
					return false;
				}

				if(!passwordReg.test(password)){
					alert("请输入6-18位包含小写字母、数字、_、-的密码！");
					return false;
				}

				if(password != repwd){
					alert("两次输入的密码不一致！");
					return false;
				}

				if(!emailReg.test(email)){
					alert("输入的邮箱地址不合法！");
					return false;
				}

				if(code == null){
					alert("请输入验证码！");
					return false;
				}

			});

			$("#imgAuthCode").click(function(){
				this.setAttribute("src","${base}/kaptcha.jpg?time="+new Date().getTime());
			});
		});

	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="${base}/static/img/logo.jpg" width="200px" height="92px">
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册时光书城</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册书城会员</h1>
								<span class="errorMsg">${msg}</span>
							</div>
							<div class="form">
								<form action="${base}/regist" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" value="${param.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password"/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" value="${param.email}"/>
									<br />
									<br />
									<label>验　证　码</label>
									<input class="itxt"style=" width: 175px;" type="text" placeholder="请输入验证码" autocomplete="off" tabindex="1" name="code" />
									<img title="换一换" id="imgAuthCode" src="${base}/kaptcha.jpg" style="float:right; margin-bottom: -3px;width:90px;height:40px">
									<br/>
									<br/>
									<input type="submit" value="注册" id="sub_btn" />
									
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