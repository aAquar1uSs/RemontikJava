package com.project.controllers;

import com.project.constants.UrlConstants;
import com.project.model.Role;
import com.project.service.*;
import com.sun.istack.internal.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccountController implements Controller {

    private final OrderService orderService;
    private final RoleService roleService;
    private final UserService userService;


    public AccountController() {
        orderService = new OrderService();
        roleService = new RoleService();
        userService = new UserService();
    }

    /**
     * If button "Account" is pressed and this controller will redirect to private account for role.
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);

        Role role = (Role) session.getAttribute("userRole");
        switch (role.getName()) {
            case "USER":
                @NotNull int idUser = (int) session.getAttribute("id_user");
                request.setAttribute("listOrders", orderService.findUserOrders(idUser));
                request.getRequestDispatcher(UrlConstants.PRIVATE_ACCOUNT_URL).forward(request, response);
                break;
            case "ADMIN":
                RequestService.setManagersToRequest(roleService, userService, request);
                request.getRequestDispatcher(UrlConstants.ADMIN_PAGE_URL).forward(request, response);
                break;
            case "MANAGER":
                request.getRequestDispatcher(UrlConstants.MANAGER_PAGE_URL).forward(request,response);
                break;
            case "MASTER":

                break;
            default:

                break;
        }
    }
}
