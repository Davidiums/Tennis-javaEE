package beans;

import dao.BDD.TournoisRequestSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Tournoi implements Comparable<Tournoi> {
    @Override
    public int compareTo(Tournoi other) {
        if (this.id < other.id) {
            return -1;
        } else if (this.id > other.id) {
            return 1;
        } else {
            return 0;
        }
    }

    private String nom, code;
    private int id;

    private static TreeSet<Tournoi> tournois;

    public Tournoi(String nom, String code, int id) {
        this.nom = nom;
        this.code = code;
        this.id = id;
    }

    public Tournoi(String code, String nom) {
        this.nom = nom;
        this.code = code;
    }

    public static List<Tournoi> getAllTournoi() {
        List<Tournoi> tournois = new ArrayList<>();
        try {
            ResultSet rs = TournoisRequestSQL.getAllTournois();
            while (rs.next()) {
                Tournoi tournoi = new Tournoi(rs.getString("NOM"), rs.getString("CODE"), rs.getInt("ID"));
                tournois.add(tournoi);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tournois;
    }

    public static void initTournois(){
        TreeSet<Tournoi> newTournois = new TreeSet<>();
        ResultSet rs = TournoisRequestSQL.getAllTournois();
        try {
            while (rs.next()) {
                Tournoi tournoi = new Tournoi(rs.getString("NOM"), rs.getString("CODE"), rs.getInt("ID"));
                newTournois.add(tournoi);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tournois = newTournois;
    }

    public static TreeSet<Tournoi> getAllTournois(){
        return tournois;
    }

    public static Tournoi getTournoiById(long id){
        for (Tournoi tournoi : tournois) {
            if (tournoi.getId() == id) {
                return tournoi;
            }
        }
        return null;
    }

    public String getNom() {
        return nom;
    }

    public String getCode() {
        return code;
    }

    public int getId() {
        return id;
    }
}
