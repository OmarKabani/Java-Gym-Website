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
			String servlet = request.getParameter("servlet");
	
			if(servlet == "EnrollSportServlet"){
				request.getRequestDispatcher("/TopSportsServlet").include(request, response);
			}else{
				response.sendRedirect("index/jsp");
			}
	
	%>

</body>
</html>