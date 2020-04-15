package services;

import dao.SQLitePassengerDAO;
import dao.SQLiteTicketDAO;
import entities.Passenger;
import entities.Ticket;

import java.sql.SQLException;

public class GetById {

    public Passenger getPassenger(int id) {
        Passenger passenger = new Passenger();
        try {
            passenger = new SQLitePassengerDAO().getById(id);
        } catch (SQLException e) {
            System.out.println("Can't get passenger by this id!");
            e.printStackTrace();
        }
        return passenger;
    }

    public Ticket getTicket(int id) {
        Ticket ticket = new Ticket();
        try {
            ticket = new SQLiteTicketDAO().getById(id);
        } catch (SQLException e) {
            System.out.println("Can't get ticket by this id!");
            e.printStackTrace();
        }
        return ticket;


    }
}
