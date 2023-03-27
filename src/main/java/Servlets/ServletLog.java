package Servlets;

import Exceptions.InvalidPasswordException;
import beans.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import static dao.Interfaces.SessionUtils.isUserLoggedIn;
import static dao.Interfaces.Utils.initData;

@WebServlet(name = "ServletLog", value = "/Login")
public class ServletLog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(isUserLoggedIn(request)){
            response.sendRedirect("ListJoueur");
        }else{
        this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Log.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("txtLogin");
        String password = request.getParameter("txtPassword");
        try {
            User user = new User(login,password);
            if(user.exist()){
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute("user", user);
                initData();
                response.sendRedirect("ListJoueur");
            }else{
                response.sendRedirect("SignUp");
            };

        } catch (InvalidPasswordException e) {
            response.sendRedirect("SignUp");
        }
    }
}
