package services;

import dao.SQLitePassengerDAO;
import dao.SQLiteTicketDAO;
import entities.Passenger;
import entities.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

public class GetAll {

    public ArrayList<Passenger> getPassengers() {
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        try {
            passengers = new SQLitePassengerDAO().readAll();
        } catch (SQLException e) {
            System.out.println("Can't get passengers!");
            e.printStackTrace();
        }
        return passengers;
    }

    public ArrayList<Ticket> getTickets() {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        try {
            tickets = new SQLiteTicketDAO().readAll();
        } catch (SQLException e) {
            System.out.println("Can't get tickets!");
            e.printStackTrace();
        }
        return tickets;
    }
}
