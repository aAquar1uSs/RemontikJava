package com.project.servlets;

import com.project.controllers.LoginController;
import com.project.controllers.LogoutController;
import com.project.controllers.RegistrationController;
import com.project.controllers.ControllerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Dispatcher extends HttpServlet {
    private static Logger logger = LogManager.getLogger(Dispatcher.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        ControllerService controllerService = new ControllerService(new LoginController(),
                new LogoutController(),
                new RegistrationController());


        String path = request.getServletPath();

        switch (path) {
            case "/authorization":
                controllerService.causeLoginController(request, response);
                break;
            case "/registration_page":
                response.sendRedirect(request.getContextPath() + "/views/registration.jsp");
                break;
            case "/signIn":
                controllerService.causeRegistrationController(request, response);
                break;
            case "/about_page":
                response.sendRedirect(request.getContextPath() + "/views/aboutPage.jsp");
                break;
            case "/contacts_page":

                break;
            case "/logout":
                controllerService.causeLogoutController(request, response);
                break;
        }
    }
}
