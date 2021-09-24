package com.project.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Strategy pattern
public interface Controller  {
    void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
