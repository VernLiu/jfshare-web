<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/env.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>聚分享网上商城（www.jfshare.com），新购物，新生活！</title>
    <meta name="keywords" content="聚分享，聚分享商城，网上购物，积分购物，积分兑换，电子券兑换，手机，数码，电器，男包，女包，进口食品，化妆，家居百货，客户回馈"/>
    <meta name="description" content="聚分享网上商城是一个新型的电子商务综合平台，可支持积分兑换、积分+现金支付、电子券/二维码支付、话费账单支付、财付通、支付宝、银联在线等多种灵活的混合支付方式。聚分享商城以完备的B2C商城系统以及灵活的混合支付体系，已与国内诸多大型企业达成战略合作，业务领域覆盖通信行业、金融行业、航空业、旅游酒店以及大型商超等。在电子商务B2C领域，聚分享商城在为广大消费者提供质优价廉的品牌商品之余，还一直潜心致力于为广大消费者提供一个线上线下（O2O）立体整合的综合购物平台，支持电话、短信、微信、二维码、网上商城等多种快捷购物方式，为您带来全新的购物体验"/>
    <link type="text/css" rel="stylesheet" href="<%=cssPath%>/core.css<%=cssVersion%>">
    <script type="text/javascript" src="<%=jsPath%>/common/jquery/1.11.3/jquery-1.11.3.min.js<%=jsVersion%>"></script>
    <script type="text/javascript" src="<%=jsPath%>/backend/logistics/overseas/add.js<%=jsVersion%>"></script>
</head>
<body>
	<form id="editForm" action="${delivery.id }" method="post">
	<div><input type="submit" value="保存"/><input type="button" value="批量导入"/></div>
	<input name="id" type="hidden" value="${delivery.id }"/>
	<input name="detail" type="hidden" value="${delivery.detail }"/>
	<div>${delivery.id }. 订单号(必填):<input name="orderId" type="text" value="${delivery.orderId }"/></div>
	<div><input id="add" type="button" value="新增"/><input id="edit" type="button" value="编辑"/><input id="del" type="button" value="删除"/></div>
	<div style="border:1px solid black;height:100px;">
		<table id="detail">
			<tbody>
			</tbody>
		</table>
	</div>
	<div>
		<p>物流信息录入备注(最多可以输入100字)</p>
		<textarea name="remark" rows="6" cols="100">${delivery.remark}</textarea>
	</div>
	</form>
	<form id="statusForm">
	<div>
		<table>
			<tr>
				<td colspan="2">新增物流跟踪状态:</td>
			</tr>
			<tr>
				<td>选择时间(必填):</td>
				<td>
					<input name="time" type="text"/>
				</td>
			</tr>
			<tr>
				<td>物流状态(必填):</td>
				<td>
					<textarea name="status" rows="3" cols="50"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input id="statusCancel" value="取消" type="button"/> <input id="statusConfirm" value="确定" type="button"/></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>