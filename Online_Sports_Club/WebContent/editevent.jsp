<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <script type="text/javascript" language="javascript"> 
function validateMyForm() 
{ 
	if (document.forms[0].id.value == "")  
	  { 
	    	alert('Id must not be blank'); 
	   		return false; 
	  } 
	if (document.forms[0].image.value == "")  
  { 
    	alert('Image must not be blank'); 
   		return false; 
  } 
  else if (document.forms[0].title.value == "")  
  { 
	    alert('Title must not be blank'); 
	    return false; 
  }
  else if (document.forms[0].date.value == "")  
  { 
	    alert('Date must not be blank'); 
	    return false; 
  }
  else if (document.forms[0].eventDesc.value == "")  
  { 
	    alert('Event Description must not be blank'); 
	    return false; 
  } 
  else if (document.forms[0].isOnMainPage.value == "")  
  { 
	    alert('Is on main page must not be blank'); 
	    return false; 
  }
  else if (document.forms[0].capacity.value == "")  
  { 
	    alert('Capacity must not be blank'); 
	    return false; 
 }
  else if (document.forms[0].chargeForMember.value == "")  
 { 
	    alert('Charge For member must not be blank'); 
	    return false; 
 } 
  else if (document.forms[0].chargeForNonMember.value == "")  
  { 
 	    alert('Charge For non must not be blank'); 
 	    return false; 
  }

document.forms[0].submit(); 
} 
</script>
    <center><h2>Edit Event</h2></center>
    <div class="registration_form" style="background-color:#e5f0ff;">
<sf:form action="/Online_Sports_Club/admin/updateEvent" modelAttribute="E_MODEL" onsubmit="return validateMyForm()">
	<table align="center" style="background-color:#e5f0ff;">
	<tr>
	<td>Event Number </td><td><sf:input path="id"  value="${Event.getId()}" /></td></tr>
	<tr><td>
	Sport:</td><td>
	<sf:select path="sportName">
	<c:forEach var="sportObj" items="${SportList}">
		<sf:option value="${sportObj.getSportName()}" ></sf:option>
		
	</c:forEach>
	</sf:select>
	</td></tr>
	
	<tr><td>Event Image :</td><td><sf:input path="image" id="image" value="${Event.getImage()}" /></td></tr>
	<tr><td>Event Title :</td><td><sf:input path="title" id="title" value="${Event.getTitle()}" /></td></tr>
	<tr><td>Event Date :</td><td><sf:input path="date" id="date" value="${Event.getDate()}" /></td></tr>
	<tr><td>Event Description :</td><td> <sf:input path="eventDesc" id="eventDesc" value="${ Event.getEventDesc()}"/></td></tr>
	<tr><td>Is On Main Page : </td><td><sf:input path="isOnMainPage" id="isOnMainPage" value="${Event.getIsOnMainPage()}"/></td></tr>
	<tr><td>Event Capacity : </td><td><sf:input path="capacity" id="capacity" value="${Event.getCapacity()}"/></td></tr>
	<tr><td>Charge  For Member : </td><td><sf:input path="chargeForMember" id="chargeForMember" value="${Event.getChargeForMember()}"/></td></tr>
	<tr><td>Charge For Non Member : </td><td><sf:input path="chargeForNonMember" id="chargeForNonMember" value="${Event.getChargeForNonMember()}"/></td></tr>
	<tr><td></td><td><input type="submit" value="Update"></td></tr>
	</table>
</sf:form>

</div>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />