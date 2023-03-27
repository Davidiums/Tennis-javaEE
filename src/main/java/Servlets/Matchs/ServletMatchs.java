package Servlets.Matchs;

import static dao.Interfaces.JsonFactory.convertListToJson;
import static dao.Interfaces.SessionUtils.isUserLoggedIn;

import beans.Epreuve;
import beans.Match;
import dao.Interfaces.EpreuveDAO;
import dao.Interfaces.MatchsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletMatchs", value = "/Matchs")
public class ServletMatchs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (isUserLoggedIn(request)) {
            String search = request.getParameter("search");
            MatchsDAO matchDAO = new MatchsDAO();
            List<Match> matchs = matchDAO.getAllMatch();
            if(search != null && !search.isEmpty()) {
                request.setAttribute("matchs", matchDAO.rechercher(search));
            } else {
                request.setAttribute("matchs", matchs);
            }
            this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Matchs.jsp").forward(request, response);
        }else{
            response.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MatchsDAO matchsDAO = new MatchsDAO();
        String jsonString = convertListToJson(matchsDAO.getMatchsByTournois(1, 2016));
        System.out.println(jsonString);

        // Définir le type de contenu de la réponse comme JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Envoyer la réponse JSON
        PrintWriter out = response.getWriter();
        out.print(jsonString);
        out.flush();
    }
}
