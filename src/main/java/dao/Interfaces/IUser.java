package dao.Interfaces;

import beans.User;

import java.util.List;

public interface IUser {
    boolean checkPassword(String password, String login);

    Boolean checkAdmin(User user);

    boolean checkAdminPermission(User sessionUser, String loginRequested);
    boolean updateUser(int id, String login, String password, int profil);

    boolean deleteUser(int id);

    List<User> getAllUsers();
}
