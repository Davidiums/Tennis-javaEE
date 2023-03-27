package Tests;

import beans.Match;
import beans.Player;

import static beans.Epreuve.getAllEpreuves;
import static beans.Epreuve.initEpreuves;
import static beans.Match.initMatchs;
import static beans.Player.initPlayers;
import static beans.Tournoi.getAllTournoi;
import static beans.Tournoi.initTournois;

public class TestEpreuve {
    public static void main(String[] args) {
        initTournois();
        System.out.println(getAllTournoi());

        initEpreuves();
        System.out.println(getAllEpreuves());

        initPlayers();
        System.out.println(Player.getAllPlayers());

        initMatchs();
        System.out.println(Match.getAllMatchs());
    }
}
