package com.project.controllers;

import com.project.service.RoleService;
import com.project.service.SessionService;
import com.project.service.UserService;
import com.project.utils.ValidationManager;
import com.sun.istack.internal.NotNull;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController implements Controller {
    private UserService userService;
    private RoleService roleService;
    private ValidationManager validationManager;

    public RegistrationController() {
        userService = new UserService();
        roleService = new RoleService();
        validationManager = new ValidationManager();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        @NotNull String firstName = request.getParameter("firstname");
        @NotNull String lastName = request.getParameter("lastname");
        @NotNull String email = request.getParameter("email");
        @NotNull String password = request.getParameter("pass");

        String mainUrl = request.getContextPath() + "/views/main_window.jsp";

        if (!validationManager.isValidEmail(email) ||
                !validationManager.isValidName(firstName) ||
                !validationManager.isValidName(lastName) ||
                userService.searchUserByEmail(email)) {

            Cookie message = new Cookie("message", "Error");
            response.addCookie(message);
            request.getRequestDispatcher("/views/ErrorPages/registrationError.jsp").forward(request, response);
        }

        userService.insertUser(userService.setNewUser(firstName, lastName, email, password, 0.00));
        int idUser = userService.getIdUser(email, password);
        roleService.setRoleForUser(idUser);

        SessionService.setSessionForUser(idUser, userService, request);

        response.sendRedirect(mainUrl);
    }

}
