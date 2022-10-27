package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Handler;

public class UserController {
    UserService service;

    public UserController() {
        service = new UserService();
    }

    public UserController(UserService userService) {
        service = userService;
    }

    // create
    public Handler createNewUser = context -> {

        User user = context.bodyAsClass(User.class);
        int id = service.create(user);

        if (id > 0) {
            user.setId(id);
            context.json(user).status(200);
        } else {
            context.result("Please choose a different email, or login to your account.").status(400);
        }
    };


    // get all Users
    public Handler getAllUsers = context -> {
        context.json(service.getAllUsers());
    };

    
    // id
    public Handler getUserById = context -> {
        String param = context.pathParam("id");
        try {
            int id = Integer.parseInt(param);
            User user = service.getById(id);

            if (user != null) {
                context.json(user).status(200);
            } else {
                context.result("User not found").status(400);
            }
        } catch (NumberFormatException nFMException) {
            System.out.println(nFMException.getMessage());
        }

    };

    // update

    public Handler updateUser = context -> {

        User user = context.bodyAsClass(User.class);
        user = service.updateUser(user);

        if (user != null) {
            context.json(user).status(200);
        } else {
            context.result("User not updated").status(400);
        }
    };

    // delete

    public Handler deleteUser = context -> {
        User user = context.bodyAsClass(User.class);

        if (user != null) {
            context.json(service.deleteUser(user)).status(200);
        } else {
            context.result("could not delete user").status(400);
        }
    };

    public Handler login = context -> {
        User user = context.bodyAsClass(User.class);
        user = service.login(user);

        if (user != null) {
            context.json(user).status(200);

        } else {
            context.result("Log in failed, please check email or password").status(400);
        }
    };

    public Handler logout = context -> {
        User user = context.bodyAsClass(User.class);
        user = service.logout(user);

        if (user != null) {
            context.json(user).status(200);

        } else {
            context.result("Log out successfull").status(400);
        }
    };


}
