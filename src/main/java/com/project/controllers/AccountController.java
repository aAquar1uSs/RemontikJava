package com.project.controllers;

import com.project.service.OrderService;
import com.sun.istack.internal.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class AccountController implements Controller{

    private final OrderService orderService;

    public AccountController() {
        orderService = new OrderService();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        @NotNull int idUser = (int) session.getAttribute("id_user");

        request.setAttribute("listOrders", orderService.findUserOrders(idUser));

        //response.sendRedirect(request.getContextPath() + "/views/user_view/private_office.jsp");
        request.getRequestDispatcher("/views/user_view/private_office.jsp").forward(request,response);
    }
}
