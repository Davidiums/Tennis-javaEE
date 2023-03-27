package Servlets.Tournois;

import beans.Tournoi;
import beans.User;
import dao.Interfaces.TournoiDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAjoutTournoi", value = "/AjoutTournoi")
public class ServletAjoutTournoi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User logedUser = (User) session.getAttribute("user");
        if (logedUser == null) {
            response.sendRedirect("Login");
        } else if (logedUser.getProfil() != 1) {
            response.sendRedirect("Tournois");
        } else if (logedUser.getProfil() == 1) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/Views/AjouterTournoi.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("txtcode");
        String nom = request.getParameter("txtnom");
        Tournoi tournoi = new Tournoi(code, nom);
        TournoiDAO tournoiDAO = new TournoiDAO();
        if(tournoiDAO.addTournoi(tournoi)){
            response.sendRedirect("Tournois");
        }
        else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/Views/ajouterTournoi.jsp");
        }

    }
}
