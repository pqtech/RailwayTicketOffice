package services;

import dao.SQLiteConnection;
import dao.SQLiteTicketDAO;
import entities.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestTicketsByStationAndDate {

    private PreparedStatement st;
    private ResultSet rs;
    private SQLiteConnection connection = new SQLiteConnection();
    private Connection conn = connection.getConnection();
    ArrayList<Ticket> ticketsActual = new ArrayList<Ticket>();
    ArrayList<Ticket> ticketsExpected = new ArrayList<Ticket>();
    String departureStation = "Балтийский вокзал";
    String departureDate = "2020-05-15";

    @Test
    public void testGetTicketsByStationAndDate() throws SQLException {
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
            ticketsExpected.add(ticket);
        }
        connection.closeConnection(rs, st, conn);

        ticketsActual = new SQLiteTicketDAO().getByDepStationAndDate(departureStation, departureDate);
        Assert.assertEquals(ticketsActual, ticketsExpected);

    }
}
