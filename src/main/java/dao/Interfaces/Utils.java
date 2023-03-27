package dao.Interfaces;

import beans.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static beans.Epreuve.initEpreuves;
import static beans.Match.initMatchs;
import static beans.Player.initPlayers;
import static beans.Tournoi.initTournois;

public abstract class Utils {
    public static void initData(){
        initTournois();
        initEpreuves();
        initPlayers();
        initMatchs();
    }
}
