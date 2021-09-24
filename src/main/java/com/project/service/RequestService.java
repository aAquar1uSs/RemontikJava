package com.project.service;

import com.project.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RequestService {

    public static void setManagersToRequest(RoleService roleService, UserService userService,
                                            HttpServletRequest request) {
        List<Integer> lstIdUsers = roleService.findUsersIdByRole("MANAGER");
        List<User> userList = new ArrayList<>();
        for(Integer id: lstIdUsers) {
            userList.add(userService.getUserById(id));
        }
        request.setAttribute("listManagers",userList);
    }
}
