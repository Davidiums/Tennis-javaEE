package beans;

import dao.BDD.MatchRequestSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Match implements Comparable<Match> {
     private long id;
     private Epreuve epreuve;
     private Player finaliste, vainqueur;
     private static TreeSet<Match> matches;

        public Match(long id, long id_epreuve, long finaliste, long vainqueur) {
            this.id = id;
            this.epreuve = Epreuve.getEpreuveById(id_epreuve);
            this.finaliste = Player.getPlayerById(finaliste);
            this.vainqueur = Player.getPlayerById(vainqueur);
        }

        public static void initMatchs(){
            ResultSet rs = MatchRequestSQL.getAllMatch();
            TreeSet<Match> newMatchs = new TreeSet<>();
            try {
                while (rs.next()) {
                    Match match = new Match(rs.getLong("ID"), rs.getLong("id_Epreuve"), rs.getLong("ID_Finaliste"), rs.getLong("ID_Vainqueur"));
                    newMatchs.add(match);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            matches = newMatchs;
        }

        public static TreeSet<Match> getAllMatchs(){
            return matches;
        }

        public static Match getMatchById(long id){
            for(Match match : matches){
                if(match.getId() == id){
                    return match;
                }
            }
            return null;
        }

    public long getId() {
        return id;
    }

    @Override
    public int compareTo(Match other) {
        if (this.id < other.id) {
            return -1;
        } else if (this.id > other.id) {
            return 1;
        } else {
            return 0;
        }
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public Player getFinaliste() {
        return finaliste;
    }

    public Player getVainqueur() {
        return vainqueur;
    }

    public static TreeSet<Match> getAllMatch(){
        return matches;
    }
}
