<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="sf"  uri="http://www.springframework.org/tags/form" %>
    
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
<form action="loginValidate">
	Email :<input type="text" name="email" /><br/><br/>
	Password :<input type="password" name="password" /><br/><br/>
	<input type="submit" value="Sign In "><br/><br/>
</form>

</body>
</html> --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<form name='f' action="<c:url value='j_spring_security_check' />"
	method='POST'>
<div class="registration_form" style="margin-top: 80px;    background-color:#e5f0ff;">
	<table>
		<tr>
			<td>User:</td>
			<td><input type='text' name='j_username' value='' >
			</td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type='password' name='j_password'/>
			</td>
		</tr>
		<tr>
			<td colspan='2'>
				<input name="submit" type="submit" value="submit" />
				<input name="reset" type="reset" />
			</td>
		</tr>
	</table>
</div>
</form>
