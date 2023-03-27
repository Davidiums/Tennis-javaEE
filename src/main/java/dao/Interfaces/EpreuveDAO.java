package dao.Interfaces;

import beans.Epreuve;
import beans.Player;
import beans.Tournoi;
import dao.BDD.EpreuveRequestSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import static beans.Epreuve.addEpreuve;
import static dao.BDD.EpreuveRequestSQL.getAllTournois;

public class EpreuveDAO implements IEpreuve{

    @Override
    public List<Epreuve> lister() {
        return new ArrayList<>(Epreuve.getAllEpreuves());
    }

    @Override
    public long ajouter(long idTournoi, int annee, String type) {
        long idEpreuve = EpreuveRequestSQL.addEpreuve(annee, type, idTournoi);
        addEpreuve( new Epreuve(idEpreuve, idTournoi, annee, type));
        return idEpreuve;
    }

    @Override
    public List<Epreuve> rechercher(String txt) {
        return Epreuve.getAllEpreuves().stream().filter(epreuve ->
                        (epreuve.toString().toUpperCase()).contains((txt.toUpperCase())))
                .collect(Collectors.toList());
    }
}
