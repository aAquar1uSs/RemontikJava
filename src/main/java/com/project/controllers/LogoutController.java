package com.project.controllers;

import com.project.constants.UrlConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }

        request.getRequestDispatcher(UrlConstants.LOGIN_PAGE_URL).forward(request,response);
    }
}
