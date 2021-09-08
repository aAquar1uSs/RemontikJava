package com.project.servlets;

import com.project.controllers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Dispatcher extends HttpServlet {
    private static Logger logger = LogManager.getLogger(Dispatcher.class.getName());
    private ControllerService controllerService;


    public void init(ServletConfig config) throws ServletException {
       controllerService = new ControllerService(new LoginController(),
                new LogoutController(),
                new RegistrationController(),
                new OrderController());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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
            case "/set_order":
                controllerService.causeOrderController(request,response);
                break;
            case "/logout":
                controllerService.causeLogoutController(request, response);
                break;
        }
    }
}
