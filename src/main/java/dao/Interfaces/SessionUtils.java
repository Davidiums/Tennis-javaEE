package dao.Interfaces;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public abstract class SessionUtils {
    public static boolean isUserLoggedIn(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        return (session != null && session.getAttribute("user") != null);
    }
}
