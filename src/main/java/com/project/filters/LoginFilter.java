package com.project.filters;

import com.project.model.Role;

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

        String loginURI = req.getContextPath() + "/views/login.jsp";
        String private_officeUrl = req.getContextPath() + "/views/user_view/private_office.jsp";
        String adminPageUrl = req.getContextPath() + "/views/admin_view/admin.jsp";
        String masterPageUrl = req.getContextPath() + "/views/master_view/master.jsp";


        boolean loggedIn = session != null && session.getAttribute("userRole") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);

        Role role = (Role) req.getSession().getAttribute("userRole");


        if (loggedIn || loginRequest) {
            if(role.getName().equals("ADMIN")) {
                req.getRequestDispatcher("/views/admin_view/admin.jsp").forward(req,res);
            } else if(role.getName().equals("MASTER")) {
                res.sendRedirect(masterPageUrl);
            } else if (role.getName().equals("USER")) {
                res.sendRedirect(private_officeUrl);
            } else {
                chain.doFilter(request, response);
            }
        } else {
            res.sendRedirect(loginURI);
        }
    }
}
