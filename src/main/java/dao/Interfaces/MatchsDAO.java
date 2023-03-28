package dao.Interfaces;

import beans.Match;
import dao.BDD.MatchRequestSQL;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static dao.Interfaces.Utils.initData;

public class MatchsDAO implements IMatchs{
    @Override
    public List<Object> getMatchsByTournois(long idTournoi, int year) {
        return new ArrayList<>(Match.getAll());
    }


    public List<Match> getAllMatch(){
        return new ArrayList<>(Match.getAll());
    }

    public List<Match> filtre(){
        return null;
    }

    @Override
    public void ajouter(long idEpreuve, long vainqueur, long finaliste) {
        MatchRequestSQL.addMatch(idEpreuve, vainqueur, finaliste);
        initData();
    }

    @Override
    public List<Match> rechercher(String txt) {
        return Match.getAll().stream().filter(match ->
                        (match.toString().toUpperCase()).contains((txt.toUpperCase())))
                .collect(Collectors.toList());
    }
}
