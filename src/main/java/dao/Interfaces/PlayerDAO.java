package dao.Interfaces;

import Exceptions.BeanException;
import Exceptions.DaoException;
import beans.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static dao.BDD.PlayerRequestSQL.*;

public class PlayerDAO implements IPlayer {
     public List<Player> lister() {
        return new ArrayList<>(Player.getAll());
    }

    public List<Player> listerFemme() {
        return Player.getAll().stream().filter(player -> "F".equals(player.getSexe())).collect(Collectors.toList());
    }

    @Override
    public Player lecture(Long id) {
        return null;
    }

    @Override
    public void ajouterJoueur(Player nouveauJoueur) throws DaoException {
        if(addPlayer(nouveauJoueur.getNom(), nouveauJoueur.getPrenom(), nouveauJoueur.getSexe())) Player.initPlayers();
        else throw new DaoException("Erreur lors de l'ajout du joueur");
    }

    @Override
    public boolean updateJoueur(Player p) {
        if (updatePlayerSQL(p.getId(), p.getPrenom(), p.getNom(), p.getSexe())) {
            boolean found = false;
            for (Player player : Player.getAllPlayersForModifications()) {
                if (player.getId() == p.getId()) {
                    try {
                        player.setNom(p.getNom());
                        player.setPrenom(p.getPrenom());
                        player.setSexe(p.getSexe());
                        found = true;
                        break;
                    } catch (BeanException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return found;
        } else {
            return false;
        }
    }



    @Override
    public boolean deleteJoueur(Long id) {
        if(deletePlayer(id)){
            Player.getAllPlayersForModifications().removeIf(player -> player.getId() == id);
            return true;
        }else return false;
    }

    @Override
    public List<Player> rechercher(String txt) {
        return Player.getAll().stream().filter(player ->
                ((player.getNom()+" "+player.getPrenom()+" "+player.getId()).toUpperCase())
                        .contains((txt.toUpperCase())))
                .collect(Collectors.toList());
    }

    public List<Player> listerHomme() {
        return Player.getAll().stream().filter(player -> "H".equals(player.getSexe())).collect(Collectors.toList());
    }
}
