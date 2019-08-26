<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>修配连汽配市场</title>
<link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
</head>
  
  <body>
  <div class="top2">
  <div class="wid">
        	<ul>
            	<li class="usename">${user.loginName}&nbsp;&nbsp;&nbsp;&nbsp;${user.username}</li>
            	
                <li class="shezhi"  onclick="javascript:window.top.document.getElementById('body').src ='${ctx}/index/toChangePassword.shtml'"><a href="javascript:">个人设置</a></li>
                
                <li>${now}</li>
                <li></li>
                <li class="tuichu" onclick = "javascript:if(confirm('您确定要退出吗？')){window.parent.location.href='${ctx}/login/logout.shtml'}" ><a href="javascript:;;">退出</a></li>
            </ul>
            <div class="clear"></div>
        </div>
        </div>
  </body>
</html>
