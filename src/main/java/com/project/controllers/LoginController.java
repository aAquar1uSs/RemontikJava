package com.project.controllers;

import com.project.model.User;
import com.project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {
    private UserService userService;

    public LoginController() {
        userService = new UserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        HttpSession session = request.getSession();

        int userId = userService.getIdUser(email, password);
        String role = userService.getUserRoleById(userId);

        User user = userService.getUserById(userId);
        session.setAttribute("email", user.getEmail());
        session.setAttribute("userRole", user.getRole());
        session.setAttribute("userName", user.getFio_user());
        session.setAttribute("id_user", userId);

        return role;
    }
}
