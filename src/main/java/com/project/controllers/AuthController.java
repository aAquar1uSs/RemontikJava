package com.project.controllers;


import com.project.model.User;
import com.project.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


public class AuthController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        HttpSession session = request.getSession();

        UserService userService = new UserService();
        PrintWriter printWriter = response.getWriter();

        int user_id = userService.getIdUser(email,password);
        String role = userService.getUserRoleById(user_id);

        User user = userService.getUserById(user_id);
        session.setAttribute("email", user.getEmail());
        session.setAttribute("userRole", user.getRole());
        session.setAttribute("userName",user.getFio_user());
        session.setAttribute("id_user", user_id);

        if(role.equals("ADMIN")) {
            String adminURI = request.getContextPath() + "/views/admin_view/admin.jsp";
            response.sendRedirect(adminURI);
        } else if(role.equals("USER")) {
            String userURI = request.getContextPath() + "/views/main_window.html";
            response.sendRedirect(userURI);
        } else if(role.equals("MASTER")) {
            String masterURI = request.getContextPath() + "/views/master_view/master.jsp";
            response.sendRedirect(masterURI);
        }

    }

    boolean isLoggedIn(HttpSession session){
        return (session!=null
                && session.getAttribute("firstname")!=null
                && session.getAttribute("password")!=null);
    }
}
