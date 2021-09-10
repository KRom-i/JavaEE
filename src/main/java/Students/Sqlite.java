package Students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqlite {

    private final static String URL = "jdbc:sqlite:student.db";
    private static Connection connection;

    public static Connection getConnection(){
        if (connection != null) return connection;
        try {
            connection = DriverManager.getConnection (URL);
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return connection;
    }

    public static void connectionClose(){
        if (connection == null) return;
        try {
            connection.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }


}
