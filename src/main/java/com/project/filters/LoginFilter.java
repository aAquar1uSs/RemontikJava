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


        boolean loggedIn = session != null && session.getAttribute("userName") != null &&
                session.getAttribute("userRole") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);


        if (loggedIn || loginRequest) {
            if(session.getAttribute("userRole").equals("ADMIN")) {
                res.sendRedirect(adminPageUrl);
            } else if(session.getAttribute("userRole").equals("MASTER")) {
                res.sendRedirect(masterPageUrl);
            } else {
                res.sendRedirect(private_officeUrl);
            }
        } else {
            res.sendRedirect(loginURI);
        }
    }
}
