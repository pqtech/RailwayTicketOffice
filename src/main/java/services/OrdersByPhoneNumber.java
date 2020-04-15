package services;

import dao.SQLiteOrderDAO;
import dao.SQLitePassengerDAO;
import entities.Order;
import entities.Passenger;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrdersByPhoneNumber {
    public boolean checkPhoneRegistered(String phoneNumber) {
        Passenger passenger = new Passenger();
        try {
            passenger = new SQLitePassengerDAO().getByPhoneNumber(phoneNumber);
        } catch (SQLException e) {
            System.out.println("Can't get passenger by this phone number!");
            e.printStackTrace();
        }
        return (passenger.getPhoneNumber() != null);
    }

    public ArrayList<Order> getOrders(String phoneNumber) {
        Passenger passenger = new Passenger();
        try {
            passenger = new SQLitePassengerDAO().getByPhoneNumber(phoneNumber);
        } catch (SQLException e) {
            System.out.println("Can't get passenger by this phone number!");
            e.printStackTrace();
        }
        int passengerId = passenger.getId();
        ArrayList<Order> orders = new ArrayList<Order>();
        try {
            orders = new SQLiteOrderDAO().getByPassengerId(passengerId);
        } catch (SQLException e) {
            System.out.println("Can't get orders!");
            e.printStackTrace();
        }
        return orders;
    }
}
