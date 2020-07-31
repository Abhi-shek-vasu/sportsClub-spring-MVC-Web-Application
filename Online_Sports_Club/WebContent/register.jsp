<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf"  uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" language="javascript"> 
function validateMyForm() 
{ 
	var age=document.getElementById("age").value;
	alert(age);
	var x = document.getElementById("email").value;
	var atpos = x.indexOf("@");
	var dotpos = x.lastIndexOf(".");



if (document.forms[0].name.value == "")  
  { 
    	alert('Name must not be blank'); 
   		return false; 
  } 
  else if (document.forms[0].age.value == "")  
  { 
	    alert('Age must not be blank'); 
	    return false; 
  }
  else if (document.forms[0].age.value < 0 || document.forms[0].age.value > 120)  
  { 
	    alert('Enter valid Age'); 
	    return false; 
  }
  else if (document.forms[0].gender.value == "")  
  { 
	    alert('Gender must not be blank'); 
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
  else if (document.forms[0].password.value == "")  
  { 
	    alert('password must not be blank'); 
	    return false; 
  }
  else if (document.forms[0].address.value == "")  
  { 
	    alert('address must not be blank'); 
	    return false; 
 }
  else if (document.forms[0].useImage.value == "")  
 { 
	    alert('useImage must not be blank'); 
	    return false; 
 } 
document.forms[0].submit(); 
} 
</script>
<center><h1>Registration Form</h1></center>
<div class="registration_form" style="background-color:#e5f0ff;">
<sf:form action="registerUser" method="post" name="regform" modelAttribute="command" id="savelogin" onsubmit="return validateMyForm()">
<table align="center">
<tr><td>Name :</td><td><sf:input path="name" id="name"/></td></tr>
<tr><td>Age :</td><td><sf:input path="age" id="age"/></td></tr>
<tr><td>Gender:</td><td><sf:input path="gender" id="gender"/></td></tr>
<tr><td>Email :</td><td><sf:input path="email" id="email"/></td></tr>
<tr><td>Password :</td><td><sf:password path="password" id="password" /></td></tr>
<tr><td>Address :</td><td><sf:input path="address" id="address"/></td></tr>
<tr><td>Image  :</td><td><sf:input path="userImage" id="useImage"/></td></tr>
<tr><td><td><input type="submit" value="Register"></td></tr>
</table>
</sf:form>
</div>

