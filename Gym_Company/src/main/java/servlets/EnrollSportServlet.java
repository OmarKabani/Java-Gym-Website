package servlets;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/EnrollSportServlet")
public class EnrollSportServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        int sportId = Integer.parseInt(request.getParameter("sport_id"));
        
        System.out.println("User ID " + userId);
        System.out.println("sportId " + sportId);

        try {
            Connection connection = DataBaseConnector.getConnection();

            
            
            
            
            
            
            
         // Check if there are available places in the sport
            String checkQuery = "SELECT number_of_places FROM sports WHERE id = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setInt(1, sportId);
            ResultSet checkResultSet = checkStatement.executeQuery();

            if (checkResultSet.next()) {
                int availablePlaces = checkResultSet.getInt("number_of_places");

                if (availablePlaces > 0) {
                    // Enroll the user
                	
                	System.out.println("There is enough space to enroll");
                	
                    String enrollQuery = "INSERT INTO subscribtion (user_id, sport_id) VALUES (?, ?)";
                    PreparedStatement enrollStatement = connection.prepareStatement(enrollQuery);
                    enrollStatement.setInt(1, sportId);
                    enrollStatement.setInt(2, userId);
                    enrollStatement.executeUpdate();

                    // Update number_of_places in the sports table
                    String updateQuery = "UPDATE sports SET number_of_places = number_of_places - 1 WHERE id = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    updateStatement.setInt(1, sportId);
                    updateStatement.executeUpdate();
                    
                    System.out.println("Number of places -1");

                    enrollStatement.close();
                    updateStatement.close();
                    
                    
                    System.out.println(" User "+userId +" has enrolled in sport "+sportId);

                    
                 // Fetch the list of enrolled sports for the user
                    String selectQuery = "SELECT s.* FROM sports s INNER JOIN subscribtion sub ON s.id = sub.sport_id WHERE sub.user_id = ?";
//                    String selectQuery = "SELECT s.* FROM sports s, subscribtion sub WHERE sub.user_id = ? AND s.id = sub.sport_id";
                    PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                    selectStatement.setInt(1, sportId);
            
                    
                    ResultSet resultSet = selectStatement.executeQuery();
                    
                    

                    List<SportClass> enrolledSports = new ArrayList<>();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        double cost = resultSet.getDouble("cost");
                        String coach = resultSet.getString("coach");
                        String name = resultSet.getString("name");
                        String time = resultSet.getString("time");
                        int numberOfPlaces = resultSet.getInt("number_of_places");
                        double rating = resultSet.getDouble("rating");

                        enrolledSports.add(new SportClass(id, cost, coach, name, time, numberOfPlaces, rating));
                    }
                    selectStatement.close();
                    
                    
                    System.out.println("Enrolled Sports "+enrolledSports);


                    
                    
                    
                    request.setAttribute("enrolledSports", enrolledSports);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/my_classes.jsp");
                    dispatcher.forward(request, response);
                    
                    
                } else {
                    response.getWriter().write("No available places in the sport");
                }
            } else {
                response.getWriter().write("Sport not found");
            }

            
            
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Enrollment failed");
        }
    }

}
