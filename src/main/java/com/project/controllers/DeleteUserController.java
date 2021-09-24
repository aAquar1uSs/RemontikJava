package com.project.controllers;

import com.project.constants.UrlConstants;
import com.project.model.Role;
import com.project.service.RequestService;
import com.project.service.RoleService;
import com.project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUserController implements Controller {

    private final UserService userService;
    private final RoleService roleService;

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

        if (role.getName().equals("ADMIN")) {
            RequestService.setManagersToRequest(roleService, userService, request);
            request.getRequestDispatcher(UrlConstants.ADMIN_PAGE_URL).forward(request, response);
        }
    }
}
