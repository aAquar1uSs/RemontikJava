package com.project.service;

import com.project.model.Order;
import com.project.model.User;
import com.sun.istack.internal.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SessionService {

    public static void setSessionForUser(int userId, UserService userService, HttpServletRequest request) {
        HttpSession oldSession = request.getSession(false);
        if(oldSession != null) {
            oldSession.invalidate();
        }

        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(5*60);

        User user = userService.getUserById(userId);
        session.setAttribute("user", user);
        session.setAttribute("email", user.getEmail());
        session.setAttribute("userRole", user.getRole());
        session.setAttribute("userName", user.getFio_user());
        session.setAttribute("cashAcc",user.getCash_account());
        session.setAttribute("id_user", userId);
    }

    public static void setOrdersToSession(HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        OrderService orderService = new OrderService();
        @NotNull int idUser = (int) session.getAttribute("id_user");
        session.setAttribute("listOrders", orderService.findUserOrders(idUser));
    }

}
