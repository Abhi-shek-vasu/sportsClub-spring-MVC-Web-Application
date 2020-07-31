<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h3>All Answers</h3>

<c:forEach var="enqObj" items="${EnquiryList}">
<div style="width: 100% ; border: solid 1px black ;border-radius:6px;background-color:white; ;margin: auto; padding:10px;font-family: sans-serif;font-size: 13px; "> 
<div style="display: table-cell;padding:10px">Posted By : ${enqObj.getName()}<br/>Question: ${enqObj.getQuestion()} <br/></div><br/>
<div style="display: table-cell;padding:10px">Answer : ${enqObj.getAnswer()}</div>
</div>
<hr/>
</c:forEach>