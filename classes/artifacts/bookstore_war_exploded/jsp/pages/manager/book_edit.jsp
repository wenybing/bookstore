<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
	<%@include file="/jsp/base/base.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
	<script type="text/javascript">
		$(function(){
			$("input:[type='submit']").click(function(){
				debugger;
				//获取图书id
				var bookId = $("input:[type='hidden']").val();
				var action = "";
				if(bookId == null || bookId == ""){
					action ="${base}/book/saveBook";
					$("#Update").attr("action",action).submit();
				}else{

					action = "${base}/book/bookEdit?book="+bookId;
					$("#Update").attr("action",action).submit();
				}
				return false;
			});
		});
	</script>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="${base}/static/img/logo.jpg" width="258px" height="80px">
			<span class="wel_word">编辑图书</span>
			<%@ include file="/jsp/base/book-info.jsp"%>
		</div>
		<div id="main">
			<form id="Update" action="" method="post">
				<c:if test="${!empty book.id}">
				<input type="hidden" name="bookId" value="${book.id}">
				<input type="hidden" name="_method" value="PUT">
				</c:if>
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="title" type="text" value="${book.title}"/></td>
						<td><input name="price" type="text" value="${book.price}"/></td>
						<td><input name="author" type="text" value="${book.author}"/></td>
						<td><input name="sales" type="text" value="${book.sales}"/></td>
						<td><input name="stock" type="text" value="${book.stock}"/></td>
						<td><input name="book_amount" type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		
		<div id="bottom">
			<span>
				时光书城.Copyright &copy;2017
			</span>
		</div>
</body>
</html>