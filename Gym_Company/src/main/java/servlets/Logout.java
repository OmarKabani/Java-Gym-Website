package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Invalidate the session to log out the user
        HttpSession session = request.getSession(false); // Get the existing session, or null if not present
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }
        
        // Redirect back to the index.jsp page
        response.sendRedirect("index.jsp");
    }

}
