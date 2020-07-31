<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h2>Add New Coaches</h2>
<sf:form modelAttribute="COACHMODEL" action="addcoachtosport">
<table>
<sf:hidden path="sport_id" value="${Sport.getId()}"/>
<tr><td>Name :</td><td><sf:input path="name" /></td></tr>
<tr><td>Age :</td><td><sf:input path="age" /></td></tr>
<tr><td>Experiance In years :</td><td><sf:input path="experiance" /></td></tr>
<tr><td>Qualification :</td><td><sf:input path="qualification" /></td></tr>
<tr><td></td><td><input type="submit" value="submit"/></td></tr>

</table>
</sf:form>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />