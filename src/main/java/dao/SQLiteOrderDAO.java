package dao;

import entities.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLiteOrderDAO implements OrderDaoInterface {

    private PreparedStatement st;
    private ResultSet rs;
    private SQLiteConnection connection = new SQLiteConnection();
    private Connection conn = connection.getConnection();

    public ArrayList<Order> getByPassengerArrivalStation(String passengerArrivalStation) throws SQLException {
        ArrayList<Order> orders = new ArrayList<Order>();
        st = conn.prepareStatement("select * from orders where passenger_arrival_station = ?;");
        st.setString(1, passengerArrivalStation);
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
            orders.add(order);
        }
        connection.closeConnection(rs, st, conn);
        return orders;
    }

    public ArrayList<Order> getByPassengerId(int passengerId) throws SQLException {
        ArrayList<Order> orders = new ArrayList<Order>();
        st = conn.prepareStatement("select * from orders where passenger_id = ?;");
        st.setInt(1, passengerId);
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
            orders.add(order);
        }
        connection.closeConnection(rs, st, conn);
        return orders;
    }

    public int create(Order entity) throws SQLException {
        st = conn.prepareStatement("insert into orders (passenger_id, ticket_id, train_number, departure_station, " +
                "arrival_station, departure_date, departure_time, passenger_arrival_station) values(?,?,?,?,?,?,?,?);");
        st.setInt(1, entity.getPassengerId());
        st.setInt(2, entity.getTicketId());
        st.setInt(3, entity.getTrainNumber());
        st.setString(4, entity.getDepartureStation());
        st.setString(5, entity.getArrivalStation());
        st.setString(6, entity.getDepartureDate());
        st.setString(7, entity.getDepartureTime());
        st.setString(8, entity.getPassengerArrivalStation());
        int result = st.executeUpdate();
        connection.closeConnection(st, conn);
        return result;
    }

    public Order getById(int id) throws SQLException {
        Order order = new Order();
        st = conn.prepareStatement("select * from orders where id = ?;");
        st.setInt(1, id);
        rs = st.executeQuery();
        if (rs.next()) {
            order.setId(rs.getInt("id"));
            order.setPassengerId(rs.getInt("passenger_id"));
            order.setTicketId(rs.getInt("ticket_id"));
            order.setTrainNumber(rs.getInt("train_number"));
            order.setDepartureStation(rs.getString("departure_station"));
            order.setArrivalStation(rs.getString("arrival_station"));
            order.setDepartureDate(rs.getString("departure_date"));
            order.setDepartureTime(rs.getString("departure_time"));
            order.setPassengerArrivalStation(rs.getString("passenger_arrival_station"));
        }
        connection.closeConnection(rs, st, conn);
        return order;
    }

    public int update(Order entity) throws SQLException {
        st = conn.prepareStatement("update orders set passenger_id = ?, ticket_id = ?, train_number = ?, departure_station = ?, " +
                "arrival_station = ?, departure_date = ?, departure_time = ?, passenger_arrival_station = ? where id = ?;");
        st.setInt(1, entity.getPassengerId());
        st.setInt(2, entity.getTicketId());
        st.setInt(3, entity.getTrainNumber());
        st.setString(4, entity.getDepartureStation());
        st.setString(5, entity.getArrivalStation());
        st.setString(6, entity.getDepartureDate());
        st.setString(7, entity.getDepartureTime());
        st.setString(8, entity.getPassengerArrivalStation());
        int result = st.executeUpdate();
        connection.closeConnection(st, conn);
        return result;
    }

    public int deleteById(int id) throws SQLException {
        st = conn.prepareStatement("delete from orders where id = ?;");
        st.setInt(1, id);
        int result = st.executeUpdate();
        connection.closeConnection(st, conn);
        return result;
    }

    public ArrayList<Order> readAll() throws SQLException {
        ArrayList<Order> orders = new ArrayList<Order>();
        st = conn.prepareStatement("select * from orders;");
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
            orders.add(order);
        }
        connection.closeConnection(rs, st, conn);
        return orders;
    }
}
