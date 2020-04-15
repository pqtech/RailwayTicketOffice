package dao;

import entities.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLiteTicketDAO implements TicketDaoInterface {

    private PreparedStatement st;
    private ResultSet rs;
    private SQLiteConnection connection = new SQLiteConnection();
    private Connection conn = connection.getConnection();

    public ArrayList<Ticket> getByTrainNumber(int trainNumber) throws SQLException {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        st = conn.prepareStatement("select * from tickets where train_number = ?;");
        st.setInt(1, trainNumber);
        rs = st.executeQuery();
        while (rs.next()) {
            Ticket ticket = new Ticket();
            ticket.setId(rs.getInt("id"));
            ticket.setTrainNumber(rs.getInt("train_number"));
            ticket.setDepartureStation(rs.getString("departure_station"));
            ticket.setArrivalStation(rs.getString("arrival_station"));
            ticket.setDepartureDate(rs.getString("departure_date"));
            ticket.setDepartureTime(rs.getString("departure_time"));
            tickets.add(ticket);
        }
        connection.closeConnection(rs, st, conn);
        return tickets;
    }

    public ArrayList<Ticket> getByDepartureStation(String departureStation) throws SQLException {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        st = conn.prepareStatement("select * from tickets where departure_station = ?;");
        st.setString(1, departureStation);
        rs = st.executeQuery();
        while (rs.next()) {
            Ticket ticket = new Ticket();
            ticket.setId(rs.getInt("id"));
            ticket.setTrainNumber(rs.getInt("train_number"));
            ticket.setDepartureStation(rs.getString("departure_station"));
            ticket.setArrivalStation(rs.getString("arrival_station"));
            ticket.setDepartureDate(rs.getString("departure_date"));
            ticket.setDepartureTime(rs.getString("departure_time"));
            tickets.add(ticket);
        }
        connection.closeConnection(rs, st, conn);
        return tickets;
    }

    public ArrayList<Ticket> getByArrivalStation(String arrivalStation) throws SQLException {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        st = conn.prepareStatement("select * from tickets where arrival_station = ?;");
        st.setString(1, arrivalStation);
        rs = st.executeQuery();
        while (rs.next()) {
            Ticket ticket = new Ticket();
            ticket.setId(rs.getInt("id"));
            ticket.setTrainNumber(rs.getInt("train_number"));
            ticket.setDepartureStation(rs.getString("departure_station"));
            ticket.setArrivalStation(rs.getString("arrival_station"));
            ticket.setDepartureDate(rs.getString("departure_date"));
            ticket.setDepartureTime(rs.getString("departure_time"));
            tickets.add(ticket);
        }
        connection.closeConnection(rs, st, conn);
        return tickets;
    }

    public ArrayList<Ticket> getByDepartureDate(String departureDate) throws SQLException {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        st = conn.prepareStatement("select * from tickets where departure_date = ?;");
        st.setString(1, departureDate);
        rs = st.executeQuery();
        while (rs.next()) {
            Ticket ticket = new Ticket();
            ticket.setId(rs.getInt("id"));
            ticket.setTrainNumber(rs.getInt("train_number"));
            ticket.setDepartureStation(rs.getString("departure_station"));
            ticket.setArrivalStation(rs.getString("arrival_station"));
            ticket.setDepartureDate(rs.getString("departure_date"));
            ticket.setDepartureTime(rs.getString("departure_time"));
            tickets.add(ticket);
        }
        connection.closeConnection(rs, st, conn);
        return tickets;
    }

    public ArrayList<Ticket> getByDepartureTime(String departureTime) throws SQLException {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        st = conn.prepareStatement("select * from tickets where departure_time = ?;");
        st.setString(1, departureTime);
        rs = st.executeQuery();
        while (rs.next()) {
            Ticket ticket = new Ticket();
            ticket.setId(rs.getInt("id"));
            ticket.setTrainNumber(rs.getInt("train_number"));
            ticket.setDepartureStation(rs.getString("departure_station"));
            ticket.setArrivalStation(rs.getString("arrival_station"));
            ticket.setDepartureDate(rs.getString("departure_date"));
            ticket.setDepartureTime(rs.getString("departure_time"));
            tickets.add(ticket);
        }
        connection.closeConnection(rs, st, conn);
        return tickets;
    }

    public ArrayList<Ticket> getByDepStationAndDate(String departureStation, String departureDate) throws SQLException {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        st = conn.prepareStatement("select * from tickets where departure_station = ? and departure_date = ?;");
        st.setString(1, departureStation);
        st.setString(2, departureDate);
        rs = st.executeQuery();
        while (rs.next()) {
            Ticket ticket = new Ticket();
            ticket.setId(rs.getInt("id"));
            ticket.setTrainNumber(rs.getInt("train_number"));
            ticket.setDepartureStation(rs.getString("departure_station"));
            ticket.setArrivalStation(rs.getString("arrival_station"));
            ticket.setDepartureDate(rs.getString("departure_date"));
            ticket.setDepartureTime(rs.getString("departure_time"));
            tickets.add(ticket);
        }
        connection.closeConnection(rs, st, conn);
        return tickets;
    }

    public int create(Ticket entity) throws SQLException {
        st = conn.prepareStatement("insert into tickets (train_number, departure_station, " +
                "arrival_station, departure_date, departure_time) values(?,?,?,?,?);");
        st.setInt(1, entity.getTrainNumber());
        st.setString(2, entity.getDepartureStation());
        st.setString(3, entity.getArrivalStation());
        st.setString(4, entity.getDepartureDate());
        st.setString(5, entity.getDepartureTime());
        int result = st.executeUpdate();
        connection.closeConnection(st, conn);
        return result;
    }

    public Ticket getById(int id) throws SQLException {
        Ticket ticket = new Ticket();
        st = conn.prepareStatement("select * from tickets where id = ?;");
        st.setInt(1, id);
        rs = st.executeQuery();
        if (rs.next()) {
            ticket.setId(rs.getInt("id"));
            ticket.setTrainNumber(rs.getInt("train_number"));
            ticket.setDepartureStation(rs.getString("departure_station"));
            ticket.setArrivalStation(rs.getString("arrival_station"));
            ticket.setDepartureDate(rs.getString("departure_date"));
            ticket.setDepartureTime(rs.getString("departure_time"));
        }
        connection.closeConnection(rs, st, conn);
        return ticket;
    }

    public int update(Ticket entity) throws SQLException {
        st = conn.prepareStatement("update tickets set train_number = ?, departure_station = ?, " +
                "arrival_station = ?, departure_date = ?, departure_time = ? where id = ?;");
        st.setInt(1, entity.getTrainNumber());
        st.setString(2, entity.getDepartureStation());
        st.setString(3, entity.getArrivalStation());
        st.setString(4, entity.getDepartureDate());
        st.setString(5, entity.getDepartureTime());
        st.setInt(6, entity.getId());
        int result = st.executeUpdate();
        connection.closeConnection(st, conn);
        return result;
    }

    public int deleteById(int id) throws SQLException {
        st = conn.prepareStatement("delete from tickets where id = ?;");
        st.setInt(1, id);
        int result = st.executeUpdate();
        connection.closeConnection(st, conn);
        return result;
    }

    public ArrayList<Ticket> readAll() throws SQLException {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        st = conn.prepareStatement("select * from tickets;");
        rs = st.executeQuery();
        while (rs.next()) {
            Ticket ticket = new Ticket();
            ticket.setId(rs.getInt("id"));
            ticket.setTrainNumber(rs.getInt("train_number"));
            ticket.setDepartureStation(rs.getString("departure_station"));
            ticket.setArrivalStation(rs.getString("arrival_station"));
            ticket.setDepartureDate(rs.getString("departure_date"));
            ticket.setDepartureTime(rs.getString("departure_time"));
            tickets.add(ticket);
        }
        connection.closeConnection(rs, st, conn);
        return tickets;
    }
}
