<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 

        Object isAdmin = session.getAttribute("isAdmin");
        

        

        if (isAdmin != null && (Boolean) isAdmin) {
        %>
            <p>You are an admin user.</p>
            <!-- Place admin-specific content here -->
        
        
        <a href="Logout">Logout</a>
    <%
        } else {
        	
        	response.sendRedirect("index.jsp");
        }
    
    %>
</body>
</html>