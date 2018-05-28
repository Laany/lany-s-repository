<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/layout.css" rel="stylesheet" type="text/css">
<link href="css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/js.js"></script>
<style>
	.ibar {display: none;}
</style>

</head>
<body class="login-bg">
		<div class="main ">
			<!--登录-->
			<div class="login-dom login-max">
				<div class="logo text-center">
					<a href="#">
					<img src="images/logo.png" width="180px" height="180px">
					</a>
				</div>
				<div class="login container " id="login">
					<p class="text-big text-center logo-color">
						资料共享系统
					</p>
					<p class=" text-center margin-small-top logo-color text-small">
						共享我们的资料
					</p>
					<form class="login-form" action="/shareinformation/login.action" method="post" autocomplete="off" onsubmit="msg();">
						<div class="login-box border text-small" id="box">
							<div class="name border-bottom">
								<input type="text" placeholder="账号" id="username" name="userid" datatype="*" nullmsg="请填写帐号信息">
							</div>
							<div class="pwd border-bottom">
								<input type="password" placeholder="密码" datatype="*" id="password" name="userpassword" nullmsg="请填写帐号密码">
							</div>
							<div class="code1">
								<input type="text" placeholder="验证码" datatype="*" id="code" name="code" nullmsg="填入验证码"><img alt="" src="/shareinformation/comeimage.action">
							</div>
						</div>
						<input type="hidden" name="formhash" value="5abb5d21"/>
						<input type="submit" class="btn text-center login-btn" value="立即登录">
					</form>
					<div class="forget">
						<a href="repassword.html" class="forget-pwd text-small fl">忘记登录密码？</a><a href="/shareinformation/registeraction.action" class="forget-new text-small fr" id="forget-new">创建一个新账号</a>
					</div>
				</div>
			</div>
			<div class="popupDom">
				<div class="popup text-default">
				</div>
			</div>
		</div>
</body>

<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
	function popup_msg(msg) {
		$(".popup").html("" + msg + "");
		$(".popupDom").animate({
			"top": "0px"
		}, 400);
		setTimeout(function() {
			$(".popupDom").animate({
				"top": "-40px"
			}, 400);
		}, 2000);
	}
</script>
<script type="text/javascript">
	function msg(){
		var msg = "${attr.result}";
		if(msg!=""){
			alter(msg);
		}
	}
</script>
</html>