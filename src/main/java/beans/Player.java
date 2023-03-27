package beans;

import Exceptions.BeanException;
import dao.BDD.PlayerRequestSQL;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;


public class Player implements Comparable<Player> {
    private int id;
    private String nom;
    private String prenom;
    private String sexe;

    private static final TreeSet<Player> players =new TreeSet<>();

    public Player(int id, String nom, String prenom, String sexe) throws BeanException {
        this.id = id;
        this.sexe = sexe;
        setNom(nom);
        setPrenom(prenom);

    }

    public Player(String nom, String prenom, String sexe) throws BeanException {

        setNom(nom);
        setPrenom(prenom);
        this.sexe = sexe;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws BeanException {
        if(nom.length() > 20){
            throw new BeanException("Le nom ne peut pas depasser 20 caracteres");
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws BeanException {
        if(prenom.length() > 20) throw new BeanException("Le prénom ne peut pas dépasser 20 caractères");
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public static void initPlayers(){
        ResultSet rs = PlayerRequestSQL.getAllPlayer();
        try{
            while (rs.next()){
                Player player = new Player(rs.getInt("ID"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("SEXE"));
                players.add(player);
            }
        }
        catch (SQLException | BeanException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int compareTo(Player other) {
        return Integer.compare(this.id, other.id);
    }
    public static Player getPlayerById(long id){
        for (Player player : players) {
            if(player.getId() == id) return player;
        }
        return null;
    }

    public static void deletePlayerById(long id){
        players.removeIf(player -> player.getId() == id);
    }


    public String getFullname(){ //is used in the jsp
        return this.nom + " " + this.prenom;
    }

    public static TreeSet<Player> getAllPlayers() {
        return new TreeSet<>(players);
    }

    public static TreeSet<Player> getAllPlayersForModifications() {
        return players;
    }

    @Override
    public String toString() {
        return id+" "+nom+" "+prenom+" "+sexe;
    }
}
