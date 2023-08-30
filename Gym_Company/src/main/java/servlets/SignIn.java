package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SignIn")
public class SignIn extends HttpServlet{
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("user_email");
        String password = request.getParameter("user_password");

        

		
		try {
			Connection connection = DataBaseConnector.getConnection();

            String query = "SELECT * FROM user WHERE email = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            
       

            
            
            if (resultSet.next()) {
            	
            	int userId = resultSet.getInt("id");
            	String name = resultSet.getString("name");
            	
            	boolean isAdmin = resultSet.getBoolean("is_admin");
            	
            	

                // Authentication successful, create a session with user ID and isAdmin status.
                HttpSession session = request.getSession();
                

                if (isAdmin) {
                    session.setAttribute("isAdmin", true);
                    session.setAttribute("admin_name", name);
//                    session.setAttribute("userId", null);
                    System.out.println("Admin User " + userId + " have Signed in");
                    response.sendRedirect("index.jsp");
                } else {
                	session.setAttribute("userId", userId);
                    System.out.println("User " + userId + " have Signed in");
                    response.sendRedirect("index.jsp");
                }

                // Redirect to index.jsp
                
            } else {
                // Authentication failed, redirect back to the sign_in.jsp page with an error message.
                response.sendRedirect("sign_in.jsp?error=not_found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle database connection errors here
        } 
    }

}
