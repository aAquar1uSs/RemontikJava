package com.project.controllers;

import com.project.service.RoleService;
import com.project.service.SessionService;
import com.project.service.UserService;
import com.project.utils.ValidationManager;

import javax.security.auth.login.CredentialException;
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
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String mainUrl = request.getContextPath() + "/views/main_window.jsp";
        String errorPageUrl = request.getContextPath() + "/views/ErrorPages/registrationError.jsp";

        if(!validationManager.validateEmail(email)) {
            return errorPageUrl;
        }
        if (userService.searchUserByEmail(email)) {
            return errorPageUrl;
        }

        userService.insertUser(userService.setNewUser(firstName,lastName,email,password,0.00));
        int idUser = userService.getIdUser(email,password);
        roleService.setRoleForUser(idUser);

        SessionService.setSessionForUser(idUser,userService,request);

        return mainUrl;
    }

}
