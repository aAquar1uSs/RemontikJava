package com.project.filters;

import com.project.constants.UrlConstants;
import com.project.model.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {

    }

    /**
     * The filter tracks whether the user is registered or not
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException,
            IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String servletPath = req.getServletPath().substring(8);

        Role role = (Role) req.getSession().getAttribute("userRole");
        if (role == null) {
            req.getRequestDispatcher(UrlConstants.LOGIN_PAGE_URL).forward(req,res);
        } else {
            res.sendRedirect(req.getContextPath() + servletPath);
        }
    }
}
