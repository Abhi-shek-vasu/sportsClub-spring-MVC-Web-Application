<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="registration_form" style="background-color:#e5f0ff;">
<table align="center" style="background-color:#e5f0ff;"> 

<sf:form action="/Online_Sports_Club/admin/addLocation" modelAttribute="LOCMODEL" onsubmit="return validateMyForm()">
	<sf:hidden path="sportId"  value="${Sport.getId()}"/>
	<tr><td>Ground Number:</td><td> <sf:input path="groundNo" id="ground" />
	<tr><td>Location In Club : </td><td><sf:input path="locInClub" id="location"/></td></tr>
	<sf:hidden path="sportId"  value="${Location.getSportId()}"/>
	<tr><td></td><td><input type="submit" value="Update"></td></tr>
</sf:form>
</table>
</div>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />