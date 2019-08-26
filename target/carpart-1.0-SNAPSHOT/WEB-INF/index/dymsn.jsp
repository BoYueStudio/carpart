<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>修配连汽配市场</title>
<link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />

<style>
.pagebody3_news ul li {
	background: null;
}
</style>
<script type="text/javascript">




	function goToDynamicmessageList() {

		window.location.href = "${ctx}/index/dymsn";
	}

	function goToPublicmessageList() {

		window.location.href = "${ctx}/index/notice";
	}

	function goToNewsList() {

		window.location.href = "${ctx}/index/news";
	}
</script>




</head>

<body>
	<div class="bg_color1 border_end">
		<!--main颜色-->
		<div class="demo11 pagebody3 wid">
			<!--中间内容-->
			<ul class="tab_menu pagebody3_all">
				<li class="current" onclick="goToDynamicmessageList()"
					style="cursor:pointer">动态消息</li>
				<li onclick="goToPublicmessageList()" style="cursor:pointer">公告</li>
				<li onclick="goToNewsList()" style="cursor:pointer">新闻</li>
			</ul>
			<div class="clear"></div>
			<div class="tab_box ">
				<!--滚动信息开始-->

				<div class="pagebody3_news" id="demo"
					style="overflow:hidden;height:500px;">
					<ul id="demo1">
						<c:forEach var="dynamicmessage" items="${list}" varStatus="status">
							<li style="background:none;" >${dynamicmessage.message}<span>
							<fmt:formatDate value="${dynamicmessage.createTime}"
										pattern="yyyy-MM-dd HH:mm:ss" /></span></li>
						</c:forEach>
					</ul>
					<ul id="demo2"></ul>
				</div>



			</div>
		</div>
		<!--滚动信息结束-->
	</div>
	<!--中间内容-->
	</div>
	<!--main颜色-->
	<div class="footer wid">Copyright © 2014-2024 www.xiupeilian.com
		All Rights Reserved. 修配连 版权所有</div>
	<!--end底部-->
</body>
</html>

