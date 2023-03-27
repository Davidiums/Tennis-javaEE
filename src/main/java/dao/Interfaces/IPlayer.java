package dao.Interfaces;
import Exceptions.DaoException;
import beans.Player;

import java.util.List;


public interface IPlayer {


    List <Player> lister() throws DaoException;
    List <Player> listerHomme() throws DaoException;
    List <Player> listerFemme() throws DaoException;

    Player lecture(Long id);
    void ajouterJoueur(Player nouveauJoueur) throws DaoException;
    boolean updateJoueur(Player p);
    boolean deleteJoueur(Long id);

    List <Player> rechercher(String txt);
}