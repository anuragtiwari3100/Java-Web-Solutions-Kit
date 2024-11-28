<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Dynamic Page</title>
</head>
<body>
    <h1>JSP Web Application to Generate Dynamic Content</h1>

    <%-- Importing the Date class --%>
    <%@ page import="java.util.Date" %>

    <%!
        // You can use this in the scriptlet section if needed
        int age = 18;
    %>

    <%-- Fetching data from the form --%>
    <%
        String name = request.getParameter("uname");
        String ucity = request.getParameter("ucity");

        // Date object to display the current date and time
        Date date = new Date();
    %>

    <%-- Output the information dynamically --%>
    <p>Hello, <%= name %>!</p>
    <p>It's great to know you're from <%= ucity %>!</p>
    <p>The current date and time is: <%= date %></p>

    <%-- Optionally display the age --%>
    <p>Your age is: <%= age %></p>

</body>
</html>
