package dao;

import entities.Ticket;

import java.sql.SQLException;
import java.util.Date;

public interface TicketDaoInterface extends DaoInterface<Ticket>{
    Ticket getByTrainNumber(int trainNumber) throws SQLException;
    Ticket getByDepartureStation(String departureStation) throws SQLException;
    Ticket getByArrivalStation(String arrivalStation) throws SQLException;
    Ticket getByDepartureDate(String departureDate) throws SQLException;
    Ticket getByDepartureTime(String departureTime) throws SQLException;
}
