package dao.BDD;

import beans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class UserSQL {
    private static final Connection conn = new DaoFactory("localhost:3306/tennis", "root", "").getConnection();

    public static void addUser(String login, String password, int profil){
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("INSERT INTO connexion(login, password, profil) VALUES (?,?,?)");
            statement.setString(1,login);
            statement.setString(2,password);
            statement.setInt(3,profil);
            statement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> getAllUsers(){
        Statement statement = null;
        List<User> users = new ArrayList<>();
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, login, profil FROM connexion");
            while (rs.next()) { // Déplace le curseur sur la première ligne de résultats
                User user = new User(rs.getInt("id"), rs.getInt("profil"), rs.getString("login"), "********");
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public static String getPassword(String login) {
        PreparedStatement statement = null;
        String password = null;
        try {
            statement = conn.prepareStatement("SELECT password FROM connexion WHERE login = ?");
            statement.setString(1,login);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) { // Déplace le curseur sur la première ligne de résultats
                password = rs.getString("password"); // Récupère la valeur de la colonne "password"
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return password;
    }

    public static boolean loginExist(String login){
        PreparedStatement statement = null;
        boolean exist = false;
        try {
            statement = conn.prepareStatement("SELECT login FROM connexion WHERE login = ?");
            statement.setString(1,login);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) { // Déplace le curseur sur la première ligne de résultats
                exist = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exist;
    }
    public static int getProfil(String login){
        PreparedStatement statement = null;
        int profil = 0;
        try {
            statement = conn.prepareStatement("SELECT profil FROM connexion WHERE login = ?");
            statement.setString(1,login);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) { // Déplace le curseur sur la première ligne de résultats
                profil = rs.getInt("profil"); // Récupère la valeur de la colonne "password"
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return profil;
    }

    public static boolean updateUser(long id, String login, String password,int profil){
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("UPDATE connexion SET login = ?, password = ?, profil = ? WHERE id = ?");
            statement.setString(1,login);
            statement.setString(2,password);
            statement.setInt(3,profil);
            statement.setLong(4,id);
            statement.executeUpdate();
            if (statement.executeUpdate() > 0) {
                return true;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static boolean updateUser(long id, String login,int profil){
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("UPDATE connexion SET login = ?, profil = ? WHERE id = ?");
            statement.setString(1,login);
            statement.setInt(2,profil);
            statement.setLong(3,id);
            statement.executeUpdate();
            if (statement.executeUpdate() > 0) {
                return true;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static boolean deleteUser(int id) {
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("DELETE FROM connexion WHERE id = ?");
            statement.setInt(1,id);
            statement.executeUpdate();
            if (statement.executeUpdate() > 0) {
                return true;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
