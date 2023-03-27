package dao.Interfaces;

import beans.Epreuve;
import beans.Player;

import java.util.List;

public interface IEpreuve {
    public List<Epreuve> lister();
    public long ajouter(long idTournoi, int annee, String type);
    List <Epreuve> rechercher(String txt);
}
