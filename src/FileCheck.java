import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileCheck
{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/college";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static boolean found(String pos,int regN)  
    {
        try
        {
            Connection c = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String query = "";
            if(pos == "students")
            {
                query = "SELECT 1 FROM students WHERE regNumber = ?";
            }
            else
            {
                query = "SELECT 1 FROM professor WHERE regNumber = ?";
            }

            PreparedStatement preparedStatement = c.prepareStatement(query);
            preparedStatement.setInt(1, regN);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) 
            {
                return true;
            }
            c.close();
            return false;
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return false;
        }
    }

    public static boolean checkLogin(String pos, int regNumber, int password) 
    {
        String query;

        if(pos == "students")
        {
            query = "SELECT 1 FROM students WHERE regNumber = ? AND pin = ?";
        }
        else
        {
            query = "SELECT 1 FROM professor WHERE regNumber = ? AND pin = ?";
        }

        try 
        {
            Connection c = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = c.prepareStatement(query);
            preparedStatement.setInt(1, regNumber);
            preparedStatement.setInt(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
            {
                return true;
            }

        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 
        return false;
    }
}
