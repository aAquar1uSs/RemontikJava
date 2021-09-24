package com.project.filters;

import com.project.constants.UrlConstants;
import com.project.model.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OrderFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("userRole") != null;
        Role role = (Role) session.getAttribute("userRole");

        if (loggedIn && role.getName().equals("USER")) {
            req.getRequestDispatcher(UrlConstants.ORDER_PAGE_URL).forward(req,res);
        } else if (loggedIn && role.getName().equals("ADMIN")) {
            res.sendRedirect(req.getContextPath() + "/private_account");
        } else {
           req.getRequestDispatcher(UrlConstants.LOGIN_PAGE_URL).forward(req,res);
        }
    }
}
