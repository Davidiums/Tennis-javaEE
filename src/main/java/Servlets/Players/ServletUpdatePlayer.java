package Servlets.Players;

import Exceptions.BeanException;
import beans.Player;
import beans.User;
import dao.Interfaces.PlayerDAO;
import dao.Interfaces.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import static dao.Interfaces.JsonFactory.successReturn;

@WebServlet(name = "ServletUpdatePlayer", value = "/ServletUpdatePlayer")
@MultipartConfig
public class ServletUpdatePlayer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("ListJoueur");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User logedUser = (User) session.getAttribute("user");
        Collection<Part> parts = request.getParts();
        String loginRequest = null;
        int id = 0;
        String nom = null;
        String prenom = null;
        String sexe = null;
        UserDAO userDAO = new UserDAO();

        for (Part part : parts) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
            if (part.getName().equals("id") && id == 0) {
                String idValue = reader.readLine();
                id = Integer.parseInt(idValue);
            } else if (part.getName().equals("nom") && nom == null) {
                nom = reader.readLine();
            } else if (part.getName().equals("prenom") && prenom == null) {
                prenom = reader.readLine();
            } else if (part.getName().equals("sexe") && sexe == null) {
                sexe = reader.readLine();
            } else if (part.getName().equals("login") && loginRequest == null) {
                loginRequest = reader.readLine();
            }
        }
            if (userDAO.checkAdminPermission(logedUser, loginRequest)) {
                Player player = null;
                try {
                    player = new Player(id, nom, prenom, sexe);
                    PlayerDAO playerDAO = new PlayerDAO();
                    if(playerDAO.updateJoueur(player)){
                        successReturn(response);
                    }else {
                        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    };
                } catch (BeanException e) {
                    request.setAttribute("exception", e);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Error.jsp");
                }
            }else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
    }