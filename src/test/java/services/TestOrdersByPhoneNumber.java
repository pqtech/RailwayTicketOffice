package services;

import dao.SQLiteConnection;
import dao.SQLiteOrderDAO;
import dao.SQLitePassengerDAO;
import entities.Order;
import entities.Passenger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestOrdersByPhoneNumber {

    Passenger passengerExpected = new Passenger();
    Passenger passengerActual = new Passenger();
    ArrayList<Order> ordersExpected = new ArrayList<Order>();
    ArrayList<Order> ordersActual = new ArrayList<Order>();
    String phoneNumber = "+993429582892";

    @Test
    public void testCheckPhoneRegistered() throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        SQLiteConnection connection = new SQLiteConnection();
        Connection conn = connection.getConnection();
        st = conn.prepareStatement("select * from passengers where phone_number = ?;");
        st.setString(1, phoneNumber);
        rs = st.executeQuery();
        if (rs.next()) {
            passengerExpected.setId(rs.getInt("id"));
            passengerExpected.setFirstName(rs.getString("first_name"));
            passengerExpected.setSecondName(rs.getString("second_name"));
            passengerExpected.setPhoneNumber(rs.getString("phone_number"));
        }
        connection.closeConnection(rs, st, conn);

        passengerActual = new SQLitePassengerDAO().getByPhoneNumber(phoneNumber);
        Assert.assertEquals(passengerActual, passengerExpected);

    }

    @Test
    public void testGetOrders() throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        SQLiteConnection connection = new SQLiteConnection();
        Connection conn = connection.getConnection();
        st = conn.prepareStatement("select * from passengers where phone_number = ?;");
        st.setString(1, phoneNumber);
        rs = st.executeQuery();
        if (rs.next()) {
            passengerExpected.setId(rs.getInt("id"));
            passengerExpected.setFirstName(rs.getString("first_name"));
            passengerExpected.setSecondName(rs.getString("second_name"));
            passengerExpected.setPhoneNumber(rs.getString("phone_number"));
        }

        st = conn.prepareStatement("select * from orders where passenger_id = ?;");
        st.setInt(1, passengerExpected.getId());
        rs = st.executeQuery();
        while (rs.next()) {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setPassengerId(rs.getInt("passenger_id"));
            order.setTicketId(rs.getInt("ticket_id"));
            order.setTrainNumber(rs.getInt("train_number"));
            order.setDepartureStation(rs.getString("departure_station"));
            order.setArrivalStation(rs.getString("arrival_station"));
            order.setDepartureDate(rs.getString("departure_date"));
            order.setDepartureTime(rs.getString("departure_time"));
            order.setPassengerArrivalStation(rs.getString("passenger_arrival_station"));
            ordersExpected.add(order);
        }
        connection.closeConnection(rs, st, conn);

        passengerActual = new SQLitePassengerDAO().getByPhoneNumber(phoneNumber);
        ordersActual = new SQLiteOrderDAO().getByPassengerId(passengerActual.getId());

        Assert.assertEquals(ordersActual, ordersExpected);

    }

}
