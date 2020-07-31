<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#header {
width:100%;
height:40px;
    background-color:lightgray;
    color:black;
    text-align:center;
    padding:25px;
    margin: auto;
}
#nav {
    line-height:30px;
   
    height:500px;
    width:170px;
    float:left;
    padding:5px;	      
}
#section {
    width:350px;
    float:left;
    padding:10px;	 	 
}
#mainContent
{
margin-left: 80px;

}
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
   padding:5px;	 	 
} 
#menu
{margin-left: 200px;}
</style>
		 <link rel="stylesheet" href="js/styles.css">
		 <link rel="stylesheet" href="js/sub.css">
		  <link rel="stylesheet" href="js/cssfile.css">
		 
   		<script src="js/jquery-2.2.0.js" type="text/javascript"></script>
   		<script src="js/script.js"></script>
  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title"/></title>
</head>
<body style="background-color: lightgray">
		<div id="header">
		
<div id='cssmenu'>
<ul>
   <li class='active has-sub'><a href='index'><span>The Club</span></a>
      <ul>
         <li class='has-sub'><a href='#'><span>About Us</span></a> </li>
         <li class='has-sub'><a href='#'><span>Contact Us</span></a></li>
         <li class='has-sub'><a href='#'><span>Picture Gallary</span></a></li>
         <li class='has-sub'><a href='#'><span>Community</span></a></li>
      </ul>
   </li>
      <li class='active has-sub'><a href='#'><span>Facilities</span></a>
      <ul>
         <li class='has-sub'><a href='allsports'><span>All Sports</span></a> </li>
         <li class='has-sub'><a href='indoorsports'><span>Indoor</span></a></li>
         <li class='has-sub'><a href='outdoorsports'><span>Outdoor</span></a> </li>
         <li class='has-sub'><a href='othersports'><span>Other</span></a></li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Membership</span></a>
      <ul>
         <li class='has-sub'><a href='#'><span>Monthly</span></a> </li>
         <li class='has-sub'><a href='#'><span>Yearly</span></a></li>
      </ul>
   </li>
     <li class='active has-sub'><a href='#'><span>Subscriptions</span></a>
      <ul>
         <li class='has-sub'><a href='gotosubscriptions'><span>Suscriptions</span></a> </li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Activities</span></a>
      <ul>
         <li class='has-sub'><a href='allsports'><span>Events</span></a> </li>
         <li class='has-sub'><a href='indoorsports'><span>Coaching And Training</span></a></li>
         <li class='has-sub'><a href='outdoorsports'><span>Yoga</span></a> </li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Affileted Clubs</span></a></li>
   <li class='active has-sub'><a href='#'><span>FeedBack</span></a>
      <ul>
         <li class='has-sub'><a href='allsports'><span>Post Feedback</span></a> </li>
         <li class='has-sub'><a href='postEnquiry'><span>Post Enquiry</span></a></li>
         <li class='has-sub'><a href='getAnswers'><span>Get Answers</span></a></li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Login/Register</span></a>
      <ul>
         <% if(session.getAttribute("username")==null){ %><li class='has-sub'><a href='login123'><span>Login</span></a> </li><%} %>
         <li class='has-sub'><a href='register'><span>Register</span></a></li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span><% if(session.getAttribute("username")==null) { %><% } else { %>Hello ${sessionScope.username} <img src="images/users/${sessionScope.USERIMAGE}" height="17px" width="17px" /> <%} %></span></a>
      <ul>
           <% if(session.getAttribute("username")!=null){ %><li class='has-sub'><a href='logout'><span>Logout</span></a> </li> <li class='has-sub'><a href='myprofile'><span>My Profile</span></a> </li><%} %>
  	 </ul> 
  </li>
   </ul>
</div>	</div>
<div id="nav">
<tiles:insertAttribute name="mainevents"/>
</div>
<div id="mainContent">
<tiles:insertAttribute name="body"/>
</div> 
<div id="footer">
Copyright © www.citysports.com
</div>
       </body>
</html>

  