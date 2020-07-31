<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
<center><h3>Amount to pay : ${sessionScope.SubscriptionData.getPaidAmount()}</h3></center>
<div class="registration_form">
<form action="donepayment" name="regform" onsubmit="return validateform()">
<table>
<tr><td>Bank Name :</td><td><input type="text" name="bankName"></td></tr> 
<tr><td>Credit Card Number :</td><td> <input type="text" name="creditCardNumber"></td></tr> 
<tr><td>CVC Code : </td><td> <input type="text" name="cvccode"></td></tr> 
<tr><td>Expiry Date :</td><td><input type="text" name="expiryDate"></td></tr> 
<tr><td>Password : </td><td><input type="password" name="password"></td></tr> 
<tr><td></td><td><input type="submit" value="Make Payment"></td></tr>
</table>
</form>
</div>