package services;

import dao.PassengerDaoInterface;
import dao.SQLitePassengerDAO;
import entities.Passenger;

import java.sql.SQLException;

public class GetById {

    private PassengerDaoInterface passengerDao = new SQLitePassengerDAO();
    public Passenger getPassenger(int id) {
        Passenger passenger = new Passenger();
        try {
            passenger = passengerDao.getById(id);
        } catch (SQLException e) {
            System.out.println("Can't get passenger by this id!");
            e.printStackTrace();
        }
        return passenger;
    }
}
