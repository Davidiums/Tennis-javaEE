package dao.BDD;
import java.sql.*;


public class DaoFactory {
    String url, username, password;

    public DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://"+url+"?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", username, password);
        } catch (SQLException e) {
            System.out.println("Failed to create the database connection.");
            throw new RuntimeException(e);
        }

        return conn;
    }


}
