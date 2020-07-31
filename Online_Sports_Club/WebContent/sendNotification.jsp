<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h3>Send Notification</h3>
<c:forEach var="subObj" items="${EndingSubscriptions }">
NAME : ${subObj.getMember().getName()}<br/>
EMAIL : ${subObj.getMember().getEmail()}<br/>
SUBSCRIBED SPORT : ${subObj.getSport().getSportName()}<br/>
<c:url var="url" value="sendmail?emailId=${subObj.getMember().getEmail()}&sportname=${subObj.getSport().getSportName()}&name=${subObj.getMember().getName()}" />
		<a href="${url}">SEND MAIL </a>
<hr/>
</c:forEach>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />