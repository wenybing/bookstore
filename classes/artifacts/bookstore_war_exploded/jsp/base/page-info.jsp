<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

</div>
