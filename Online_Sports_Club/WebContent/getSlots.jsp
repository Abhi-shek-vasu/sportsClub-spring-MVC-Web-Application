<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<script type="text/javascript" language="javascript"> 
function validateMyForm() 
{ 
	var d=document.getElementById("date").value;
	alert(d);
	var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/ ;
	if(!(date_regex.test(d)))
	{
		alert("Enter date in the format mm/dd/yyyy");
	return false;
	}
	
  
document.forms[0].submit(); 
} 
</script>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<center>
<h3>${SelectedSport.getSportName()}</h3>
<sf:form action="mapselectedslot" modelAttribute="command" onsubmit="return validateMyForm()">
<h4>Select Package ${ selectedCharges.getSpaciality()}</h4>
<div style="width: 300px;display: table-cell; margin: auto;padding: 20px;">
<table border="1" style="border:1;border-collapse: collapse; text-align: center;" >
<tr><th> Non Member Daily </th><td>${ selectedCharges.getNonMemberDaily()}</td><td><sf:radiobutton  path="pack" value="daily" checked="true"/></td></tr>
<tr><th> Member Monthly</th><td>${ selectedCharges.getMemberMonthly()}</td><td><sf:radiobutton path="pack"  value="monthly"/></td></tr>
<tr><th>Member Quarterly</th><td>${selectedCharges.getMemberQuarterly()}</td><td><sf:radiobutton path="pack"  value="quarterYearly"/></td></tr>
<tr><th>Member Half Yearly</th><td>${ selectedCharges.getMemberHalfYearly()}</td><td><sf:radiobutton path="pack"  value="halfyearly"/></td></tr>
<tr><th>Member Yearly</th><td>${ selectedCharges.getMemberYearly()}</td><td><sf:radiobutton path="pack" value="yearly"/></td></tr>
</table> 
</div>
<div style="width: 300px;display: table-cell; margin: auto;padding: 20px;">
<table border="1" style="border: 1;border-collapse: collapse;text-align: center;" >
<tr><th>Slot Time</th> <th>Total Available Slots</th><td><td></tr>
<c:forEach var="slotObj" items="${SelectedSport.getSlotList()}">
<tr><td>${slotObj.getSlotDesc()}</td><td>${slotObj.getAvailabeSlots()}</td><td><sf:radiobutton path="slotId" value="${slotObj.getSlotId()}" id="slotpack" checked="true"/></td></tr>
</c:forEach> 
</table>
</div>
Date <sf:input path="dateTime" id="date"/><br/><br/>
<input type="submit" value="Make Payment" /><br/>
</sf:form>
</center>