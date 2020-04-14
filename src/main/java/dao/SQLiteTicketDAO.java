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

    public Ticket getByTrainNumber(int trainNumber) throws SQLException {
        Ticket ticket = new Ticket();
        st = conn.prepareStatement("select * from tickets where train_number = ?;");
        st.setInt(1, trainNumber);
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

    public Ticket getByDepartureStation(String departureStation) throws SQLException {
        Ticket ticket = new Ticket();
        st = conn.prepareStatement("select * from tickets where departure_station = ?;");
        st.setString(1, departureStation);
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

    public Ticket getByArrivalStation(String arrivalStation) throws SQLException {
        Ticket ticket = new Ticket();
        st = conn.prepareStatement("select * from tickets where arrival_station = ?;");
        st.setString(1, arrivalStation);
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

    public Ticket getByDepartureDate(String departureDate) throws SQLException {
        Ticket ticket = new Ticket();
        st = conn.prepareStatement("select * from tickets where departure_date = ?;");
        st.setString(1, departureDate);
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

    public Ticket getByDepartureTime(String departureTime) throws SQLException {
        Ticket ticket = new Ticket();
        st = conn.prepareStatement("select * from tickets where departure_time = ?;");
        st.setString(1, departureTime);
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

    public int create(Ticket entity) throws SQLException {
        return 0;
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
        return 0;
    }

    public int deleteById(int id) throws SQLException {
        return 0;
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
