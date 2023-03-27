package beans;


import Exceptions.InvalidPasswordException;
import dao.BDD.UserSQL;
import org.mindrot.jbcrypt.BCrypt;

import static dao.BDD.UserSQL.addUser;
import static dao.BDD.UserSQL.loginExist;

public class User {
    private int id, profil;
    private String login, password;

    public User(String login, String password) throws InvalidPasswordException{
            if (checkPassword(password, login)){
                this.login = login;
                this.profil = UserSQL.getProfil(login);
            } else {
                throw new InvalidPasswordException("Le mot de passe fourni n'est pas valide.");
            }
    }

    public User(int id, int profil, String login, String password) {
        this.id = id;
        this.profil = profil;
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String confirmPassword) throws InvalidPasswordException{
        if (password.equals(confirmPassword)){
            String hashedPassword = hashPassword(password);
            this.login = login;
            this.password = hashedPassword;
            if (!loginExist(login)) addUser(login, hashedPassword, 2);
        } else {
            throw new InvalidPasswordException("Les mots de passe ne correspondent pas.");
        }

    }

    private boolean checkPassword(String password, String login){
        String currentPassword = UserSQL.getPassword(login);
        return BCrypt.checkpw(password, currentPassword);
    }

    public static String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean exist(){
        return true;
    }
    public void creatUser(){
        addUser(login, hashPassword(password), profil);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", profil=" + profil +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getProfil() {
        return profil;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

}
