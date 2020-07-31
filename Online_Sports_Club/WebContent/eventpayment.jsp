<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<script>
function validateform()
{
	var bankname=document.forms["regform"]["bankName"].value;
	var creditCardNumber=document.forms["regform"]["creditCardNumber"].value;
	var bankName=document.forms["regform"]["bankName"].value;
	var cvccode=document.forms["regform"]["cvccode"].value;
	var expiryDate=document.forms["regform"]["expiryDate"].value;
	var password=document.forms["regform"]["password"].value;
		if(bankname==null || bankname=="")
		{
			alert("Bank name must be filled out");
			return false;
		}
		else if(creditCardNumber==null || creditCardNumber=="")
		{
			alert("Credit Card number must be filled out");
			return false;
		}
		else if(cvccode==null || cvccode=="")
		{
			alert("CVC Code  must be filled out");
			return false;
		}
		else if(expiryDate==null || expiryDate=="")
		{
			alert("Expiry Date must be filled out");
			return false;
		}
		else if(password==null || password=="")
		{
			alert("Password must be filled out");
			return false;
		}
		return true;
}

</script>
<center><h3>Event Payment</h3>
<h3>Amount to pay : ${EventAttenders.getWillpay()}</h3></center>

<sf:form action="doneEventPayment" modelAttribute="EVENTATTMODEL" onsubmit="return validateform()" name="regform" >
<sf:hidden path="id" value="${EventAttenders.getId()}"/>
<sf:hidden path="name" value="${EventAttenders.getName()}"/>
<sf:hidden path="email" value="${EventAttenders.getEmail()}"/>
<sf:hidden path="willpay" value="${EventAttenders.getWillpay()}"/>
<sf:hidden path="eventId" value="${EventAttenders.getEventId()}"/>
<sf:hidden path="mobile" value="${EventAttenders.getMobile()}"/>


<div class="registration_form" style="background-color:#e5f0ff;">
<table>
<tr><td>Bank Name :</td><td><input type="text" name="bankName"></td></tr> 
<tr><td>Credit Card Number :</td><td> <input type="text" name="creditCardNumber"></td></tr> 
<tr><td>CVC Code : </td><td> <input type="text" name="cvccode"></td></tr> 
<tr><td>Expiry Date :</td><td><input type="text" name="expiryDate"></td></tr> 
<tr><td>Password : </td><td><input type="password" name="password"></td></tr> 
<tr><td></td><td><input type="submit" value="Make Payment"></td></tr>
</table>
</div>
</sf:form>
