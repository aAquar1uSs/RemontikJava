package com.project.controllers;

import com.project.service.RoleService;
import com.project.service.SessionService;
import com.project.service.UserService;

import javax.servlet.ServletException;
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
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("pass");

        if(email == null || !userService.searchUserByEmail(email) ||
                password == null) {
            request.getRequestDispatcher("/views/ErrorPages/registrationError.jsp");
        }

        int userId = userService.getIdUser(email, password);
        String role = roleService.getUserRoleById(userId);

        SessionService.setSessionForUser(userId,userService,request);

        switch (role) {
            case "ADMIN":
                request.getRequestDispatcher("/views/admin_view/admin.jsp").forward(request,response);
                break;
            case "USER":
                request.getRequestDispatcher("/views/main_window.jsp").forward(request,response);
                break;
            case "MASTER":
                request.getRequestDispatcher("/views/master_view/master.jsp").forward(request,response);
                break;
            default:
                String notLogginedInUrl = request.getContextPath() + "/views/ErrorPages/ErrorNotLoggedIn.jsp";
                response.sendRedirect(notLogginedInUrl);
                break;
        }

        return "";
    }

}
