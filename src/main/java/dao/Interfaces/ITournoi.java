package dao.Interfaces;

import beans.Tournoi;

import java.util.List;

public interface ITournoi {
    boolean updateTournoi(Tournoi tournoi);

    boolean addTournoi(Tournoi tournoi);

    boolean deleteTournoi(long id);

    List<Tournoi> getAllTournoi();
}
