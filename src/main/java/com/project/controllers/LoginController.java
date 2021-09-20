package com.project.controllers;

import com.project.service.RoleService;
import com.project.service.SessionAndRequestService;
import com.project.service.UserService;
import com.project.utils.PasswordHashManager;
import com.project.utils.ValidationManager;
import com.sun.istack.internal.NotNull;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements Controller {
    private UserService userService;
    private RoleService roleService;
    private ValidationManager validationManager;

    public LoginController() {
        userService = new UserService();
        roleService = new RoleService();
        validationManager = new ValidationManager();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        @NotNull String email = request.getParameter("email");
        @NotNull String password = request.getParameter("pass");

        final String notLoggedInUrl = "/views/error_pages/ErrorNotLoggedIn.jsp";
        final String urlMainWindow = request.getContextPath() + "/views/main_window.jsp";

        if(!validationManager.isValidEmail(email) || !userService.searchUserByEmail(email)) {
            Cookie message = new Cookie("message", "Error");
            response.addCookie(message);
            request.getRequestDispatcher(notLoggedInUrl).forward(request,response);
        }
        String hashPassword = PasswordHashManager.passwordEncryption(password);

        int userId = userService.getIdUser(email, hashPassword);
        SessionAndRequestService.setSessionForUser(userId,userService,request);

        response.sendRedirect(urlMainWindow);
    }
}
