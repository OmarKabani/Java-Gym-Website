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


@WebServlet("/DeleteSportServlet")
public class DeleteSportServlet extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection connection = DataBaseConnector.getConnection()) {
            String sql = "DELETE FROM sports WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                
                System.out.println("Sport "+ id + " has been deleted from sports");
            }
         // Delete the sport from the sports table
            String deleteSportSql = "DELETE FROM subscribtion WHERE sport_id = ?";
            try (PreparedStatement deleteSportStatement = connection.prepareStatement(deleteSportSql)) {
                deleteSportStatement.setInt(1, id);
                deleteSportStatement.executeUpdate();

                System.out.println("Sport " + id + " has been deleted from subscribtion");
            }

            // Redirect to a success page or the list of sports
            response.sendRedirect("redirect_classes.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., show an error message to the user
        }
    }
}
