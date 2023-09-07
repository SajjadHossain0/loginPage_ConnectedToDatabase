import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    private static Connection connection;
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:****/****";//"jdbc:mysql://localhost:[port]]/[database name]"
            String username = "****";
            String password = "****";
            connection = DriverManager.getConnection(url, username, password);
            //System.out.println("done....");

        }catch (Exception e){
            System.out.println("Error");;
        }
        return connection;
    }
}
