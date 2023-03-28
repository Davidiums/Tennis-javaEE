package dao.Interfaces;

import beans.Epreuve;
import dao.BDD.EpreuveRequestSQL;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import static beans.Epreuve.addEpreuve;

public class EpreuveDAO implements IEpreuve{

    @Override
    public List<Epreuve> lister() {
        return new ArrayList<>(Epreuve.getAll());
    }

    @Override
    public long ajouter(long idTournoi, int annee, String type) {
        long idEpreuve = EpreuveRequestSQL.addEpreuve(annee, type, idTournoi);
        addEpreuve( new Epreuve(idEpreuve, idTournoi, annee, type));
        return idEpreuve;
    }

    @Override
    public List<Epreuve> rechercher(String txt) {
        return Epreuve.getAll().stream().filter(epreuve ->
                        (epreuve.toString().toUpperCase()).contains((txt.toUpperCase())))
                .collect(Collectors.toList());
    }
}
