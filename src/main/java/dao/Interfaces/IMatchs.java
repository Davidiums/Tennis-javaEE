package dao.Interfaces;

import beans.Match;
import beans.Player;

import java.util.List;

public interface IMatchs {
     List<Object> getMatchsByTournois(long idTournoi, int year);

     List<Match> getAllMatch();

     List<Match> filtre();

     void ajouter(long idEpreuve, long vainqueur, long finaliste);

     List <Match> rechercher(String txt);
}
