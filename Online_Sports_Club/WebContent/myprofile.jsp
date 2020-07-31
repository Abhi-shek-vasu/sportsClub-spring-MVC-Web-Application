<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<center><h3>My Profile</h3>
<div style="display:inline-block; height: 300px; width:300px;float:left;">
<h4>About    ${sessionScope.username} </h4>
<div style="display: inline-block; height: 200px; width:200px">
<table>
<tr><th>Name </th><td>${UserInfo.getName()}</td><td><a href="changeName"></a></td></tr>
<tr><th>Email </th><td>${UserInfo.getEmail()}</td><td><a href="changeName">Change Email</a></td></tr>
<tr><th>Gender </th><td>${UserInfo.getGender()}</td><td><a href="changeName"></a></td></tr>
<tr><th>Age </th><td>${UserInfo. getAge()}</td><td><a href="changeName"></a></td></tr>
<tr><th>Address </th><td>${UserInfo.getAddress()}</td><td><a href="changeName">Change Address</a></td></tr>
</table>
</div><h4><a href="changepropic">change profile</a></h4>
<img src="images/users/${UserInfo.getUserImage()}" style="height: 100px;width:100px;padding: 30px" />
</div>



<div style="display:inline-block">
<h4 align="center">My Subscriptions</h4>
<table border="1" align="center" style="border:1;border-collapse:collapse;background-color:lightblue;">
<tr><th>Sport Name</th><th>Start Date</th><th>End Date</th> <th>Paid Amount</th></tr>
<c:forEach var="subObj" items="${UserInfo.getSubscriptionList()}">
<tr><td>${subObj.getSport().getSportName()}</td><td>${subObj.getStartDate()}</td><td>${subObj.getEndDate()}</td><td>${subObj.getPaidAmount()}</td></tr>
</c:forEach>
<tr></tr>
</table>
</div>
</center>