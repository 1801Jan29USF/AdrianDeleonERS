package main.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Functionality:
 */
public class ConnectionUtility {
    private static Properties prop = new Properties();
    private static ConnectionUtility connUtil = new ConnectionUtility();
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ConnectionUtility(){
        super();
        try {
            InputStream dbProps = ConnectionUtility.class.getClassLoader().getResourceAsStream("resources/database.properties");
            prop.load(dbProps);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("pass"));
    }
}
