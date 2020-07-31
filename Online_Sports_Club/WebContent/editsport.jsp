<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<center>
<h2>${SelectedSport.getSportName()}</h2><c:url var="url" value="addLocations?sportId=${SelectedSport.getId()}" />
		<a href="${url}">Add Location</a>
<table >
<tr><th>Ground Number</th><th>Exact Location</th><th>Edit</th></tr>
<c:forEach var="locObject" items="${SelectedSport.getLocationList()}">
<tr> <td>${ locObject.getGroundNo()}</td>
<td>${ locObject.getLocInClub()}</td><td><c:url var="url" value="editlocations?locationId=${locObject.getLocId()}" />
		<a href="${url}">Edit</a> </td></tr>
</c:forEach>
</table>
<h3>SLOTS</h3><H3><c:url var="url" value="addNewSlot?sportId=${SelectedSport.getId()}" />
		<a href="${url}">Add New Slot</a></A></H3>
<table border="1" style="border: 1;border-collapse: collapse;" >
<tr><th>SLOT ID</th><th>SPORT ID</th><th>SLOT TIME</th><th>Slot Capacity </th> <th>Total Available Slots</th><th>Occupied Slots<th><th>Edit</th></tr>
<c:forEach var="slotObj" items="${SelectedSport.getSlotList()}">
<tr><th>${slotObj.getSlotId()}</th><th>${slotObj.getSportId()}</th><th>${slotObj.getSlotDesc()}</th><th>${slotObj.getSlotCapacity()}</th><th>${slotObj.getAvailabeSlots()}</th><th>${slotObj.getOccupiedSlots()}</th><td><c:url var="url" value="editSlots?SlotId=${slotObj.getSlotId()}" />
		<a href="${url}">Edit</a></td></tr>
</c:forEach> 
</table>
<h3>Charges</h3><c:url var="url" value="addCharges?SportId=${SelectedSport.getId()}" />
		<a href="${url}">Add Charges</a>
<table border="1">
<tr><th>Charge Id</th><th>GAME AVAILABLE TIME IN A DAY</th><th>MAXIMUM TIME PER PERSON</th><th>NON MEMBER DAILY</th><th> MEMBER MONTHLY</th><th>MEMBER QUARTERLY</th><th>MEMBER HALF YEARLY</th><th>MEMBER YEARLY</th><th>SPECIALITY</th><th>IS ACTIVE</th><th>EDIT</th></tr>
<c:forEach var="charge" items="${SelectedSport.getChargesList()}">
<tr> 
<td>${ charge.getId()}</td>
<td>${ charge.getAvailableTime()}</td>
<td>${ charge.getMaxTime()}</td>
<td>${ charge.getNonMemberDaily()}</td>
<td>${ charge.getMemberMonthly()}</td>
<td>${ charge.getMemberQuarterly()}</td>
<td>${ charge.getMemberHalfYearly()}</td>
<td>${ charge.getMemberYearly()}</td>
<td>${ charge.getSpaciality()}</td>
<td>${ charge.getIsActive()}</td>
<td><c:url var="url" value="editCharges?ChargesId=${charge.getId()}" />
		<a href="${url}">Edit</a> </td>
</tr></c:forEach>
</table>
<h3>Coaches</h3><c:url var="url" value="addtheNewCoaches?sportId=${SelectedSport.getId()}" />
		<a href="${url}">Add Coaches</a>
<table border="1">
<tr><th>Coach Name </th><th>Age </th><th>Experiance</th><th>Achievement/Qualification</th><th>Edit</th></tr>
<c:forEach var="coachObject" items="${SelectedSport.getCoachList()}">
<tr> 
<td>${ coachObject.getName()}</td>
<td>${ coachObject.getAge()}</td>
<td>${ coachObject.getExperiance()}</td>
<td>${ coachObject.getQualification()}</td>
<td><c:url var="url" value="editCoaches?CoachId=${coachObject.getId()}" />
		<a href="${url}">Edit</a> </td>
</tr>
</c:forEach>
</table>
</center>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />