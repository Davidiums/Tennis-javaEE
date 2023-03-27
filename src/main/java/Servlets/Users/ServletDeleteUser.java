package Servlets.Users;

import beans.User;
import dao.Interfaces.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

import static dao.Interfaces.JsonFactory.successReturn;

@WebServlet(name = "ServletDeleteUser", value = "/ServletDeleteUser")
@MultipartConfig
public class ServletDeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User logedUser = (User) session.getAttribute("user");
        Collection<Part> parts = request.getParts();
        String loginRequest = null;
        int id = 0;
        UserDAO userDAO = new UserDAO();

        for (Part part : parts) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), StandardCharsets.UTF_8));
            if (part.getName().equals("id") && id == 0) {
                String idValue = reader.readLine();
                id = Integer.parseInt(idValue);
            }else if (part.getName().equals("login") && loginRequest == null) {
                loginRequest = reader.readLine();
            }
        }
        if (userDAO.checkAdminPermission(logedUser, loginRequest)) {
            if (userDAO.deleteUser(id)) {
                successReturn(response);
            } else {
                response.sendError(500);
            }
        }
    }
}
