<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  else if (document.forms[0].isactive.value == "")  
  { 
	    alert('Enter Is Active'); 
	    return false; 
  }

 
  
document.forms[0].submit(); 
} 
</script>
<div class="registration_form" style="background-color:#e5f0ff;">
<sf:form modelAttribute="CHARGEMODEL" action="updateCharges" onsubmit="return validateMyForm()">
 <table style="background-color:#e5f0ff;">
 <sf:hidden path="sports_id" value="${Charge.getSports_id()}"/>
 <sf:hidden path="id" value="${Charge.getId()}"/>
 <sf:hidden path="nonMemberMonthly" value="${Charge.getNonMemberMonthly()}"/>
 
 <tr><td>MAXTIME :</td><td><sf:input path="maxTime" id="maxtime" value="${Charge.getMaxTime()}" /><br/></td></tr>
 <tr><td>MAX AVAILABLE TIME</td><td> <sf:input path="availableTime" id="availtime" value="${Charge.getAvailableTime()}" /></td></tr>
 <tr><td>MEMBER DAILY</td> <td><sf:input path="memberDaily" id="memdaily" value="${Charge.getMemberDaily()}" /></td></tr>
 <tr><td>MEMBER MONTHLY </td><td><sf:input path="memberMonthly" id="memmonthly" value="${Charge.getMemberMonthly()}" /></td></tr>
<tr><td> NON MEMBER DAILY </td><td><sf:input path="nonMemberDaily" id="nonmemdaily" value="${Charge.getNonMemberDaily()}"/> </td></tr>
<tr><td> MEMBER YEARLY</td><td><sf:input path="memberYearly" id="memyearly" value="${Charge.getMemberYearly()}"/></td></tr>
 <tr><td>MEMBER QUARERLY </td><td><sf:input path="memberQuarterly" id="memquar" value="${Charge.getMemberQuarterly()}"/></td></tr>
 <tr><td>MEMBER HALF YEARLY</td><td><sf:input path="memberHalfYearly" id="half" value="${Charge.getMemberHalfYearly()}"/></td></tr>
 <tr><td>SPACIALITY</td><td><sf:input path="Spaciality" id="spacility" value="${Charge.getSpaciality()}"/></td></tr>
  <tr><td>IS CURRUNTLY ACTIVE </td><td><sf:input path="isActive" id="isactive" value="${Charge.getIsActive()}"/></td></tr>
  <tr><td></td><td><input type="submit" value="SUBMIT"/></td></tr>
 </table>
 </sf:form>  
 </div>
 <link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />
