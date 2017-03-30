<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:set var="base" value="${pageContext.request.contextPath}"/>--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<%--<base href="http://localhost:8080/BookStore/">--%>
<%--<link type="text/css" rel="stylesheet" href="static/css/style.css" >--%>
	<%@ include file="base/base.jsp"%>
	<script type="text/javascript" src="${base}/static/js/common.js"></script>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="${base}/static/img/logo.jpg" width="258px" height="80px">
			<span class="wel_word" >网上书城</span>
			<%--<div>--%>
				<%--<a href="${base}/jsp/pages/user/login.jsp">登录</a> |--%>
				<%--<a href="${base}/jsp/pages/user/regist.jsp">注册</a> &nbsp;&nbsp;--%>
				<%--<a href="${base}/jsp/pages/cart/cart.jsp">购物车</a>--%>
				<%--<a href="${base}/jsp/pages/manager/manager.jsp">后台管理</a>--%>
			<%--</div>--%>
		<%@include file="/jsp/base/user-info.jsp"%>
	</div>
	


	<div id="main">
		<div id="book">
			<div class="book_cond">
				价格：<input type="text" name="min"> 元 - <input type="text" name="max"> 元 <button>查询</button>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有3件商品</span>
				<div>
					您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
				</div>
			</div>

			<c:forEach items="${page.data}" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${base}/static/img/default.jpg" />
					</div>
					<div class="book_info">
						<input type="hidden" class="bookId" value="${book.id}">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.title}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">￥${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock}</span>
						</div>
						<%--<div class="book_add">--%>
							<%--<button class="btn">加入购物车</button>--%>
						<%--</div>--%>
						<div class="book_add">
							<a style="color:blue;" href="${base}/cart/addCartItem?bookId=${book.id}">加入购物车</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>

		<div id="page_nav">
			<%@include file="base/page-info.jsp"%>
			<a href="${base}/book/findClientBook?pageNumber=1">首页</a>
			<a href="${base}/book/findClientBook?pageNumber=${page.pageNumber-1}">上一页</a>
			<c:if test="${begin} != 0 && ${end} != 0">
			<c:forEach begin="${begin}" end="${end}" var="index">
				<c:choose>
					<c:when test="${page.pageNumber == index}">
						<span style="color: red;">[${index}]</span>
					</c:when>
					<c:otherwise>
						<a href="${base}/book/findClientBook?pageNumber=${index}">${index}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			</c:if>
			<a href="${base}/book/findClientBook?pageNumber=${page.pageNumber+1}">下一页</a>
			<a href="${base}/book/findClientBook?pageNumber=${page.totalPage}">末页</a>
			共${page.totalPage}页，${page.totalRecord}条记录 到第<input value="${page.pageNumber}" name="pn" id="pn_input"/>页
			<input type="button" value="确定" onclick="searchPage('findClientBook')">
		</div>
		<br/>
	</div>
	<div id="bottom">
		<span>
			时光书城.Copyright &copy;2017
		</span>
	</div>
</body>
</html>