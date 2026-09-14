import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// this java file acts as the bridge that links the java application to the local MYSQL server.
public class DBConnection{
    private static final String URL= "jdbc:mysql://localhost:3306/MessManagementDB";
    private static final String USER="root";

    private static final String 

    //put your your password here, i have hide mine  for security purpose.
    PASSWORD="Enter you mysql password";
    

    public static Connection getConnection() throws SQLException{

        return DriverManager.getConnection(URL, USER,PASSWORD);

    }   


}
