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

@WebServlet("/DisplayClasses")
public class DisplayClasses extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<SportClass> classes = new ArrayList<>();
        
        

        try {


            // Establish the database connection
            Connection connection = DataBaseConnector.getConnection();

            // Prepare the SQL query
            String query = "SELECT * FROM sports";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and populate the list of classes
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double cost = resultSet.getDouble("cost");
                String coach = resultSet.getString("coach");
                String name = resultSet.getString("name");
                String time = resultSet.getString("time");
                int numberOfPlaces = resultSet.getInt("number_of_places");
                double rating = resultSet.getDouble("rating");
                
                
                
                

                SportClass sportClass = new SportClass(id, cost, coach, name, time, numberOfPlaces, rating);
                classes.add(sportClass);
            }

            // Close the resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the list of classes as an attribute and forward to the JSP page
        request.setAttribute("classes", classes);
//        request.getRequestDispatcher("classes.jsp").forward(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/classes.jsp");
        dispatcher.forward(request, response);
    }

}
