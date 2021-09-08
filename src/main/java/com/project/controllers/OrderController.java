package com.project.controllers;

import com.project.service.OrderService;
import com.sun.istack.internal.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.Calendar;

public class OrderController implements Controller{
    private OrderService orderService;

    public OrderController() {
        orderService = new OrderService();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        @NotNull String describeOrder = request.getParameter("describe");
        HttpSession session = request.getSession(false);

        int idUser = (int) session.getAttribute("id_user");

        Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());

        orderService.insertNewOrder(orderService.setNewOrder(describeOrder,idUser,timeNow));

        String mainUrl = request.getContextPath() + "/views/main_window.jsp";
        response.sendRedirect(mainUrl);

    }
}
