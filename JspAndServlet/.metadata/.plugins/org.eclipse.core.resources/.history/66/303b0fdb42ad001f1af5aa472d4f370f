import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtill {

    // Static block to load the MySQL driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Correct MySQL driver
            System.out.println("Driver is Registered");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to establish a database connection
    public static Connection getDbConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/LoginApplication";
        String userName = "root";
        String password = "abhishek@2002";

        return DriverManager.getConnection(url, userName, password);
    }

    // Method to close resources
    public static void closeResource(Connection connect, Statement stmt) throws SQLException {
        if (connect != null) {
            connect.close();
        }
        if (stmt != null) {
            stmt.close();
        }
    }
}
