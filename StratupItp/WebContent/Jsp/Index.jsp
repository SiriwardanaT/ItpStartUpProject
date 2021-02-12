<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.project.model.vehicleServices"%>
<%@page import="com.project.model.vehicleItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project.service.UserService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.2/html2pdf.bundle.min.js"></script>
<style>
.card{
   
   
   width: 70%;
   left:20%
 }

</style>
</head>


<body>

<h1>Payment of CB123 vehicle</h1>

 <%ArrayList<vehicleServices> service = UserService.getAllServices();%>
 
  <%for(vehicleServices v :service) {%>
<div class="card">
  <div class="card-header">
  <h4><%=v.getName()%></h4>
  
  </div>
  <div class="card-body">
           
           <%ArrayList<vehicleItem> items = UserService.getAllServicesItem(v.getName());%>
         <%for(vehicleItem item :items) {%>
          <p><%=item.getItemName()%></thp>
            
          <%}%>
          <input type="text" placeholder="Enter tot amount"><a href="#" class="btn btn-primary">add</a>
  </div>
</div>
<%} %>

          
 
 
  
     

</body>
</html>