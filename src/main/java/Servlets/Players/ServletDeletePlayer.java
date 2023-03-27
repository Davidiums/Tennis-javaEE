package Servlets.Players;

import beans.User;
import dao.Interfaces.PlayerDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import static dao.Interfaces.JsonFactory.successReturn;


@WebServlet(name = "ServletDeletePlayer", value = "/ServletDeletePlayer")
@MultipartConfig
public class ServletDeletePlayer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("ListJoueur");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Collection<Part> parts = request.getParts();
        String loginRequest = null;
        Long id = null;

        for (Part part : parts) {
            if (part.getName().equals("id")) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
                String idValue = reader.readLine();
                id = Long.parseLong(idValue);
            } else if (part.getName().equals("login")) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
                loginRequest = reader.readLine();
            }
        }

        if (id != null && loginRequest != null && session != null && session.getAttribute("user") != null && ((User) session.getAttribute("user")).getProfil() == 1) {
            String loginSession = ((User) session.getAttribute("user")).getLogin();
            if (loginRequest.equals(loginSession)) {
                PlayerDAO player = new PlayerDAO();
                if (player.deleteJoueur(id)) successReturn(response);
                else response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

}
