<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<h2>Subscriptions</h2>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<div style="width: 300px;display: table-cell; ">
<h2>Indoor Sports</h2>
<c:forEach var="indoorsportObj" items="${IndoorSportList}">
	<li>
		<c:url var="url" value="getSlots?sportId=${indoorsportObj.getId()}" />
		<a href="${url}">${indoorsportObj.getSportName()} </a>
	</li>
</c:forEach>
</div>

<div style="width: 300px;display: table-cell; ">
<h3>Outdoor Sports</h3>
<c:forEach var="outdoorsportObj" items="${OutdoorSportList}">
	<li>
		<c:url var="url" value="getSlots?sportId=${outdoorsportObj.getId()}" />
		<a href="${url}">${outdoorsportObj.getSportName()} </a>
	</li>
</c:forEach>
</div>
<div style="width: 400px;display: table-cell; ">
<table border="1" style="border: 1;border-collapse: collapse; text-align: center;background-color: yellow;">
<tr><th>Sport Name</th><th>Start Date</th><th>End Date</th><th>Duration</th></tr>
<c:forEach var="subObj" items="${MySubscriptionList}">
<tr><td>${ subObj.getSport().getSportName()}</td><td>${ subObj.getStartDate()}</td><td>${ subObj.getEndDate()}</td><td>${ subObj.getSubType()}</td></tr>
</c:forEach>
</table>
</div>