package Servlets.Users;

import beans.User;
import dao.Interfaces.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

@WebServlet(name = "ServletUpdateUser", value = "/ServletUpdateUser")
@MultipartConfig
public class ServletUpdateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'utilisateur connecté
        HttpSession session = request.getSession(false);
        User logedUser = (User) session.getAttribute("user");
        UserDAO userDao = new UserDAO();
        Collection<Part> parts = request.getParts();
        String loginRequest = null;
        int id = 0;
        String login = null;
        String mdp = null;
        int role = 2;

        for (Part part : parts) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
            if (part.getName().equals("id") && id == 0) {
                String idValue = reader.readLine();
                id = Integer.parseInt(idValue);
            } else if (part.getName().equals("newlogin") && login == null) {
                login = reader.readLine();
            } else if (part.getName().equals("mdp") && mdp == null) {
                mdp = reader.readLine();
            } else if (part.getName().equals("login") && loginRequest == null) {
                loginRequest = reader.readLine();
            }else if (part.getName().equals("role") && loginRequest == null) {
                String roleValue = reader.readLine();
                role = Integer.parseInt(roleValue);
            }
        }

            if (userDao.checkAdminPermission(logedUser, loginRequest)) {
                if (userDao.updateUser(id, login, mdp, role)) {
                    JSONObject result = new JSONObject();
                try {
                    result.put("updated", true);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(result.toString());
                } catch (JSONException e) {

                    throw new RuntimeException(e);
                }
            }else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}