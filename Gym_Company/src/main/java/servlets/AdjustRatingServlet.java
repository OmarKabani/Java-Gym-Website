package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/AdjustRatingServlet")
public class AdjustRatingServlet extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("operation");
        int sportId = Integer.parseInt(request.getParameter("sport_id"));

        try (Connection connection = DataBaseConnector.getConnection()) {
            String updateRatingSql = "UPDATE sports SET rating = rating " + (operation.equals("add") ? "+" : "-") + " 1.0 WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateRatingSql)) {
                preparedStatement.setInt(1, sportId);
                preparedStatement.executeUpdate();
                
                System.out.println("Rating for Sport " + sportId + " has been adjusted (" + operation + ")");
            }

            // Redirect to a success page or any other appropriate page
            response.sendRedirect("redirect_classes.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., show an error message to the user
        }
    }
}
