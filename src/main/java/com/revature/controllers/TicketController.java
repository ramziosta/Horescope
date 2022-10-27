package com.revature.controllers;

import com.revature.models.Ticket;
import com.revature.services.TicketService;
import io.javalin.http.Handler;

import java.util.List;

public class TicketController {
    TicketService service;

    public TicketController() {
        service = new TicketService();
    }

    public TicketController(TicketService ticketService) {
        service = ticketService;
    }

    // create
    public Handler createNewTicket = context -> {

        Ticket ticket = context.bodyAsClass(Ticket.class);
        int id = service.createTicket(ticket);

        if (id > 0) {
            ticket.setId(id);
            context.json(ticket).status(200).result("Submission successful.");
        } else {
            context.result("Your reimbursement ticket was not created, All fields including description must be filled.").status(400);
        }
    };

    // get all tickets
    public Handler getAllTickets = context -> {
        context.json(service.getAllTickets());
       
    };

    // get all pending tickets
    public Handler getAllPendingTickets = context -> {
        context.json(service.getAllPendingTickets());
       
    };

    // gets all tickets by employee_id
    public Handler getEmployeeTicketsById = context -> {
        String param = context.pathParam("id");
        try {
            int id = Integer.parseInt(param);
            List<Ticket> ticket = service.getEmployeeTicketsById(id);

            if (ticket != null) {
                context.json(ticket).status(200);
            } else {
                context.result("Tickets not found").status(400);
            }
        } catch (NumberFormatException nFMException) {
            System.out.println(nFMException.getMessage());
        }

    };

    // > get ticket by STATUS

//    public Handler getTicketByStatus = context -> {
//        String param = context.pathParam("id");
//        try {
//            int id = Integer.parseInt(param);
//            Ticket ticket = service.getTicketById(id);
//
//            if (ticket != null) {
//                context.json(ticket).status(200);
//            } else {
//                context.result("Ticket not found").status(400);
//            }
//        } catch (NumberFormatException nFMException) {
//            System.out.println(nFMException.getMessage());
//        }
//
//    };

    //> update ticket

     // update status Approve or deny
    public Handler approveDenyTicket = context -> {

        Ticket ticket = context.bodyAsClass(Ticket.class);
        ticket = service.approveDenyTicket(ticket);

        if (ticket != null) {
            context.json(ticket).status(200);
        } else {
            context.result("Ticket not updated").status(400);
        }
    };

//
//    public Handler updateTicketStatus = context -> {
//
//        Ticket ticket = context.bodyAsClass(Ticket.class);
//        ticket = service.updateTicket(ticket);
//
//        if (ticket != null) {
//            context.json(ticket).status(200);
//        } else {
//            context.result("Ticket not updated").status(400);
//        }
//    };

    // delete

    public Handler deleteTicket = context -> {
        Ticket ticket = context.bodyAsClass(Ticket.class);

        if (ticket != null) {
            context.json(service.deleteTicket(ticket)).status(200);
        } else {
            context.result("could not delete ticket").status(400);
        }
    };

}
