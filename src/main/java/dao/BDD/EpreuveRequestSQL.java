package dao.BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class EpreuveRequestSQL {
    private static final Connection conn = new DaoFactory("localhost:3306/tennis", "root", "").getConnection();
    public static long addEpreuve(int annee, String sexe, long idTournoi) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        long idEpreuve = -1;
        try {
            statement = conn.prepareStatement("INSERT INTO epreuve(ANNEE, TYPE_EPREUVE, ID_TOURNOI) VALUES (?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, annee);
            statement.setString(2, sexe);
            statement.setLong(3, idTournoi);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                idEpreuve = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Fermer le ResultSet, le PreparedStatement et la connexion
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return idEpreuve;
    }


    public static boolean addEpreuveMixte(int annee, long idTournoi){
        PreparedStatement statement = null;
        int nbModif = 0;
        try{
            statement = conn.prepareStatement("INSERT INTO epreuve(ANNEE, TYPE_EPREUVE, ID_TOURNOI) VALUES (?,?,?)");
            statement.setInt(1,annee);
            statement.setLong(3, idTournoi);
            statement.setString(2,"H");
            nbModif=statement.executeUpdate();
            statement.setString(2, "F");
            nbModif+=statement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nbModif>0;
    }

    public static ResultSet getAllEpreuveForTournoiAtYear(long id, long year){
        PreparedStatement statement = null;
        ResultSet rs = null;
        System.out.println(id);
        System.out.println(year);
        try{
            statement = conn.prepareStatement("SELECT * FROM epreuve WHERE ID_TOURNOI = ? AND ANNEE = ?");
            statement.setLong(1, id);
            statement.setLong(2,year);
            rs = statement.executeQuery();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public static boolean deleteEpreuve(long id) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM epreuve WHERE id = ?");
            statement.setLong(1, id);
            int rowsAffected = statement.executeUpdate();
            return (rowsAffected > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet getAllTournois(){
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            statement = conn.prepareStatement("SELECT * FROM epreuve ORDER BY ANNEE");
            rs = statement.executeQuery();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public static ResultSet getAllEpreuves(){
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            statement = conn.prepareStatement("SELECT * FROM epreuve");
            rs = statement.executeQuery();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

}
