<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<script type="text/javascript" language="javascript"> 
function validateMyForm() 
{ 
	var x = document.getElementById("email").value;
	var atpos = x.indexOf("@");
	var dotpos = x.lastIndexOf(".");
	if(document.forms[0].name.value == "")  
  { 
    	alert('Name must not be blank'); 
   		return false; 
  } 
  else if (document.forms[0].email.value == "")  
  { 
	    alert('email must not be blank'); 
	    return false; 
  }
  else if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
	{
	    alert("Not a valid e-mail address");
	    return false;
	}
	else if (document.forms[0].mobile.value == "")  
	  { 
	    alert('Mobile must not be blank'); 
	    return false; 
	}
document.forms[0].submit(); 
} 
</script>
<center><h1>Event Registration</h1></center>
<div class="registration_form" style="margin-top: 80px;background-color:#e5f0ff;">
<sf:form modelAttribute="EVENTATTMODEL" action="geteventcharge" onsubmit="return validateMyForm()">
<sf:hidden path="eventId" value="${Events.getId()}"/>
<table align="center">
<tr><td>Name : </td><td><sf:input path="name" id="name"/></td></tr>
<tr><td>Email : </td><td><sf:input path="email" id="email"/></td></tr>
<tr><td>Mobile : </td><td><sf:input path="mobile" id="mobile"/></td></tr>
<tr><td> </td><td><input type="submit" value="checkcharges" /></td></tr>
</table>
</sf:form>
</div>