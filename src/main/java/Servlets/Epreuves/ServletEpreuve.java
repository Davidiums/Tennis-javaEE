package Servlets.Epreuves;

import beans.Epreuve;
import beans.Tournoi;
import dao.Interfaces.EpreuveDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

import static dao.Interfaces.SessionUtils.isUserLoggedIn;

@WebServlet(name = "ServletEpreuve", value = "/Epreuves")
public class ServletEpreuve extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (isUserLoggedIn(request)){
            String search = request.getParameter("search");
            EpreuveDAO epreuveDAO = new EpreuveDAO();
            List<Epreuve> epreuves = epreuveDAO.lister();
            if(search != null && !search.isEmpty()) {
                request.setAttribute("epreuves", epreuveDAO.rechercher(search));
            } else {
                request.setAttribute("epreuves", epreuves);
            }
                this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Epreuves.jsp").forward(request, response);
        }else{
            response.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
