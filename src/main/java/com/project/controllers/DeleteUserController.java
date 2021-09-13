package com.project.controllers;

import com.project.model.Role;
import com.project.service.RoleService;
import com.project.service.SessionAndRequestService;
import com.project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUserController implements Controller{

    UserService userService;
    RoleService roleService;

    public DeleteUserController() {
        userService = new UserService();
        roleService = new RoleService();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("emailForDelete");

        int idUser = userService.getUserIdByEmail(email);
        roleService.deleteRoleByUserId(idUser);
        userService.deleteUserById(idUser);

        Role role = (Role) session.getAttribute("userRole");

        if(role.getName().equals("ADMIN")) {
            SessionAndRequestService.setManagersToRequest(request);
            request.getRequestDispatcher("/views/admin_view/admin.jsp").forward(request, response);
        }
    }
}
