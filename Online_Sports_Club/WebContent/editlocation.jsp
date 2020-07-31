<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<script type="text/javascript" language="javascript"> 
function validateMyForm() 
{ 
if (document.forms[0].ground.value == "")  
  { 
    	alert('Ground must not be blank'); 
   		return false; 
  } 
  else if (document.forms[0].location.value == "")  
  { 
	    alert('Location must not be blank'); 
	    return false; 
  }
document.forms[0].submit(); 
} 
</script>
<center><h2>Edit location</h2></center>
<div class="registration_form" style="background-color:#e5f0ff;">
<table align="center" style="background-color:#e5f0ff;"> 

<sf:form action="/Online_Sports_Club/admin/updateLocation" modelAttribute="LOCMODEL" onsubmit="return validateMyForm()">
	<sf:hidden path="locId"  value="${Location.getLocId()}"/>
	<tr><td>Ground Number:</td><td> <sf:input path="groundNo" id="ground" value="${Location.getGroundNo()}" />
	<tr><td>Location In Club : </td><td><sf:input path="locInClub" id="location" value="${ Location.getLocInClub()}"/></td></tr>
	<sf:hidden path="sportId"  value="${Location.getSportId()}"/>
	<tr><td></td><td><input type="submit" value="Update"></td></tr>
</sf:form>
</table>
</div>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />