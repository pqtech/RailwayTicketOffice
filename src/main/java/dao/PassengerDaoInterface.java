package dao;

import entities.Passenger;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PassengerDaoInterface extends DaoInterface<Passenger> {
    Passenger getByPhoneNumber(String phoneNumber) throws SQLException;
    ArrayList<Passenger> getByFirstName(String firstName) throws SQLException;
    ArrayList<Passenger> getBySecondName(String secondName) throws SQLException;
}
