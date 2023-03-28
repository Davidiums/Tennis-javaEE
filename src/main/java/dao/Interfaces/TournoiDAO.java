package dao.Interfaces;

import beans.Tournoi;
import dao.BDD.TournoisRequestSQL;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static dao.BDD.TournoisRequestSQL.*;

public class TournoiDAO implements ITournoi{
    @Override
    public boolean updateTournoi(Tournoi tournoi) {
        return modifyTournoi(tournoi.getNom(), tournoi.getCode(), tournoi.getId());
    }

    @Override
    public boolean addTournoi(Tournoi tournoi) {
        return TournoisRequestSQL.addTournoi(tournoi.getNom(), tournoi.getCode());
    }

    @Override
    public boolean deleteTournoi(long id) {
        return TournoisRequestSQL.deleteTournoi(id);
    }

    public List<Tournoi> getAllTournoi(){
        return new ArrayList<>(Tournoi.getAllTournoi());
    }

    @Override
    public List<Tournoi> rechercher(String txt) {
        return Tournoi.getAll().stream().filter(tournoi ->
                        (tournoi.toString().toUpperCase()).contains((txt.toUpperCase())))
                .collect(Collectors.toList());
    }
}
