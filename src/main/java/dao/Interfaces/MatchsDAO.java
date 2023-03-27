package dao.Interfaces;

import beans.Match;
import dao.BDD.MatchRequestSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static dao.BDD.MatchRequestSQL.getMatchforTournoi;

public class MatchsDAO implements IMatchs{
    @Override
    public List<Object> getMatchsByTournois(long idTournoi, int year) {
        return new ArrayList<>(Match.getAllMatch());
    }


    public List<Match> getAllMatch(){
        return new ArrayList<>(Match.getAllMatch());
    }

    public List<Match> filtre(){
        return null;
    }
}
