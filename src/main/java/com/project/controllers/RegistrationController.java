package com.project.controllers;

import com.project.service.RoleService;
import com.project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController implements Controller {
    private UserService userService;
    private RoleService roleService;

    public RegistrationController() {
        userService = new UserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("firstname");

        userService.insertUser(userService.setNewUser(firstName,lastName,email,password,0.00));
        int idUser = userService.getIdUser(email,password);
        roleService.setRoleForUser(idUser);

        return "";
    }
}
