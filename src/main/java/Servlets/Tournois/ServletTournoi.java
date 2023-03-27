package Servlets.Tournois;

import beans.Tournoi;
import beans.User;
import dao.Interfaces.TournoiDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static dao.Interfaces.SessionUtils.isUserLoggedIn;

@WebServlet(name = "ServletTournoi", value = "/Tournois")
public class ServletTournoi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isUserLoggedIn(request)){
            String search = request.getParameter("search");
            TournoiDAO tournoiDAO = new TournoiDAO();
            List<Tournoi> tournois = tournoiDAO.getAllTournoi();
            if(search != null && !search.isEmpty()) {
                request.setAttribute("tournois", tournoiDAO.rechercher(search));
            } else {
                request.setAttribute("tournois", tournois);
            }
                this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Tournoi.jsp").forward(request, response);
        }else{
            response.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User logedUser = (User) session.getAttribute("user");
        Collection<Part> parts = request.getParts();
        String loginRequest = null;
        int id = 0;
    }
}
