package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/TopSportsServlet")
public class TopSportsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<SportClass> topSports = new ArrayList<>();
        
        // Database connection parameters

        
        try {
        	Connection connection = DataBaseConnector.getConnection();

            String query = "SELECT * FROM sports ORDER BY rating DESC LIMIT 3";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
                double cost = resultSet.getDouble("cost");
                String coach = resultSet.getString("coach");
                String name = resultSet.getString("name");
                String time = resultSet.getString("time");
                int numberOfPlaces = resultSet.getInt("number_of_places");
                double rating = resultSet.getDouble("rating");
                
                topSports.add(new SportClass(id, cost, coach, name, time, numberOfPlaces, rating));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

       
        request.setAttribute("topSports", topSports);

	      RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
	      dispatcher.forward(request, response);
    }

}
