package com.project.controllers;

import com.project.constants.UrlConstants;
import com.project.service.SessionService;
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
    private final UserService userService;

    public LoginController() {
        userService = new UserService();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        @NotNull String email = request.getParameter("email");
        @NotNull String password = request.getParameter("pass");

        String hashPassword = PasswordHashManager.passwordEncryption(password);

        if (!ValidationManager.isValidEmail(email) || !userService.searchUserByEmail(email)
                || !userService.userPasswordVerification(email,hashPassword)) {
            Cookie message = new Cookie("message", "Error");
            response.addCookie(message);
            request.getRequestDispatcher(UrlConstants.ERROR_PAGE_IF_NOT_LOGGED_URL).forward(request, response);
        }

        int userId = userService.getIdUser(email, hashPassword);
        SessionService.setSessionForUser(userId, userService, request);
        response.sendRedirect(request.getContextPath() + "/main");
    }

}
