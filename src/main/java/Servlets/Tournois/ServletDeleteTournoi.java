package Servlets.Tournois;

import beans.User;
import dao.Interfaces.TournoiDAO;
import dao.Interfaces.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import static dao.Interfaces.JsonFactory.successReturn;

@WebServlet(name = "ServletDeleteTournoi", value = "/ServletDeleteTournoi")
@MultipartConfig
public class ServletDeleteTournoi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Tournois");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User logedUser = (User) session.getAttribute("user");
        Collection<Part> parts = request.getParts();
        String loginRequest = null;
        int id = 0;
        UserDAO userDAO = new UserDAO();
        TournoiDAO tournoiDAO = new TournoiDAO();

        for (Part part : parts) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
            if (part.getName().equals("id") && id == 0) {
                String idValue = reader.readLine();
                id = Integer.parseInt(idValue);
            }else if (part.getName().equals("login") && loginRequest == null) {
                loginRequest = reader.readLine();
            }
        }
        if (userDAO.checkAdminPermission(logedUser, loginRequest)) {
            if (tournoiDAO.deleteTournoi(id)) {
                successReturn(response);
            } else {
                response.sendError(500);
            }
        }
    }
}
