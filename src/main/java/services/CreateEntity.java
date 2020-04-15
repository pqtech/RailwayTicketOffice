package services;

import dao.SQLitePassengerDAO;
import dao.SQLiteTicketDAO;
import entities.Passenger;
import entities.Ticket;

import java.sql.SQLException;

public class CreateEntity {
    public int createPassenger(Passenger passenger) {
        int result = 0;
        try {
            result = new SQLitePassengerDAO().create(passenger);
        } catch (SQLException e) {
            System.out.println("Can't create the passenger!");
            e.printStackTrace();
        }
        return result;
    }

    public int createTicket(Ticket ticket) {
        int result = 0;
        try {
            result = new SQLiteTicketDAO().create(ticket);
        } catch (SQLException e) {
            System.out.println("Can't create the ticket!");
            e.printStackTrace();
        }
        return result;
    }
}
