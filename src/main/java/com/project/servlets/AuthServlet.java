package com.project.servlets;

import com.project.controllers.LoginController;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        LoginController loginController = new LoginController();
        String role = loginController.execute(request,response);

        if(role.equals("ADMIN")) {
            String adminURI = request.getContextPath() + "/views/admin_view/admin.jsp";
            response.sendRedirect(adminURI);
        } else if(role.equals("USER")) {
            String userURI = request.getContextPath() + "/views/main_window.html";
            response.sendRedirect(userURI);
        } else if(role.equals("MASTER")) {
            String masterURI = request.getContextPath() + "/views/master_view/master.jsp";
            response.sendRedirect(masterURI);
        } else {
            String notLogginedInUrl = request.getContextPath() + "/views/ErrorPages/ErrorNotLoggedIn.jsp";
            response.sendRedirect(notLogginedInUrl);
        }

    }

}
