package com.project.filters;

import com.project.model.Role;
import com.project.service.OrderService;
import com.sun.istack.internal.NotNull;

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

    /**
     * This filer monitors user's,master's and admin's rights
     *
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String loginURL = req.getContextPath() + "/views/login.jsp";
        String masterPageUrl = req.getContextPath() + "/views/master_view/master.jsp";


        boolean loggedIn = session != null && session.getAttribute("userRole") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURL);

        if (loggedIn || loginRequest) {
            Role role = (Role) req.getSession().getAttribute("userRole");
            switch (role.getName()) {
                case "ADMIN":
                case "USER":
                    res.sendRedirect(req.getContextPath() + "/private_account");
                    break;
                case "MASTER":
                    res.sendRedirect(masterPageUrl);
                    break;
                case "MANAGER":
                    req.getRequestDispatcher("views/manager_view/manager_page.jsp").forward(req, res);
                    break;
                default:
                    chain.doFilter(request, response);
                    break;
            }
        } else {
            res.sendRedirect(loginURL);
        }
    }
}
