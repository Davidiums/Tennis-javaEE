//package Servlets;
//
//import beans.MenuItem;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(name = "ServletMenu", value = "/ServletMenu")
//public class ServletMenu extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        List<MenuItem> menuItems = new ArrayList<>();
//        menuItems.add(new MenuItem("Joueurs", "/Views/ListJoueur"));
//        menuItems.add(new MenuItem("Tournois", "/Views/Tournois"));
//
//        String currentPageURI = request.getRequestURI();
//        for (MenuItem menuItem : menuItems) {
//            if (currentPageURI.endsWith(menuItem.getUrl())) {
//                menuItems.remove(menuItem);
//                menuItems.add(0, menuItem);
//                break;
//            }
//        }
//        request.setAttribute("menuItems", menuItems);
//        request.getRequestDispatcher("/WEB-INF/Views/Menu.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
