package Servlets.Players;

import beans.Player;
import beans.User;
import dao.Interfaces.PlayerDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

import static dao.Interfaces.SessionUtils.isUserLoggedIn;

@WebServlet(name = "ServletListJoueur", value = "/ListJoueur")
public class ServletListJoueur extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (isUserLoggedIn(request)) {
            PlayerDAO player = new PlayerDAO();
            String search = request.getParameter("search");
            if(search != null && !search.isEmpty()) {
                request.setAttribute("joueurs", player.rechercher(search));
            } else {
                request.setAttribute("joueurs", player.lister());
                request.setAttribute("LesDeuxChecked", "checked");
            }
            this.getServletContext().getRequestDispatcher("/WEB-INF/Views/ListJoueur.jsp").forward(request,response);
        } else {
            response.sendRedirect("Login");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlayerDAO player = new PlayerDAO();
        String sexe = request.getParameter("sexe");
        if (sexe.equals("H")) {
            request.setAttribute("HommesChecked", "checked");
            List<Player> joueurs = player.listerHomme();
            request.setAttribute("joueurs", joueurs);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Views/ListJoueur.jsp").forward(request,response);
        }
        else if (sexe.equals("F")) {
            request.setAttribute("FemmesChecked", "checked");
            List<Player> joueurs = player.listerFemme();
            request.setAttribute("joueurs", joueurs);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Views/ListJoueur.jsp").forward(request,response);
        }
        else {
            request.setAttribute("LesDeuxChecked", "checked");
            List<Player> joueurs = player.lister();
            request.setAttribute("joueurs", joueurs);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Views/ListJoueur.jsp").forward(request,response);
        }

    }
}
