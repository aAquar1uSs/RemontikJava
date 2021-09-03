package com.project.controllers;

import com.project.service.UserService;
import com.project.utils.PasswordHashManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController implements Controller{
    private UserService userService;

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



        return null;
    }
}
