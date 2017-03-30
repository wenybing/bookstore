<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/jsp/base/base.jsp"%>
</head>
<body>
	
	<div id="header">
		<img class="logo_img" alt="" src="${base}/static/img/logo.jpg" width="258px" height="80px">
			<span class="wel_word">购物车</span>
			<%--<div>--%>
				<%--<span>欢迎<span class="um_span">孙悟空</span>光临尚硅谷书城</span>--%>
				<%--<a href="${base}/jsp/pages/order/order.jsp">我的订单</a>--%>
				<%--<a href="${base}/jsp/index.jsp">注销</a>&nbsp;&nbsp;--%>
				<%--<a href="${base}/jsp/index.jsp">返回</a>--%>
			<%--</div>--%>
		<%@include file="/jsp/base/user-info.jsp"%>
	</div>
	
	<div id="main">
		<c:choose>
			<c:when test="${empty cart.allCartItem}">
				<br/> <br/> <br/> <br/> <br/>
				<h4 align="center">购物车中没有商品</h4></c:when>
			<c:otherwise>
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>

				<c:forEach items="${cart.allCartItem}" var="cartItem">

				<tr>
				<td>${cartItem.book.title}</td>
				<td>${cartItem.amount}</td>
				<td>${cartItem.book.price}</td>
				<td>${cartItem.count}</td>
				<td><a href="${base}/cart/delCartItem?bookId=${cartItem.book.id}">删除</a></td>
			</tr>
				</c:forEach>

			
		</table>

			</c:otherwise>
		</c:choose>
		<c:if test="${!empty cart.allCartItem}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${cart.totalAmount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${cart.totalCount}</span>元</span>
				<span class="cart_span"><a href="${base}/cart/clearCart">清空购物车</a></span>
				<span class="cart_span"><a href="${base}/jsp/pages/cart/checkout.jsp">去结账</a></span>
			</div>
		</c:if>

	
	</div>
	
	<div id="bottom">
		<span>
			时光书城.Copyright &copy;2017
		</span>
	</div>
</body>
</html>