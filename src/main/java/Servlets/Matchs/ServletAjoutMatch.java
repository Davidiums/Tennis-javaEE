package Servlets.Matchs;

import beans.*;
import dao.Interfaces.EpreuveDAO;
import dao.Interfaces.MatchsDAO;
import dao.Interfaces.PlayerDAO;
import dao.Interfaces.TournoiDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static dao.Interfaces.SessionUtils.isUserAdmin;
import static dao.Interfaces.SessionUtils.isUserLoggedIn;

@WebServlet(name = "ServletAjoutMatch", value = "/AjoutMatch")
public class ServletAjoutMatch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User logedUser = (User) session.getAttribute("user");
        if (logedUser == null) {
            response.sendRedirect("Login");
        } else if (logedUser.getProfil() != 1) {
            response.sendRedirect("Matchs");
        } else if (logedUser.getProfil() == 1) {
            TournoiDAO tournoiDao = new TournoiDAO();
            PlayerDAO playerDao = new PlayerDAO();
            List<Tournoi> tournois = tournoiDao.getAllTournoi();
            List<Integer> annees = new ArrayList<>();
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            for (int i = currentYear; i >= 2000; i--) {
                annees.add(i);
            }
            List<String> types = Arrays.asList("H", "F");
            List<Player> joueurs = playerDao.lister();
            request.setAttribute("tournois", tournois);
            request.setAttribute("annees", annees);
            request.setAttribute("types", types);
            request.setAttribute("joueurs", joueurs);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Views/AjoutMatch.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (isUserAdmin(request)) {
            long idTournoi = Long.parseLong(request.getParameter("tournoi"));
            int annee = Integer.parseInt(request.getParameter("annee"));
            String type = request.getParameter("type");
            long idVainqueur = Long.parseLong(request.getParameter("vainqueur"));
            long idFinaliste = Long.parseLong(request.getParameter("finaliste"));

            EpreuveDAO epreuveDAO = new EpreuveDAO();
            long idEpreuve = epreuveDAO.ajouter(idTournoi, annee, type);

            MatchsDAO matchDAO = new MatchsDAO();
            matchDAO.ajouter(idEpreuve, idVainqueur, idFinaliste);
            response.sendRedirect("Matchs");
        }else {
            response.sendRedirect("Login");
        }

    }
}
