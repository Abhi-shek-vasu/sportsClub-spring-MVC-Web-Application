<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 <script type="text/javascript" language="javascript"> 
function validateMyForm() 
{ 
	var x = document.getElementById("email").value;
	var atpos = x.indexOf("@");
	var dotpos = x.lastIndexOf(".");



  if (document.forms[0].name.value == "")  
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
 else if (document.forms[0].question.value == "")  
 { 
	    alert('Question must not be blank'); 
	    return false; 
 } 
document.forms[0].submit(); 
} 
</script>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<center><h3>POST ENQUIRY</h3></center>
<div class="registration_form" style="background-color:#e5f0ff;">
<sf:form modelAttribute="ENQMODEL" action="addEnquiry" onsubmit="return validateMyForm()">
<table>
<tr><td>Name : </td><td><sf:input path="name" id="name"/></td></tr>
<tr><td>Email : </td><td><sf:input path="email" id="email"/></td></tr>
<tr><td >Question : </td><td><sf:textarea path="question" id="question"/></td></tr>
<tr><td ></td><td><input type="submit" value="POST ENQUIRY" /></td></tr>
</table>
</sf:form>
</div>