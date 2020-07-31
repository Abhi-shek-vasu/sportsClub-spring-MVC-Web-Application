<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/resources/css/styles.css">
   <script src="/resources/js/jquery-2.2.0.js" type="text/javascript"></script>
   <script src="/resources/js/script.js"></script>
    <style type="text/css">
  ul {list-style: none;padding: 0px;margin: 0px;}
  ul li {display: block;position: relative;float: left;border:1px solid #000}
  li ul {display: none;}
  ul li a {display: block;background: #000;padding: 5px 10px 5px 10px;text-decoration: none;
           white-space: nowrap;color: #fff;}
  ul li a:hover {background: #f00;}
  li:hover ul {display: block; position: absolute;}
  li:hover li {float: none;}
  li:hover a {background: #f00;}
  li:hover li a:hover {background: #000;}
  #drop-nav li ul li {border-top: 0px;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<ul id="drop-nav">
  <li><a href="#">Support</a></li>
  <li><a href="#">Web Design</a>
    <ul>
      <li><a href="#">HTML</a></li>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
    </ul>
  </li>
  <li><a href="#">Content Management</a>
    <ul>
      <li><a href="#">Joomla</a></li>
      <li><a href="#">Drupal</a></li>
      <li><a href="#">WordPress</a></li>
      <li><a href="#">Concrete 5</a></li>
    </ul>
  </li>
  <li><a href="#">Contact</a>
    <ul>
      <li><a href="#">General Inquiries</a></li>
      <li><a href="#">Ask me a Question</a></li>
    </ul>
  </li>
</ul>
</html>