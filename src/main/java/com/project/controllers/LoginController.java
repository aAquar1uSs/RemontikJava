package com.project.controllers;

import com.project.service.RoleService;
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
        @NotNull String email = request.getParameter("email");
        @NotNull String password = request.getParameter("pass");

        if(!validationManager.isValidEmail(email) || !userService.searchUserByEmail(email)) {
            Cookie message = new Cookie("message", "Error");
            response.addCookie(message);
            request.getRequestDispatcher("/views/ErrorPages/ErrorNotLoggedIn.jsp").forward(request,response);
        }
        String hashPassword = PasswordHashManager.passwordEncryption(password);

        int userId = userService.getIdUser(email, hashPassword);
        String role = roleService.getUserRoleById(userId);

        SessionService.setSessionForUser(userId,userService,request);

        switch (role) {
            case "ADMIN":
                request.getRequestDispatcher("/views/admin_view/admin.jsp").forward(request,response);
                break;
            case "USER":
                response.sendRedirect(request.getContextPath() + "/views/main_window.jsp");
                break;
            case "MASTER":
                request.getRequestDispatcher("/views/master_view/master.jsp").forward(request,response);
                break;
            default:
                String notLogginedInUrl = request.getContextPath() + "/views/ErrorPages/ErrorNotLoggedIn.jsp";
                response.sendRedirect(notLogginedInUrl);
                break;
        }
    }

}
