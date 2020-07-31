<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 <script type="text/javascript" language="javascript"> 
function validateMyForm() 
{ 
  if (document.forms[0].answer.value == "")  
  { 
    	alert('Answer must not be blank'); 
   		return false; 
  } 
document.forms[0].submit(); 
} 
</script> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<center><h3>POST ANSWER HERE</h3>
<B>QUESTION </B><p>${Enquiry.getQuestion()}</p><br/>
<B>NAME : </B><p>${Enquiry.getName()}</p><br/>
<B>EMAIL : </B><p>${Enquiry.getEmail()}</p><br/>
<div class="registration_form" style="background-color:#e5f0ff;">
<sf:form action="saveAnswer" modelAttribute="ENQMODEL" onsubmit="return validateMyForm()">
<sf:hidden path="enq_id" value="${Enquiry.getEnq_id()}" />
<sf:hidden path="name" value="${Enquiry.getName()}" />
<sf:hidden path="question" value="${Enquiry.getQuestion()}" />
<sf:hidden path="email" value="${Enquiry.getEmail()}" />
ANSWER : <sf:textarea path="answer" id="answer" />
<input type="submit" value="POST ANSWER" />
</sf:form>
</div>
</center>
<link href="${pageContext.request.contextPath}/js/styles.css" rel="stylesheet" />