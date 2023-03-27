package Servlets.Users;

import beans.User;
import dao.Interfaces.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletUtilisateurs", value = "/Utilisateurs")
@MultipartConfig
public class ServletUtilisateurs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User logedUser = (User) session.getAttribute("user");
        if (logedUser == null) {
            response.sendRedirect("Login");
        } else if (logedUser.getProfil() != 1) {
            response.sendRedirect("Tournois");
        } else if (logedUser.getProfil() == 1) {
            UserDAO userDao = new UserDAO();
            List<User> users = userDao.getAllUsers();
            request.setAttribute("utilisateurs", users);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Views/UtilisateurAdmin.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
