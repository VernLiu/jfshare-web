<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/env.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>聚分享网上商城（www.jfshare.com），新购物，新生活！</title>
    <meta name="keywords" content="聚分享，聚分享商城，网上购物，积分购物，积分兑换，电子券兑换，手机，数码，电器，男包，女包，进口食品，化妆，家居百货，客户回馈"/>
    <meta name="description" content="聚分享网上商城是一个新型的电子商务综合平台，可支持积分兑换、积分+现金支付、电子券/二维码支付、话费账单支付、财付通、支付宝、银联在线等多种灵活的混合支付方式。聚分享商城以完备的B2C商城系统以及灵活的混合支付体系，已与国内诸多大型企业达成战略合作，业务领域覆盖通信行业、金融行业、航空业、旅游酒店以及大型商超等。在电子商务B2C领域，聚分享商城在为广大消费者提供质优价廉的品牌商品之余，还一直潜心致力于为广大消费者提供一个线上线下（O2O）立体整合的综合购物平台，支持电话、短信、微信、二维码、网上商城等多种快捷购物方式，为您带来全新的购物体验"/>
    <link type="text/css" rel="stylesheet" href="<%=cssPath%>/core.css<%=cssVersion%>">
</head>
<body>
	<div>
		<input value="新增物流订单" type="button" onclick="location.href='add'"/>
		<div style="float:right;">
			<table>
				<tr>
					<td>查找:</td>
					<td><input name="searchKey" type="text" value="输入订单号"/></td>
					<td><input type="button" value="搜索"/></td>
				</tr>
			</table>
		</div>
	</div>
	<table width="910px" border="1px">
		<thead>
			<tr>
				<td width="50px">序号</td>
				<td width="100px">订单号</td>
				<td width="650px">物流状态跟踪</td>
				<td width="100px">详情</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach begin="1" end="20" varStatus="status">
			<c:set var="delivery" value="${deliverys[status.index-1]}"></c:set>
			<c:choose>
				<c:when test="${delivery != null}">
					<tr>
						<td>${status.index}</td>
						<td>${delivery.orderId }</td>
						<td>${delivery.detail }</td>
						<td><a href="add/${delivery.id }">编辑</a></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</c:otherwise>
			</c:choose>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>