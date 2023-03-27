package dao.Interfaces;

import beans.User;
import dao.BDD.UserSQL;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserDAO implements IUser{
    @Override
    public Boolean checkAdmin(User user) {
        return user.getProfil() == 1;
    }

    @Override
    public boolean checkAdminPermission(User sessionUser, String loginRequested) {
        return sessionUser.getLogin().equals(loginRequested) && checkAdmin(sessionUser);
    }

    public boolean checkPassword(String password, String login){
        String currentPassword = UserSQL.getPassword(login);
        return BCrypt.checkpw(password, currentPassword);
    }

    public boolean updateUser(int id, String login, String password, int profil){
        if(password.length()>0) return UserSQL.updateUser(id, login, User.hashPassword(password), profil);
        else return UserSQL.updateUser(id, login, profil);
    }

    @Override
    public boolean deleteUser(int id) {
        return UserSQL.deleteUser(id);
    }

    public List<User> getAllUsers(){
        return UserSQL.getAllUsers();
    }
}
