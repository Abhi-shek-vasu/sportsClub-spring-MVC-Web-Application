<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<h3>${Events.getTitle()}</h3>
<table border="1" style="border: 1;border-collapse: collapse;">
<tr><th>Name</th><th>Email</th><th>Mobile</th><th>Payment</th></tr>
<c:forEach var="eveObj" items="${Events.getAttenderList()}">
<tr><td>${eveObj.getName()}</td><td>${eveObj.getEmail()}</td><td>${eveObj.getMobile()}</td><td>${eveObj.getWillpay()}</td></tr>
</c:forEach>
<tr><th>Total Attenders -> </th><th>${Events.getAttenderList().size()}</th><th>Total Collection -></th><th>${TotalCollection}</th></tr>
</table>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />