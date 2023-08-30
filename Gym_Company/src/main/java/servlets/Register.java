package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Register")
public class Register extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtain user information from the POST request
        String userName = request.getParameter("user_name");
        String userEmail = request.getParameter("user_email");
        String userPassword = request.getParameter("user_password");
        int isAdmin = 0;

        // Database connection and insertion
        try {
            
            Connection connection = DataBaseConnector.getConnection();

            // Insert user information into the user table
            String insertQuery = "INSERT INTO user (name, is_admin, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, userName);
            preparedStatement.setInt(2, isAdmin);
            preparedStatement.setString(3, userEmail);
            preparedStatement.setString(4, userPassword);
            

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            
            
            
            int userId = -1;
            if (generatedKeys.next()) {
                userId = generatedKeys.getInt(1);
                System.out.println("New User ID is " + userId);
            }

            System.out.println("User: " + userName + " have been Registered Successfully");

            preparedStatement.close();
            connection.close();

            // Create a new session for the registered user with their user ID
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);


            // Redirect to a success page
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            // Handle any exceptions (display an error page or message)
            e.printStackTrace();
            response.sendRedirect("contact.html");
        }
    }

}
