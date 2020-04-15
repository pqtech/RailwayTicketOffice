package services;

import dao.SQLitePassengerDAO;
import dao.SQLiteTicketDAO;
import entities.Passenger;
import entities.Ticket;

import java.sql.SQLException;

public class UpdateEntity {
    public int updatePassenger(Passenger passenger) {
        int result = 0;
        try {
            result = new SQLitePassengerDAO().update(passenger);
        } catch (SQLException e) {
            System.out.println("Can't update the passenger!");
            e.printStackTrace();
        }
        return result;
    }

    public int updateTicket(Ticket ticket) {
        int result = 0;
        try {
            result = new SQLiteTicketDAO().update(ticket);
        } catch (SQLException e) {
            System.out.println("Can't update the ticket!");
            e.printStackTrace();
        }
        return result;
    }
}
