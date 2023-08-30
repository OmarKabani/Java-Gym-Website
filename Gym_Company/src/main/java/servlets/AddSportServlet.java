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

@WebServlet("/AddSportServlet")
public class AddSportServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        double cost = Double.parseDouble(request.getParameter("cost"));
        String coach = request.getParameter("coach");
        String time = request.getParameter("time");
        int numberOfPlaces = Integer.parseInt(request.getParameter("numberOfPlaces"));
        int rating = Integer.parseInt(request.getParameter("rating"));

        try {
        	Connection connection = DataBaseConnector.getConnection();
            String sql = "INSERT INTO sports (name, cost, coach, time, number_of_places, rating) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, cost);
            preparedStatement.setString(3, coach);
            preparedStatement.setString(4, time);
            preparedStatement.setInt(5, numberOfPlaces);
            preparedStatement.setInt(6, rating);
            preparedStatement.executeUpdate();
            
            
            System.out.println("Sport "+ name+ " has beed added");
            
            connection.close();
            preparedStatement.close();
            
            
            response.sendRedirect("redirect_index.jsp");
            return;
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("add_sport.jsp");
            // Handle the exception appropriately, e.g., show an error message to the user
        }

        response.sendRedirect("add_sport.jsp"); // Redirect back to the form
    }
}
