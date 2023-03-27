package dao.Interfaces;

import beans.Epreuve;

import java.util.List;

public interface IEpreuve {
    public List<Epreuve> lister();
    public long ajouter(long idTournoi, int annee, String type);
}
