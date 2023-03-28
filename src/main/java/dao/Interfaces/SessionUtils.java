package dao.Interfaces;

import beans.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public abstract class SessionUtils {
    public static boolean isUserLoggedIn(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        return (session != null && session.getAttribute("user") != null);
    }

    public static boolean isUserAdmin(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        return (session != null && session.getAttribute("user") != null && ((User) session.getAttribute("user")).getProfil() == 1);
    }
}
