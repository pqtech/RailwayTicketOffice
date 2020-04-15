package dao;

import entities.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TicketDaoInterface extends DaoInterface<Ticket>{
    ArrayList<Ticket> getByTrainNumber(int trainNumber) throws SQLException;
    ArrayList<Ticket> getByDepartureStation(String departureStation) throws SQLException;
    ArrayList<Ticket> getByArrivalStation(String arrivalStation) throws SQLException;
    ArrayList<Ticket> getByDepartureDate(String departureDate) throws SQLException;
    ArrayList<Ticket> getByDepartureTime(String departureTime) throws SQLException;
    ArrayList<Ticket> getByDepStationAndDate(String departureStation, String departureDate) throws SQLException;
}
