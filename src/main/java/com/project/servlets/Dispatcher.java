package com.project.servlets;

import com.project.controllers.LoginController;
import com.project.controllers.LogoutController;
import com.project.controllers.RegistrationController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class Dispatcher extends HttpServlet {
    private static Logger logger = LogManager.getLogger(Dispatcher.class.getName());
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();

        switch (path) {
            case "/authorization":
                LoginController loginController = new LoginController();
                loginController.execute(request,response);
                break;
            case "/registration_page":
                response.sendRedirect(request.getContextPath() + "/views/registration.jsp");
                break;
            case "/signIn":
                RegistrationController registrationController = new RegistrationController();
                try {
                    registrationController.execute(request,response);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                break;
            case "/about_page":
                response.sendRedirect(request.getContextPath() + "/views/aboutPage.jsp");
                break;
            case "/contacts_page":

                break;
            case "/logout":
                LogoutController logoutController = new LogoutController();
                try {
                    logoutController.execute(request,response);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                break;
        }
    }
}
