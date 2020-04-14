package dao;

import entities.Passenger;

import java.sql.SQLException;

public interface PassengerDaoInterface extends DaoInterface<Passenger> {
    Passenger getByPhoneNumber(String phoneNumber) throws SQLException;
    Passenger getByFirstName(String firstName) throws SQLException;
    Passenger getBySecondName(String secondName) throws SQLException;
}
