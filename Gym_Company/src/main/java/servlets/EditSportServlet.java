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

@WebServlet("/EditSportServlet")
public class EditSportServlet extends HttpServlet {
   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String newName = request.getParameter("name");
        double newCost = Double.parseDouble(request.getParameter("cost"));
        String newCoach = request.getParameter("coach");
        String newTime = request.getParameter("time");
        int newNumberOfPlaces = Integer.parseInt(request.getParameter("numberOfPlaces"));
        int newRating = Integer.parseInt(request.getParameter("rating"));

        try (Connection connection = DataBaseConnector.getConnection();) {
            String sql = "UPDATE sports SET name = ?, cost = ?, coach = ?, time = ?, number_of_places = ?, rating = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newName);
                preparedStatement.setDouble(2, newCost);
                preparedStatement.setString(3, newCoach);
                preparedStatement.setString(4, newTime);
                preparedStatement.setInt(5, newNumberOfPlaces);
                preparedStatement.setInt(6, newRating);
                preparedStatement.setInt(7, id);
                preparedStatement.executeUpdate();
                
                System.out.println("Sport "+ newName + " Has been updated");
                response.sendRedirect("index.jsp");
            }
            
            
            return;
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., show an error message to the user
        }
    }
}
