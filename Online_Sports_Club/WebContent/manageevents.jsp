<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<h2>Manage Events </h2>
<table border="1">
<tr>
<th>Event Number</th><th>Sport Name</th><th>Event Date</th><th>Event Title</th><th>Is On Main Page</th><th>Event Description </th><th>DELETE </th><th>EDIT </th><th>Show On Main page</th><th>Hide On Main page</th>
<th>See Event Attenders</th></tr>
<c:forEach var="eventObj" items="${AllEventList}"> 
<tr>
<td>${eventObj.getId()}</td><td>${ eventObj.getSportName()}</td><td>${eventObj.getDate()}</td><td>${eventObj.getTitle()}</td><td>${eventObj.getIsOnMainPage()}</td><td>${eventObj.getEventDesc()}</td>
<td><c:url var="url" value="deleteEvent?eventId=${eventObj.getId()}" />
		<a href="${url}">Delete </a>
</td>
<td><c:url var="url" value="editEvent?eventId=${eventObj.getId()}" />
		<a href="${url}">Edit</a>
</td>
<td><c:url var="url" value="showEventOnMainPage?eventId=${eventObj.getId()}" />
		<a href="${url}">Show On Main Page</a>
</td>
<td><c:url var="url" value="hideOnMainPage?eventId=${eventObj.getId()}" />
		<a href="${url}">Hide On Main Page</a>
</td>
<td><c:url var="url" value="getEventAttenders?eventId=${eventObj.getId()}" />
		<a href="${url}">See Event Attenders</a>
</td>
</tr>
</c:forEach>
</table>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />
