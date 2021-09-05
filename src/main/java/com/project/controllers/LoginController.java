package com.project.controllers;

import com.project.service.RoleService;
import com.project.service.SessionService;
import com.project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements Controller {
    private UserService userService;
    private RoleService roleService;

    public LoginController() {
        userService = new UserService();
        roleService = new RoleService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("pass");

        int userId = userService.getIdUser(email, password);
        String role = roleService.getUserRoleById(userId);

        SessionService.setSessionForUser(userId,userService,request);

        return role;
    }

}
