package com.project.service;

import com.project.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionService {

    public static void setSessionForUser(int userId, UserService userService, HttpServletRequest request) {
        HttpSession oldSession = request.getSession(false);
        if(oldSession != null) {
            oldSession.invalidate();
        }

        HttpSession session = request.getSession(true);

        session.setMaxInactiveInterval(5*60);

        User user = userService.getUserById(userId);
        session.setAttribute("email", user.getEmail());
        session.setAttribute("userRole", user.getRole());
        session.setAttribute("userName", user.getFio_user());
        session.setAttribute("id_user", userId);
    }

}
