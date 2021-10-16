package com.project.controllers;

import com.project.constants.UrlConstants;
import com.project.model.Role;
import com.project.service.RoleService;
import com.project.service.SessionService;
import com.project.service.UserService;
import com.project.utils.PasswordHashManager;
import com.project.utils.ValidationManager;
import com.sun.istack.internal.NotNull;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationController implements Controller {
    private final UserService userService;
    private final RoleService roleService;

    public RegistrationController() {
        userService = new UserService();
        roleService = new RoleService();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        @NotNull String firstName = request.getParameter("firstname");
        @NotNull String lastName = request.getParameter("lastname");
        @NotNull String email = request.getParameter("email");
        @NotNull String password = request.getParameter("pass");


        if (checkValidation(email,firstName,lastName)) {
            Cookie message = new Cookie("message", "Error");
            response.addCookie(message);
            request.getRequestDispatcher(UrlConstants.ERROR_REGISTRATION_PAGE_URL).forward(request, response);
        }

        HttpSession session = request.getSession(false);

        Role role = (Role) session.getAttribute("userRole");

        String hashPassword = PasswordHashManager.passwordEncryption(password);
        userService.insertUser(userService.setNewUser(firstName, lastName, email, hashPassword, 0.00));

        int idUser = userService.getIdUser(email, hashPassword);
        if (role == null) {
            roleService.setRoleForUser(idUser, "USER");
            SessionService.setSessionForUser(idUser, userService, request);
            response.sendRedirect(request.getContextPath() + "/main");
        } else if(role.getName().equals("ADMIN")) {
            roleService.setRoleForUser(idUser, "MANAGER");
            response.sendRedirect(request.getContextPath() + "/private_account");
        }
    }

    private boolean checkValidation(String email,String firstName,String lastName) {
         return !ValidationManager.isValidEmail(email) ||
                !ValidationManager.isValidName(firstName) ||
                !ValidationManager.isValidName(lastName) ||
                userService.searchUserByEmail(email);
    }

}
