package beans;

import dao.BDD.EpreuveRequestSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import static beans.Tournoi.getTournoiById;
import static beans.Tournoi.initTournois;
import static dao.BDD.EpreuveRequestSQL.getAllEpreuves;

public class Epreuve implements Comparable<Epreuve>{
    private long id;
    private int annee;
    private String type;

    private Tournoi tournoi;

    private static TreeSet<Epreuve> epreuves;

    public Epreuve(long id, long idTournoi, int annee, String type) {
        this.id = id;
        this.tournoi = getTournoiById(idTournoi);
        this.annee = annee;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public long getIdTournoi() {
        return tournoi.getId();
    }

    public int getAnnee() {
        return annee;
    }

    public String getType() {
        return type;
    }

    public static void initEpreuves(){
        initTournois();
        TreeSet<Epreuve> newEpreuves = new TreeSet<>();
        ResultSet rs = EpreuveRequestSQL.getAllEpreuves();
        try {
            while (rs.next()) {
                Epreuve epreuve = new Epreuve(rs.getLong("ID"), rs.getLong("ID_TOURNOI"), rs.getInt("ANNEE"), rs.getString("TYPE_EPREUVE"));
                newEpreuves.add(epreuve);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        epreuves = newEpreuves;
    }

    public static TreeSet<Epreuve> getAllEpreuves(){
        return epreuves;
    }

    @Override
    public String toString() {
        return "Epreuve{" +
                "id=" + id +
                ", annee=" + annee +
                ", type='" + type + '\'' +
                ", tournoi=" + tournoi +
                '}';
    }


    @Override
    public int compareTo(Epreuve other) {
        if (this.id < other.id) {
            return -1;
        } else if (this.id > other.id) {
            return 1;
        } else {
            return 0;
        }
    }

    public static Epreuve getEpreuveById(long id){
        for (Epreuve epreuve : epreuves) {
            if (epreuve.getId() == id) {
                return epreuve;
            }
        }
        return null;
    }

    public Tournoi getTournoi() {
        return tournoi;
    }


}
