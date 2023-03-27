package dao.Interfaces;

import beans.Epreuve;
import beans.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static dao.BDD.EpreuveRequestSQL.getAllTournois;

public class EpreuveDAO implements IEpreuve{

    @Override
    public List<Epreuve> lister() {
        return new ArrayList<>(Epreuve.getAllEpreuves());
    }
}
