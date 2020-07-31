<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<center>
<h2>${SelectedSport.getSportName()}</h2>
<div style="width: 300px; position: relative;margin: auto;"><img src="images/Sport_Images/${SelectedSport.getSportImage()}" style="max-width:100%;
max-height:100%;"/></div>

<table >
<tr><th>Ground Number</th><th>Exact Location</th></tr>
<c:forEach var="locObject" items="${SelectedSport.getLocationList()}">
<tr> <td>${ locObject.getGroundNo()}</td>
<td>${ locObject.getLocInClub()}</td></tr>
</c:forEach>
</table>
<h3>Charges</h3><h2>${ selectedCharges.getSpaciality()}</h2>
<table border="1">
<tr><th>GAME AVAILABLE TIME IN A DAY</th><th>MAXIMUM TIME PER PERSON</th><th>NON MEMBER DAILY</th><th> MEMBER MONTHLY</th><th>MEMBER QUARTERLY</th><th>MEMBER HALF YEARLY</th><th>MEMBER YEARLY</th></tr>
<tr> 
<td>${ selectedCharges.getAvailableTime()}</td>
<td>${ selectedCharges.getMaxTime()}</td>
<td>${ selectedCharges.getNonMemberDaily()}</td>
<td>${ selectedCharges.getMemberMonthly()}</td>
<td>${selectedCharges.getMemberQuarterly()}</td>
<td>${ selectedCharges.getMemberHalfYearly()}</td>
<td>${ selectedCharges.getMemberYearly()}</td>
</tr>
</table>
<h3>Coaches</h3>
<table border="1">
<tr><th>Coach Name </th><th>Age </th><th>Experiance</th><th>Achievement/Qualification</th></tr>
<c:forEach var="coachObject" items="${SelectedSport.getCoachList()}">
<tr> 
<td>${ coachObject.getName()}</td>
<td>${ coachObject.getAge()}</td>
<td>${ coachObject.getExperiance()}</td>
<td>${ coachObject.getQualification()}</td>
</tr>
</c:forEach>
</table>
</center>