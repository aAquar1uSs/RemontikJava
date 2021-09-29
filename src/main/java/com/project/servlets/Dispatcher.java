package com.project.servlets;

import com.project.constants.UrlConstants;
import com.project.controllers.*;
import com.project.service.ControllerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Dispatcher extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(Dispatcher.class.getName());
    private ControllerService controllerService;


    public void init(ServletConfig config) throws ServletException {
        controllerService = new ControllerService(new LoginController(),
                new LogoutController(),
                new RegistrationController(),
                new OrderController(),
                new AccountController(),
                new DeleteUserController());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();

        switch (path) {
            case "/main":
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher(UrlConstants.MAIN_WINDOW_URL);
                dispatcher.forward(request, response);
                break;
            case "/authorization":
                controllerService.causeLoginController(request, response);
                break;
            case "/registration_page":
                request.getRequestDispatcher(UrlConstants.REGISTRATION_PAGE_URL).forward(request,response);
                break;
            case "/about_page":
                request.getRequestDispatcher(UrlConstants.ABOUT_US_PAGE).forward(request,response);
                break;
            case "/contacts_page":
                request.getRequestDispatcher(UrlConstants.CONTACTS_PAGE_URL).forward(request,response);
                break;
            case "/private_account":
                controllerService.causeAccountController(request,response);
                break;
            case "/logout":
                controllerService.causeLogoutController(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        switch (path) {
            case "/signIn":
                controllerService.causeRegistrationController(request, response);
                break;
            case "/set_order":
                controllerService.causeOrderController(request, response);
                break;
            case "/delete_users":
                controllerService.causeDeleteUserController(request,response);
                break;
        }

    }
}
