package services;

import dao.SQLitePassengerDAO;
import entities.Passenger;

import java.sql.SQLException;

public class SignUpPassenger {
    public boolean checkPhone(String phoneNumber) {
        Passenger passenger = new Passenger();
        try {
            passenger = new SQLitePassengerDAO().getByPhoneNumber(phoneNumber);
        } catch (SQLException e) {
            System.out.println("Can't get passenger by this id!");
            e.printStackTrace();
        }
        return (passenger.getPhoneNumber() != null);
    }
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
}
