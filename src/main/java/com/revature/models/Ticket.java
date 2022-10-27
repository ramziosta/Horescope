package com.revature.models;


public class Ticket {
    int id;
    double amount;
//    Date date;
    int employee_id;
    String status;
    String description;

    // > no args constructor
    public Ticket() {
    }

    // > no args constructor with no id as it is auto generated in DB
    public Ticket(double amount,  int employee_id, String description) {

        this.amount = amount;
        // this.date = date;
        this.employee_id = employee_id;
        this.description = description;
    }

    // > all args constructor with id as it is auto generated in DB
    public Ticket(int id, double amount, int employee_id, String status,String description) {
        this.id = id;
        this.amount = amount;
        // this.date = date;
        this.employee_id = employee_id;
        this.status = status;
        this.description = description;
    }

    // < Getter & Setter Ticket ID
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // < Getter & Setter AMOUNT
    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // < Getter & Setter DATE
//    public String getDate() {
//        return this.date;
//    }

//    public void setDate(String date) {
//        this.date = date;
//    }

    // < Getter & Setter STATUS
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // < Getter & Setter EMPLOYEE_ID
    public int getEmployee_id() {
        return this.employee_id;
    }

    public void setEmployee_id(int newEmployee_id) {
        this.employee_id = newEmployee_id;
    }

    // < Getter & Setter DESCRIPTION
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public String toString() {
        return "Ticket{id=" + this.id + ", amount='" + this.amount + '\''  + '\''
                + ", employee_id=" + this.employee_id + ", status=" + this.status +  ", description=" + this.description + '}';
    }
}