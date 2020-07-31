<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<script type="text/javascript" language="javascript"> 
function validateMyForm() 
{ 
 if (document.forms[0].slotDesc.value == "")  
  { 
    	alert('Slot Description must not be blank'); 
   		return false; 
  } 
  else if (document.forms[0].slotCapacity.value == "")  
  { 
	    alert('Enter Slot Capacity'); 
	    return false; 
  }
  else if (document.forms[0].occupiedSlots.value == "")  
  { 
	    alert('Enter Occupied Slots'); 
	    return false; 
  } 
  else if (document.forms[0].availabeSlots.value == "")  
  { 
	    alert('Enter availabe slots'); 
	    return false; 
  }
  
document.forms[0].submit(); 
} 
</script>
<center><h2>Add New Slot</h2></center>
<div class="registration_form" style="background-color:#e5f0ff;">
<sf:form action="/Online_Sports_Club/admin/AddSlot" modelAttribute="SLOTMODEL" onsubmit="return validateMyForm()">
	<table align="center" style="background-color:#e5f0ff;">
	<sf:hidden path="sportId" value="${sportId}" />
	<tr><td>SLOT DESC</td><td><sf:input path="slotDesc" id="slotDesc"/></td></tr>
	 <tr><td>SLOT CAPACITY</td><td><sf:input path="slotCapacity" id="slotCapacity" /></td></tr>
	<tr><td>OCCUPIED SLOTS</td><td><sf:input path="occupiedSlots" id="occupiedSlots"/></td></tr>
	<tr><td>AVAILABLE SLOTS</td><td><sf:input path="availabeSlots" id="availabeSlots"/></td></tr>
	<tr><td><input type="submit" value="ADD SLOT"/></td><td></td></tr>
	</table>
</sf:form>
</div>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />