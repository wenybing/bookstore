<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>
<link type="text/css" rel="stylesheet" href="${base}/static/css/style.css" >
<script type="text/javascript" src="${base}/static/jquery-1.7.2.js"></script>
<script type="text/javascript">
    var contextPath = '<%=request.getContextPath() %>';
</script>