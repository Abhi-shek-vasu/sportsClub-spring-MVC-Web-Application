<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 <div style="height: 300px; width: 300px;display: table-cell; ">
<h2>Indoor Sports</h2>
<c:forEach var="indoorsportObj" items="${IndoorSportList}">
	<li>
		<c:url var="url" value="selectsport?sportId=${indoorsportObj.getId()}" />
		<a href="${url}">${indoorsportObj.getSportName()} </a>
	</li>
</c:forEach>
</div>


<div style="height: 300px; width: 300px;display: table-cell; ">
<h3>Outdoor Sports</h3>
<c:forEach var="outdoorsportObj" items="${OutdoorSportList}">
	<li>
		<c:url var="url" value="selectsport?sportId=${outdoorsportObj.getId()}" />
		<a href="${url}">${outdoorsportObj.getSportName()} </a>
	</li>
</c:forEach>
</div>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />