package Servlets.Players;

import Exceptions.BeanException;
import Exceptions.DaoException;
import beans.Player;
import beans.User;
import dao.Interfaces.PlayerDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import static dao.Interfaces.SessionUtils.isUserAdmin;

@WebServlet(name = "ServletAjouterJoueur", value = "/AjouterJoueur")
public class ServletAjouterJoueur extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User logedUser = (User) session.getAttribute("user");
        if (logedUser == null) {
            response.sendRedirect("Login");
        } else if (logedUser.getProfil() != 1) {
            response.sendRedirect("ListJoueur");
        } else if (logedUser.getProfil() == 1) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/Views/AjouterJoueur.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(isUserAdmin(request)){
            String nom = request.getParameter("txtNom");
            String prenom = request.getParameter("txtPrenom");
            String sexe = request.getParameter("opSexe");
            if (!nom.isEmpty() && !prenom.isEmpty() && !sexe.isEmpty()){
                PlayerDAO playerDAO = new PlayerDAO();
                try {
                    Player player = new Player(nom, prenom, sexe);
                    playerDAO.ajouterJoueur(player);
                    response.sendRedirect("ListJoueur");
                } catch (DaoException | BeanException e) {
                    request.setAttribute("exception", e);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Error.jsp").forward(request,response);
                }
            }
            else {
                this.getServletContext().getRequestDispatcher("AjouterJoueur");
            }
        }
    }
}
