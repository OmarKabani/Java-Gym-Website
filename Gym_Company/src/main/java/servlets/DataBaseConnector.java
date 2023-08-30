package servlets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {
	
	private static String jdbcUrl = "jdbc:mysql://localhost:3306/gym_java_project";
    private static String jdbcUser = "root";
    private static String jdbcPassword = "root";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con=DriverManager.getConnection(  
            		"jdbc:mysql://localhost:8889/gym_java_project","root","root");
            System.out.println("Connection have be opened Sucessfully");
            return con;
//            return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Failed");
            System.out.println(e.getMessage());
        }
        return null;
    }

}
