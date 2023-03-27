package dao.Interfaces;

import beans.Match;

import java.util.List;

public interface IMatchs {
     List<Object> getMatchsByTournois(long idTournoi, int year);

     List<Match> getAllMatch();

     List<Match> filtre();
}
