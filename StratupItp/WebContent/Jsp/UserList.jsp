<%@page import="jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter"%>
<%@page import="com.project.model.User"%>
<%@page import="com.project.service.UserService"%>
<%@page import="java.util.ArrayList"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
 .table{
   position:absolute;
   top: 75px;
   width: 50%;
   left:25%
 }
 h3{
  text-align: center;
 }
 form{
    position:absolute;
    
 
 }
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.2/html2pdf.bundle.min.js"></script>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/getUsers">
   
    Username :<input type="text" name="username">
    age :<input type="text" name="age">
    address :<input type="text" name ="address">
    <input type="date">
    <input type="submit">
      
 
</form>
 

<%ArrayList<User> users = UserService.getAllUsers();%>



<div id="PdfBody">
<h3>User</h3>
       <table class="table" style="padding:4px">
  <thead>
    <tr>   
      <th scope="col">Username</th>
      <th scope="col">age</th>
      <th scope="col">address</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <%for(User user :users) {%>
  <tbody>
    <tr>
      <td><%=user.getUsername()%></td>
      <td><%=user.getAge()%></td>
      <td><%=user.getAddress()%></td>
      
      <form method="post" action="<%=request.getContextPath()%>/Deleteusers">
        <input type="hidden" value=<%=user.getUsername()%> name="UserId">
        <td><Button class="btn btn-danger">Delete</Button></td>
      </form>
    
      <td><Button class="btn btn-primary">Update</Button></td>
    </tr>
   
  </tbody>

<%} %>
</table>
</div>
<form method="post" action="<%=request.getContextPath()%>/pdfDowload">
  <button  class="btn btn-primary">Download</button>
</form>
</body>
</html>