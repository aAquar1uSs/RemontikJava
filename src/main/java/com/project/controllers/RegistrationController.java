package com.project.controllers;

import com.project.model.Role;
import com.project.service.RoleService;
import com.project.service.SessionAndRequestService;
import com.project.service.UserService;
import com.project.utils.PasswordHashManager;
import com.project.utils.ValidationManager;
import com.sun.istack.internal.NotNull;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        @NotNull String firstName = request.getParameter("firstname");
        @NotNull String lastName = request.getParameter("lastname");
        @NotNull String email = request.getParameter("email");
        @NotNull String password = request.getParameter("pass");

        String mainUrl = request.getContextPath() + "/views/main_window.jsp";

        if (checkValidation(email,firstName,lastName)) {
            Cookie message = new Cookie("message", "Error");
            response.addCookie(message);
            request.getRequestDispatcher("/views/error_pages/registrationError.jsp").forward(request, response);
        }
        Role role = (Role) session.getAttribute("userRole");

        String hashPassword = PasswordHashManager.passwordEncryption(password);
        userService.insertUser(userService.setNewUser(firstName, lastName, email, hashPassword, 0.00));
        int idUser = userService.getIdUser(email, hashPassword);

        if (role == null) {
            roleService.setRoleForUser(idUser, "USER");
            SessionAndRequestService.setSessionForUser(idUser, userService, request);
            response.sendRedirect(mainUrl);
        } else if(role.getName().equals("ADMIN")) {
            roleService.setRoleForUser(idUser, "MANAGER");
            response.sendRedirect(request.getContextPath() + "/private_account");
        }
    }

    private boolean checkValidation(String email,String firstName,String lastName) {
         return !validationManager.isValidEmail(email) ||
                !validationManager.isValidName(firstName) ||
                !validationManager.isValidName(lastName) ||
                userService.searchUserByEmail(email);
    }

}
