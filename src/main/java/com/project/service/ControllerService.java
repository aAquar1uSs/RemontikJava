package com.project.service;

import com.project.controllers.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerService {

    private static final Logger logger = LogManager.getLogger(ControllerService.class.getName());

    Controller loginController;
    Controller logoutController;
    Controller registrationController;
    Controller orderController;
    Controller accountController;
    Controller deleteUserController;

    public ControllerService(Controller loginController, Controller logoutController, Controller registrationController,
                             Controller orderController,Controller accountController,Controller deleteUserController) {
        this.loginController = loginController;
        this.logoutController = logoutController;
        this.registrationController = registrationController;
        this.orderController = orderController;
        this.accountController = accountController;
        this.deleteUserController = deleteUserController;
    }

    public void causeLoginController(HttpServletRequest request, HttpServletResponse response) {
        try {
            loginController.execute(request, response);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void causeLogoutController(HttpServletRequest request, HttpServletResponse response) {
        try {
            logoutController.execute(request, response);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void causeRegistrationController(HttpServletRequest request, HttpServletResponse response) {
        try {
            registrationController.execute(request, response);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void causeOrderController(HttpServletRequest request, HttpServletResponse response) {
        try {
            orderController.execute(request, response);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void causeAccountController(HttpServletRequest request, HttpServletResponse response) {
        try {
            accountController.execute(request, response);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void causeDeleteUserController(HttpServletRequest request, HttpServletResponse response) {
        try {
            deleteUserController.execute(request, response);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
