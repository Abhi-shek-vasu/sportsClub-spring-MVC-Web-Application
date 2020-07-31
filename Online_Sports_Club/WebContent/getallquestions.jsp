<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h3>Select Question To Post An answer</h3>
<table>

<c:forEach var="enqObj" items="${EnqList}">
<tr><td>${enqObj.getQuestion()}</td><td>By ${enqObj.getName()} </td> <td><c:url var="url" value="answerthis?enqId=${enqObj.getEnq_id()}" />
		<a href="${url}">Answer This</a></td></tr>
</c:forEach>
</table>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />