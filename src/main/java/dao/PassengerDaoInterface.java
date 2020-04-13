package dao;

import entities.Passenger;

import java.sql.SQLException;

public interface PassengerDaoInterface extends DaoInterface<Passenger> {
    Passenger getByPhoneNumber(String phoneNumber) throws SQLException;
}
