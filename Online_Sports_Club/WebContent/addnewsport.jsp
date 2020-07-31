<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h3>Add New Sport</h3>

<sf:form modelAttribute="SPORT" action="addsport">
<table>
<tr><td>SPORT NAME</td><td><sf:input path="sportName" /> </td></tr>
<tr><td>SPORT TYPE</td><td><sf:input path="sportType" /> </td></tr>
<tr><td>SPORT DESCRIPTION</td><td><sf:input path="sportDesc" /> </td></tr>
<tr><td>CAPACITY FOR THAT SPORT</td><td><sf:input path="capacity" /> </td></tr>
<tr><td>SPORT IMAGE</td><td><sf:input path="sportImage" /> </td></tr>
<tr><td></td><td><input type="submit" value="submit"/></td></tr>
</table>
</sf:form>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />