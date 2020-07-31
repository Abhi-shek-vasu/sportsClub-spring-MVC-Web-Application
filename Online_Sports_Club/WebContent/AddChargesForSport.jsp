<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h3>Add Charges</h3>
<div class="registration_form" style="background-color:#e5f0ff;">
<sf:form modelAttribute="CHARGEMODEL" action="addNewCharges" onsubmit="return validateMyForm()">
 <table style="background-color:#e5f0ff;">
 <sf:hidden path="sports_id" value="${Sport.getId()}"/>
 <tr><td>MAXTIME :</td><td><sf:input path="maxTime" id="maxtime"/><br/></td></tr>
 <tr><td>MAX AVAILABLE TIME</td><td> <sf:input path="availableTime" id="availtime"/></td></tr>
 <tr><td>MEMBER DAILY</td> <td><sf:input path="memberDaily" id="memdaily" /></td></tr>
 <tr><td>MEMBER MONTHLY </td><td><sf:input path="memberMonthly" id="memmonthly" /></td></tr>
<tr><td> NON MEMBER DAILY </td><td><sf:input path="nonMemberDaily" id="nonmemdaily" /> </td></tr>
<tr><td> MEMBER YEARLY</td><td><sf:input path="memberYearly" id="memyearly" /></td></tr>
 <tr><td>MEMBER QUARERLY </td><td><sf:input path="memberQuarterly" id="memquar"/></td></tr>
 <tr><td>MEMBER HALF YEARLY</td><td><sf:input path="memberHalfYearly" id="half"/></td></tr>
 <tr><td>SPACIALITY</td><td><sf:input path="Spaciality" id="spacility" /></td></tr>
  <tr><td>IS CURRUNTLY ACTIVE </td><td><sf:input path="isActive" id="isactive" /></td></tr>
  <tr><td></td><td><input type="submit" value="SUBMIT"/></td></tr>
 </table>
 </sf:form>  
 </div>
 <link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />