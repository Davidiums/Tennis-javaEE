package Servlets;

import beans.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import static dao.Interfaces.SessionUtils.isUserLoggedIn;

@WebServlet(name = "ServletSignUp", value = "/SignUp")
public class ServletSignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(isUserLoggedIn(request)){
            response.sendRedirect("ListJoueur");
        }else{
            this.getServletContext().getRequestDispatcher("/WEB-INF/Views/SignUp.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("txtLogin");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirmPassword");
        System.out.println("oui");
        try {
            User user = new User(login,password,confirm);
            response.sendRedirect("Login");
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
