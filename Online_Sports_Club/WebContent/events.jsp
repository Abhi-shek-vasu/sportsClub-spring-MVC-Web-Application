<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
   <%@ taglib prefix="sf"  uri="http://www.springframework.org/tags/form" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style type="text/css">
div.events
{
margin-left: 100px;
}
</style>

<div class="events">
<h3>Events are as below</h3>
<form action="showOnMainPage">
<ul>
<c:forEach var="eventObj" items="${EventList}">
 <li> ${ eventObj.getEventDesc()}</li>
 <li> ${ eventObj.getDate()}</li>
 <li> ${ eventObj.getSportName()}</li>
 <input type="checkbox" name="eventId" value="${eventObj.getId()}" />Show On Next Page
 <hr/>
 </c:forEach>
 </ul>
 <input type="submit" value="submit">
</form>
</div>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />
