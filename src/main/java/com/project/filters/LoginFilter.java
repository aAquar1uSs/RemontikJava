package com.project.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String loginURI = req.getContextPath() + "/views/login.html";
        String private_officeUrl = req.getContextPath() + "/views/user_view/private_office.jsp";
        boolean loggedIn = session != null && session.getAttribute("userName") != null &&
                session.getAttribute("userRole") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);

        if(loggedIn ||  loginRequest) {
            res.sendRedirect(private_officeUrl);
        } else {
            res.sendRedirect(loginURI);
        }
    }
}
