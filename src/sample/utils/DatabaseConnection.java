package sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public Connection databaseLink;

    public Connection openConnection() {
        String url = "";
        String user = "";
        String password = "";

        try (java.io.InputStream input = new java.io.FileInputStream("config.properties")) {
            java.util.Properties prop = new java.util.Properties();
            prop.load(input);

            url = prop.getProperty("db.url");
            user = prop.getProperty("db.user");
            password = prop.getProperty("db.password");

        } catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        try {
            Class.forName("org.postgresql.Driver");
            databaseLink = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }

    public Connection closeConnection() {
        try {
            databaseLink.close();
        } catch (SQLException sqlE) {
            System.out.println("Error: " + sqlE.getMessage());
        }
        return databaseLink;
    }
}