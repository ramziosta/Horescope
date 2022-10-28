package com.revature;

import com.revature.controllers.TicketController;
import com.revature.controllers.UserController;
import com.revature.services.TicketService;
import com.revature.services.UserService;
import io.javalin.Javalin;


public class Main {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {config.enableCorsForAllOrigins();} ).start(8082);

        UserService userService = new UserService();
        UserController userController = new UserController(userService);

        app.post("/user", userController.createNewUser);
        app.put("/login",userController.login);
        app.put("/logout",userController.logout);
        
        app.get("/users", userController.getAllUsers);
        app.get("/user/{id}", userController.getUserById);
        app.put("/user", userController.updateUser);
        app.delete("/user", userController.deleteUser);

        // TicketService ticketService = new TicketService();
        // TicketController ticketController = new TicketController(ticketService);

        // app.get("tickets", ticketController.getAllTickets);
        // app.get("/tickets/pending", ticketController.getAllPendingTickets);
        // app.get("tickets/{id}", ticketController.getUserTicketsById);
        // app.post("/ticket", ticketController.createNewTicket);
        // app.put("/ticket", ticketController.approveDenyTicket);
        // app.delete("/ticket", ticketController.deleteTicket);
    }
}