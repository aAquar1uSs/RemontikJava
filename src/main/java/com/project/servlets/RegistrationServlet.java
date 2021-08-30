package com.project.servlets;

import com.project.db.constants.SqlConstants;
import com.project.db.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager dbManager = DBManager.getInstance();
        PrintWriter p = response.getWriter();
        try {
            dbManager.getConnection(SqlConstants.URL_CONNECT_TO_DB);
            p.println("All good!");
        } catch (SQLException | ClassNotFoundException e) {
            p.println(e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
