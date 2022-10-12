<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="css/admin.css">
</head>
<body>
    <div class="admin-container">
        <div class="welcome-message">
            Welcome Admin
        </div>

        <div class="admin-options">
            <input class="button" type="submit" value="Create Template"> 
            <input class="button" type="submit" value="Employee Details"> 
            <input class="button" type="submit" value="Assign Template"> 
        </div>
        
    </div>
    <%@ page import="com.bean.Users" %>
    <jsp:useBean id = "user" class="com.bean.Users"/>
	<%= "Name: "+user.getUser_name()+"Password: "+user.getPassword() %>
	
    
</body>
</html>