package com.project.controllers;

import com.project.constants.UrlConstants;
import com.project.service.OrderService;
import com.project.utils.EncodingManager;
import com.project.utils.ValidationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.Calendar;

public class OrderController implements Controller{
    private final OrderService orderService;

    public OrderController() {
        orderService = new OrderService();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String describeOrder = EncodingManager.encodingForRussiansSymbolsInRequest(request,"problemDescription");

        if(!ValidationManager.isValidDescription(describeOrder)) {
            request.getRequestDispatcher(UrlConstants.SYNTAX_ERROR_PAGE_URL).forward(request,response);
            return;
        }

        HttpSession session = request.getSession(false);
        int idUser = (int) session.getAttribute("id_user");

        orderService.insertNewOrder(orderService.setNewOrder(describeOrder,idUser,setDate()));
        response.sendRedirect(request.getContextPath() + "/success");
    }

    private Date setDate() {
        return new Date(Calendar.getInstance().getTimeInMillis());
    }

}
