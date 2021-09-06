package com.project.controllers;

import com.project.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Strategy pattern
public interface Controller {
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
