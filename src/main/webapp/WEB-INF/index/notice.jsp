<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>修配连汽配市场</title>
<link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/layer/layer.min.js" type="text/javascript"></script>
<script type="text/javascript">
function detail(url){
	$.layer({
		type : 2,
		title : false,//关闭按钮
		shadeClose : false,
		shade : [ 0.6, '#000' ],//遮罩
		border : [ 0, 0, '#ccc' ],//边框
		area : [ '650px', '450px' ],//宽高
		iframe : {
			src : '${ctx}' + url + ''
		},
		shift : [ "top" ], //从下面动画弹出
		end : function() {
			window.location.reload();
		}
	});
	
	
}



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
				<li onclick="goToDynamicmessageList()" style="cursor:pointer">动态消息</li>
				<li class="current" onclick="goToPublicmessageList()"
					style="cursor:pointer">公告</li>
				<li onclick="goToNewsList()" style="cursor:pointer">新闻</li>
			</ul>
			<div class="clear"></div>
			<div class="tab_box ">
				<!--滚动信息开始-->
				<div class="pagebody3_news" id="xiaoxi" style="height:500px;">

					<ul>
						<c:forEach var="publicmessage" items="${page.list}"
							varStatus="status">
							<li onclick="detail('${publicmessage.url}')"><a href="javascript:;">${publicmessage.title}</a><span><fmt:formatDate
										value="${publicmessage.createTime}"
										pattern="yyyy-MM-dd HH:mm:ss" /></span></li>
						</c:forEach>
					</ul>




                 <!-- 
                    page当中的pages代表一共分为几页
                                                 循环遍历pages，生成页数,
                                           如果在循环过程当中，页数等于当前页数 ，a标签加个背景色即可                         
                  -->
					<ul class="page">
					    <c:forEach begin="1" end="${page.pages}" var="pageNo">
					    <c:choose>
					    <c:when test="${pageNo==page.pageNum}">
					    <a href="${ctx}/index/notice?pageNum=${pageNo}" style="background: #C30D23 none repeat scroll 0% 0%;color:#ffffff;">${pageNo}</a>
					     </c:when>
					   <c:otherwise>
					   <a href="${ctx}/index/notice?pageNum=${pageNo}" >${pageNo}</a>
					   </c:otherwise>
					   </c:choose>
						
						</c:forEach>			
					</ul>
					<div class="clear"></div>
				</div>

			</div>
			<!--滚动信息结束-->
		</div>
		<!--中间内容-->
	</div>
	<!--main颜色-->
	<div class="footer wid">Copyright © 2019-2029 www.xiupeilian.com
		All Rights Reserved. 修配连 版权所有</div>
	<!--end底部-->
</body>
</html>
