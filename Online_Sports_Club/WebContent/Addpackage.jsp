<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 <script type="text/javascript" language="javascript"> 
function validateMyForm() 
{ 
 if (document.forms[0].maxtime.value == "")  
  { 
    	alert('Enter Maximum time'); 
   		return false; 
  } 
  else if (document.forms[0].availtime.value == "")  
  { 
	    alert('Enter Available time for that day'); 
	    return false; 
  }
  else if (document.forms[0].memdaily.value == "")  
  { 
	    alert('Enter Cost for Member daily'); 
	    return false; 
  } 
  else if (document.forms[0].memmonthly.value == "")  
  { 
	    alert('Enter Cost for Member monthly'); 
	    return false; 
  }
  else if (document.forms[0].nonmemdaily.value == "")  
  { 
	    alert('Enter Cost for Non Member daily'); 
	    return false; 
  }
  else if (document.forms[0].nonmemmonthly.value == "")  
  { 
	    alert('Enter Cost for Non Member Monthly'); 
	    return false; 
  }
  else if (document.forms[0].memyearly.value == "")  
  { 
	    alert('Enter Cost For Member yearly'); 
	    return false; 
  }
  else if (document.forms[0].memquar.value == "")  
  { 
	    alert('Enter Cost for Member Quarterly'); 
	    return false; 
  }
  else if (document.forms[0].half.value == "")  
  { 
	    alert('Enter Cost for Member Half yearly'); 
	    return false; 
  }
  else if (document.forms[0].spacility.value == "")  
  { 
	    alert('Enter Spaciality'); 
	    return false; 
  }

 
  
document.forms[0].submit(); 
} 
</script>
<div class="registration_form" style="background-color:#e5f0ff;">
 <sf:form modelAttribute="CHARGEMODEL" action="enterslotdetails" onsubmit="return validateMyForm()">
 <table align="center" style="background-color:#e5f0ff;">
 <tr><td>Select Sport</td><td>
<sf:select path="sports_id">
	<c:forEach var="sportObj" items="${SportList}">
		<sf:option value="${sportObj.getId()}" >${sportObj.getSportName()}</sf:option>
	</c:forEach>
	</sf:select>  </td></tr>
 <tr><td>MAXTIME :</td><td><sf:input path="maxTime" id="maxtime"/><br/></td></tr>
 <tr><td>MAX AVAILABLE TIME</td><td> <sf:input path="availableTime"  id="availtime"/></td></tr>
 <tr><td>MEMBER DAILY</td> <td><sf:input path="memberDaily" id="memdaily"/></td></tr>
 <tr><td>MEMBER MONTHLY </td><td><sf:input path="memberMonthly" id="memmonthly"/></td></tr>
<tr><td> NON MEMBER DAILY </td><td><sf:input path="nonMemberDaily" id="nonmemdaily"/></td></tr>
<tr><td> NON MEMBER MONTHLY </td><td><sf:input path="nonMemberMonthly" id="nonmemmonthly"/></td></tr>
<tr><td> MEMBER YEARLY</td><td><sf:input path="memberYearly" id="memyearly"/></td></tr>
 <tr><td>MEMBER QUARERLY </td><td><sf:input path="memberQuarterly" id="memquar"/></td></tr>
 <tr><td>MEMBER HALF YEARLY</td><td><sf:input path="memberHalfYearly" id="half"/></td></tr>
 <tr><td>SPACIALITY</td><td><sf:input path="Spaciality" id="spacility"/></td></tr>
  <tr><td></td><td><input type="submit" value="SUBMIT"/></td></tr>
 </table>
 </sf:form>   
 </div>
 <link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />