<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
a.adminLinkbtn {
    border: 2px solid #006600;
    border-radius: 5px;
    background-color: #009900;
    color: #ffffff;
    font-weight: bold;
    text-decoration: none;
    margin : 20px;
    padding: 10px 20px 10px 20px;
    display: inline-block;
    width:300px;
}
a.adminLinkbtn:hover {
    border: 2px solid #009900;
    background-color: #00cc00;
}
div.admindiv
{
margin: auto;
margin-left:200px;
display: table-cell;
}
</style>
<div class="admindiv">
<h2><a href="/Online_Sports_Club/admin/addEvent" class="adminLinkbtn"> Add Event</a></h2>
<h2><a href="/Online_Sports_Club/admin/getAllEvents" class="adminLinkbtn">Get Events</a></h2>
<h2><a href="/Online_Sports_Club/admin/ShowManageEvents" class="adminLinkbtn">Manage Events</a></h2>
<h2><a href="/Online_Sports_Club/admin/postEnquiryAnswers" class="adminLinkbtn">Answer Questions</a></h2>
</div>
<div class="admindiv">
<h2><a href="/Online_Sports_Club/admin/addSlotforSport" class="adminLinkbtn">Add Packages</a></h2>
<h2><a href="/Online_Sports_Club/admin/addnewsport" class="adminLinkbtn">Add New Sport</a></h2>
<h2><a href="/Online_Sports_Club/admin/SubToSendMail" class="adminLinkbtn">Ending Subscriptions</a></h2>
<h2><a href="/Online_Sports_Club/admin/editSportsInfo" class="adminLinkbtn">Edit All Sports Related Info</a></h2>
</div>