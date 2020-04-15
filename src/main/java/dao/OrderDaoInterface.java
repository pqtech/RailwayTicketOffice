package dao;

import entities.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDaoInterface extends DaoInterface<Order> {
    ArrayList<Order> getByPassengerArrivalStation(String passengerArrivalStation) throws SQLException;
    ArrayList<Order> getByPassengerId(int passengerId) throws SQLException;
}
