package com.project.servlets;

import com.project.controllers.LoginController;
import com.project.controllers.RegistrationController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class Dispatcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();

        switch (path) {
            case "/authorization":
                LoginController loginController = new LoginController();
                String role = loginController.execute(request,response);
                getPageForRole(role,request,response);
                break;
            case "/registration_page":
                response.sendRedirect(request.getContextPath() + "/views/registration.jsp");
                break;
            case "/signIn":
                RegistrationController registrationController = new RegistrationController();
                try {
                    registrationController.execute(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
        }
    }

    private void getPageForRole(String role,HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(role.equals("ADMIN")) {
            String adminURI = request.getContextPath() + "/views/admin_view/admin.jsp";
            response.sendRedirect(adminURI);
        } else if(role.equals("USER")) {
            String userURI = request.getContextPath() + "/views/main_window.jsp";
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
