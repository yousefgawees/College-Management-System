import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC
{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/college";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void connectAndInsert(String pos, String name,int reg ,int pin)
    {
        try 
        {
            Connection c = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String query = "INSERT into " + pos + " (name,regNumber,pin) VALUES (?,?,?)";
            PreparedStatement preparedStatement = c.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, reg);
            preparedStatement.setInt(3, pin);
            preparedStatement.executeUpdate();
            c.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
