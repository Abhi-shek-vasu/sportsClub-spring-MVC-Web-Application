<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div>
<c:url var="url" value="Registertoevent?eventId=${EventDetails.getId()}" />
		<a href="${url}"> Register </a>
${EventDetails.getDate()}<br/>
${EventDetails.getTitle()}<br/>
${EventDetails.getEventDesc()}<br/>

<img src="images/events/${EventDetails.getImage()}"/>
</div>
