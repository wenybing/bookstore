<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@include file="/jsp/base/base.jsp"%>
	<script type="text/javascript" src="${base}/static/js/common.js"></script>
	<%--<script type="text/javascript">--%>
		<%--$(function(){--%>
			<%--$(".delBook").click(function(){--%>
				<%--//获取书名--%>
				<%--var bookName = $(this).parents("tr").find("td:eq(0)").html();--%>
				<%--if(confirm("确定要 《"+bookName+"》 删除吗？")){--%>
					<%--var href = $(this).attr("href");--%>
					<%--$("#delForm").attr("action",href).submit();--%>
				<%--}--%>
				<%--return false;--%>
			<%--});--%>

			<%--$("input[type='button']").click(function(){--%>
				<%--var pageNumber = $("#pn_input").val();--%>
				<%--window.location = "${base}/book/findBook?pageNumber="+pageNumber;--%>
			<%--});--%>
		<%--})--%>
	<%--</script>--%>
</head>
<body>
	<form id="delForm" action="" method="post">
		<input type="hidden" name="_method" value="DELETE">
	</form>
	<div id="header">
			<img class="logo_img" alt="" src="${base}/static/img/logo.jpg" width="258px" height="80px">
			<span class="wel_word">图书管理系统</span>
		<%@ include file="/jsp/base/book-info.jsp"%> 
	</div>
	
	<div id="main">
		<c:choose>
			<c:when test="${empty page.data}">
				<br/><br/><br/><br/><br/><br/><br/><br/>
				<h1 align="center">库中没有图书！</h1>
				<h1 align="center">
					<a href="${base}/jsp/pages/manager/book_edit.jsp">添加图书</a></td>
				</h1>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>
					<c:forEach items="${ page.data}" var="book">
						<tr>
							<td>${book.title}</td>
							<td>${book.price}</td>
							<td>${book.author}</td>
							<td>${book.sales}</td>
							<td>${book.stock}</td>
							<td><a href="${base}/book/queryBook?bookId=${book.id}">修改</a></td>
							<td><a class="delBook" href="${base}/book/delBook?bookId=${book.id}">删除</a></td>
						</tr>

					</c:forEach>

					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href="${base}/jsp/pages/manager/book_edit.jsp">添加图书</a></td>
					</tr>
				</table>

				<div id="page_nav">
					<c:choose>
						<c:when test="${page.totalPage < 5}">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="${page.totalPage}"></c:set>
						</c:when>
						<c:when test="${page.pageNumber < 3}">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="5"></c:set>
						</c:when>
						<c:otherwise>
							<c:set var="begin" value="${page.pageNumber-2}"></c:set>
							<c:set var="end" value="${page.pageNumber+2}"></c:set>
							<c:if test="${end > page.totalPage}">
								<c:set var="end" value="${page.totalPage}"></c:set>
								<c:set var="begin" value="${end-4}"></c:set>
							</c:if>
						</c:otherwise>
					</c:choose>
					<a href="${base}/book/findBook?pageNumber=1">首页</a>
					<a href="${base}/book/findBook?pageNumber=${page.pageNumber-1}">上一页</a>
					<c:forEach begin="${begin}" end="${end}" var="index">
						<c:choose>
							<c:when test="${page.pageNumber == index}">
								<span style="color: red;">[${index}]</span>
							</c:when>
							<c:otherwise>
								<a href="${base}/book/findBook?pageNumber=${index}">${index}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<a href="${base}/book/findBook?pageNumber=${page.pageNumber+1}">下一页</a>
					<a href="${base}/book/findBook?pageNumber=${page.totalPage}">末页</a>
					共${page.totalPage}页，${page.totalRecord}条记录 到第<input value="${page.pageNumber}" name="pn" id="pn_input"/>页
					<input type="button" value="确定" onclick="searchPage('findBook')">
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div id="bottom">
		<span>
			时光书城.Copyright &copy;2017
		</span>
	</div>
</body>
</html>