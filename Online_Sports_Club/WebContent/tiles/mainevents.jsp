<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="sf"  uri="http://www.springframework.org/tags/form" %>
   
<ul>
<c:forEach var="eventObj" items="${MainEvents}">
 <li> <c:url var="url" value="geteventdetails?eventId=${eventObj.getId()}" />
		<a href="${url}">${ eventObj.getTitle()} </a><br/>
  ${ eventObj.getDate()}<br/>
  ${ eventObj.getSportName()}</li>
 </c:forEach>
 </ul>