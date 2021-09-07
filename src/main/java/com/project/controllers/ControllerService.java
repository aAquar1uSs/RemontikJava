package com.project.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerService {

    private static Logger logger = LogManager.getLogger(ControllerService.class.getName());

    Controller loginController;
    Controller logoutController;
    Controller registrationController;

    public ControllerService(Controller loginController, Controller logoutController, Controller registrationController) {
        this.loginController = loginController;
        this.logoutController = logoutController;
        this.registrationController = registrationController;
    }

    public void causeLoginController(HttpServletRequest request, HttpServletResponse response){
        try {
            loginController.execute(request,response);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void causeLogoutController(HttpServletRequest request, HttpServletResponse response){
        try {
            logoutController.execute(request,response);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void causeRegistrationController(HttpServletRequest request, HttpServletResponse response){
        try {
            loginController.execute(request,response);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
