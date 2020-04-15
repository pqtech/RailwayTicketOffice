package services;

import dao.SQLiteTicketDAO;
import entities.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

public class TicketsByStationAndDate {
    public ArrayList<Ticket> getTickets(String departureStation, String departureDate) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        try {
            tickets = new SQLiteTicketDAO().getByDepStationAndDate(departureStation, departureDate);
        } catch (SQLException e) {
            System.out.println("Can't get tickets!");
            e.printStackTrace();
        }
        return tickets;
    }
}
