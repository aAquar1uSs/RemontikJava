package com.project.controllers;

import com.project.constants.UrlConstants;
import com.project.service.OrderService;
import com.sun.istack.internal.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.Calendar;
import java.util.Objects;

public class OrderController implements Controller{
    private final OrderService orderService;

    public OrderController() {
        orderService = new OrderService();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        @NotNull String describeOrder = request.getParameter("describe");

        if(Objects.equals(describeOrder, "")) {
            request.getRequestDispatcher(UrlConstants.SYNTAX_ERROR_PAGE_URL).forward(request,response);
            return;
        }

        HttpSession session = request.getSession(false);

        int idUser = (int) session.getAttribute("id_user");

        Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());

        orderService.insertNewOrder(orderService.setNewOrder(describeOrder,idUser,timeNow));

        request.getRequestDispatcher(UrlConstants.MAIN_WINDOW_URL).forward(request,response);

    }
}
