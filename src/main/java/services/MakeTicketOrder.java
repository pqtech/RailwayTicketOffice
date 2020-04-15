package services;

import dao.SQLiteOrderDAO;
import dao.SQLitePassengerDAO;
import entities.Order;
import entities.Passenger;
import entities.Ticket;

import java.sql.SQLException;

public class MakeTicketOrder {
    public int createOrder(String phoneNumber, int ticketId, String destinationStation) {
        Passenger passenger = new Passenger();
        try {
            passenger = new SQLitePassengerDAO().getByPhoneNumber(phoneNumber);
        } catch (SQLException e) {
            System.out.println("Can't get passenger by this phone number!");
            e.printStackTrace();
        }
        int passengerId = passenger.getId();
        Ticket ticket = new GetById().getTicket(ticketId);
        Order order = new Order();
        order.setPassengerId(passengerId);
        order.setTicketId(ticket.getId());
        order.setTrainNumber(ticket.getTrainNumber());
        order.setDepartureStation(ticket.getDepartureStation());
        order.setArrivalStation(ticket.getArrivalStation());
        order.setDepartureDate(ticket.getDepartureDate());
        order.setDepartureTime(ticket.getDepartureTime());
        order.setPassengerArrivalStation(destinationStation);

        int result = 0;
        try {
            result = new SQLiteOrderDAO().create(order);
        } catch (SQLException e) {
            System.out.println("Can't create the order!");
            e.printStackTrace();
        }
        return result;
    }
}
