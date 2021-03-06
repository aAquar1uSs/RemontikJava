package com.project.filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;


public class LocalizationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getParameter("lang") != null) {
            req.getSession().setAttribute("lang", req.getParameter("lang"));
            Locale.setDefault(new Locale(req.getParameter("lang")));
        }

        chain.doFilter(request, response);
    }
}
