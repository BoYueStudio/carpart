<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修配连汽配市场</title>
<link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
<!--弹出页-->
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/layer/layer.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function mygs() {
		var url = "${ctx}/login/forgetPassword";
		$.layer({
			type : 2,
			title : false,//关闭按钮
			shadeClose : false,
			shade : [ 0.6, '#000' ],//遮罩
			border : [ 0, 0, '#ccc' ],//边框
			area : [ '650px', '450px' ],//宽高
			iframe : {
				src : '' + url + ''
			},
			shift : [ "top" ], //从下面动画弹出
			end : function() {
				window.location.reload();
			}
		});
	}

	function refreshCode() {
		document.getElementById('imageValidate').src = '${ctx}/login/Kaptcha.jpg?'
				+ Math.random();
	}

	// 如果在框架中，则跳转刷新上级页面
	if (self.frameElement && self.frameElement.tagName == "IFRAME") {
		parent.location.reload();
	}

	function login() {
	    //取到登录账号
		var loginName = $("#loginName").val();
		//取到密码
		var password = $("#password").val();
		//取到验证码
		var validateCode = $("#validateCode").val();
		if (loginName == '' || password == '' || validateCode == "") {
			alert("用户名、密码、验证码不能为空");

		} else {
			$.ajax({
				type : "post",
				url : "${ctx}/login/login",
				data : {
					'loginName' : loginName,
					'password' : password,
					'validate' : validateCode
				},
				success : function(data) {
					if(data=='1'){
						$("#tips").html("验证码错误");
					}else if(data=='2'){
						$("#tips").html("账号或密码错误");
					}else if(data=='3'){
						//登录成功之后，到达首页 index
						window.location.href="${ctx}/index/toIndex";
					}
					
				}
                  
			});

		}

	}
</script>
</head>

<body>
	<div class="wid top1">
		<img src="${ctx}/images/logo1.jpg" />
	</div>
	<div class="land">
		<div class="wid land_1">
			<div class="title">
				<ul>
					<li class="ziti1"><a href="javascript:;">xiupeilian.com</a></li>
					<li class="ziti2">修配连汽配市场</li>
					<li class="ziti3">我的<span>网上汽配店铺</span></li>
				</ul>
			</div>
			<div class="login">
				<form>
					<div class="login_name">
						<input
							style="width:268px;height:38px;font-size:14px;font-family:'微软雅黑';color:#494848;padding-left:13px;border:1px solid #cdcdcd;"
							type="text" placeholder="用户名/邮箱/手机号" id="loginName" />
					</div>
					<div class="login_password">
						<input type="password"
							style="width:268px;height:38px;font-size:14px;font-family:'微软雅黑';color:#494848;padding-left:13px;border:1px solid #cdcdcd;"
							placeholder="登陆密码" id="password" />
					</div>
					<div class="login_password">
						<input type="text"
							style="width:100px;height:38px;font-size:14px;font-family:'微软雅黑';color:#494848;padding-left:13px;border:1px solid #cdcdcd;"
							name="validateCode" id="validateCode" class="delValue"
							placeholder="验证码" /> <label for="validateCode"
							class="checkCodePlaceholder" id="checkCodePlaceholder">看不清</label>
						<img
							style="height:24px;width:60px;display:inline-block; vertical-align:middle;cursor:pointer;"
							src="${ctx}/login/Kaptcha.jpg" border="0" title="看不清,请点击图片换一张"
							id="imageValidate" onclick="refreshCode()"> <span><a
								onclick="mygs();" href="javascript:;" style="color:red;">忘记密码？</a></span>
					</div>

					<p id="tips"
						style="margin-left:100px;margin-top:60px;color:red;font-size:16px"></p>

					<button type="button" class="button" onclick="login()">登录</button>
				</form>
				<div class="position">
					还没有修配连账号吗？赶快<span><a href="${ctx}/login/toRegister">点击注册</a></span>加入我们吧！
				</div>

				<div class="position">
					手机短信验证<span><a href="${ctx}/login/toPhoneLogin">登录</a></span>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="footer wid">Copyright © 2019-2029 www.xiupeilian.com
		All Rights Reserved. 修配连 版权所有</div>
</body>
</html>

