package DAOs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static Connection connection;

    private ConnectionManager(){

    }

    public static Connection getConnection() {
        if (connection == null){
            connect();


        }
        return connection;

    }

    private static void connect(){
        Properties prop = new Properties();
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream input = loader.getResourceAsStream("jdbc.properties");
            //FileReader reader = new FileReader("/../resources/jdbc.properties");
            prop.load(input);


            String host = prop.getProperty("Host");
            String port = prop.getProperty("Port");
            String driver = prop.getProperty("Driver");
            String username = prop.getProperty("Username");
            String dbname = prop.getProperty("dbname");
            String password = prop.getProperty("password");

            Class.forName(driver);

            StringBuilder builder = new StringBuilder("jdbc:postgresql://");
            builder.append(host);
            builder.append(":");
            builder.append(port);
            builder.append("/");
            builder.append(dbname);
            builder.append("?user=");
            builder.append(username);
            builder.append("&password=");
            builder.append(password);
            builder.append("&currentschema=public");

            connection = DriverManager.getConnection(builder.toString());



        } catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

