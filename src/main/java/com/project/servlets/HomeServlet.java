package com.project.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.project.managers.DBManager;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager dbManager = DBManager.getInstance();
        PrintWriter printWriter = response.getWriter();
        try {
            dbManager.getConnection("");
            printWriter.println("All good!");
        } catch (SQLException | ClassNotFoundException e) {
            printWriter.println(e.getMessage());
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
