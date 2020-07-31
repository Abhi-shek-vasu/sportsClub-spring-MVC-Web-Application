<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" language="javascript"> 
function validateMyForm() 
{ 
if (document.forms[0].date.value == "")  
  { 
    	alert('date must not be blank'); 
   		return false; 
  } 
  else if (document.forms[0].title.value == "")  
  { 
	    alert('Age must not be blank'); 
	    return false; 
  }
 
  else if (document.forms[0].eventDesc.value == "")  
  { 
	    alert('Gender must not be blank'); 
	    return false; 
  } 
  else if (document.forms[0].image.value == "")  
  { 
	    alert('Image must not be blank'); 
	    return false; 
  }
  else if (document.forms[0].capacity.value == "")  
  { 
	    alert('password must not be blank'); 
	    return false; 
  }
  else if (document.forms[0].memcharge.value == "")  
  { 
	    alert('member charge must not be blank'); 
	    return false; 
 }
  else if (document.forms[0].nonmemcharge.value == "")  
 { 
	    alert('non member charge must not be blank'); 
	    return false; 
 } 
document.forms[0].submit(); 
} 
</script>
<center><h2>Add New Event</h2></center>
<sf:form action="/Online_Sports_Club/admin/addNewEvent" modelAttribute="eventModel" onsubmit="return validateMyForm()"> 
	<div class="registration_form" >
	<table align="center"style="background-color:#e5f0ff;">
	<tr><td>
	Sport</td><td>
	<sf:select path="sportName">
	<c:forEach var="sportObj" items="${SportList}">
		<sf:option value="${sportObj.getSportName()}" ></sf:option>
	</c:forEach>
	</sf:select></td></tr>
	<tr><td>Event Date :</td><td><sf:input path="date" id="date"/></td></tr>
	<tr><td>Event Title : </td><td><sf:input path="title" id="title"/></td></tr>
	<tr><td>Event Description : </td><td><sf:textarea path="eventDesc" id="desc"/></td></tr>
	<tr><td>Event Image : </td><td><sf:input path="image" id="image"/></td></tr>
	<tr><td>Event Capacity : </td><td><sf:input path="capacity" id="capacity"/></td></tr>
	<tr><td>Charge  For Member : </td><td><sf:input path="chargeForMember" id="memcharge"/></td></tr>
	<tr><td>Charge For Non Member : </td><td><sf:input path="chargeForNonMember" id="nonmemcharge"/></td></tr>
	<tr><td> </td><td><input type="submit" value="ADD"></td></tr>
	</table>
	</div>
	
</sf:form>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />