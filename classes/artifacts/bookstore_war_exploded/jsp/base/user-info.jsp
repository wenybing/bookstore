<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <%--未登录--%>
    <c:when test="${empty login}">
        <div>
        <a href="${base}/jsp/pages/user/login.jsp">登录</a> |
        <a href="${base}/jsp/pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        <a href="${base}/jsp/pages/cart/cart.jsp">购物车</a>
        <a href="${base}/book/findClientBook">返回商城</a>
        </div>
    </c:when>
    <c:otherwise>
        <%--已登录--%>
        <div>
            <span>欢迎<span class="um_span">${login.username}</span>光临时光书城</span>
            <a href="${base}/jsp/pages/order/order.jsp">我的订单</a>
            <a href="${base}/jsp/pages/cart/cart.jsp">购物车</a>
            <a href="${base}/jsp/pages/manager/manager.jsp">后台管理</a>
            <a href="${base}/loginOut">注销</a>&nbsp;&nbsp;
            <a href="${base}/book/findClientBook">返回</a>
        </div>
    </c:otherwise>
</c:choose>


