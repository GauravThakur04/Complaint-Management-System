package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {

                // Load MySQL Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // JDBC URL
                String url = "jdbc:mysql://localhost:3306/complaint_db"
                        + "?useSSL=false"
                        + "&allowPublicKeyRetrieval=true"
                        + "&serverTimezone=UTC";

                // Create connection
                connection = DriverManager.getConnection(
                        url,
                        "root",
                        "WEEKND2004"  
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
