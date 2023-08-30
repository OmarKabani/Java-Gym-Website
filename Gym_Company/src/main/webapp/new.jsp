<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Names</title>
</head>
<body>
    <h1>User Names</h1>

    <ul>
        <% for (String userName : (List<String>) request.getAttribute("userNamess")) { %>
            <li><%= userName %></li>
        <% } %>
    </ul>
</body>
</html>