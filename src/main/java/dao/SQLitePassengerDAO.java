package dao;

import entities.Passenger;
import entities.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLitePassengerDAO implements PassengerDaoInterface {

    private PreparedStatement st;
    private ResultSet rs;
    private SQLiteConnection connection = new SQLiteConnection();
    private Connection conn = connection.getConnection();

    public Passenger getByPhoneNumber(String phoneNumber) throws SQLException {
        Passenger passenger = new Passenger();
        st = conn.prepareStatement("select * from passengers where phone_number = ?;");
        st.setString(1, phoneNumber);
        rs = st.executeQuery();
        if (rs.next()) {
            passenger.setId(rs.getInt("id"));
            passenger.setFirstName(rs.getString("first_name"));
            passenger.setSecondName(rs.getString("second_name"));
            passenger.setPhoneNumber(rs.getString("phone_number"));
        }
        connection.closeConnection(rs, st, conn);
        return passenger;
    }

    public Passenger getByFirstName(String firstName) throws SQLException {
        Passenger passenger = new Passenger();
        st = conn.prepareStatement("select * from passengers where first_name = ?;");
        st.setString(1, firstName);
        rs = st.executeQuery();
        if (rs.next()) {
            passenger.setId(rs.getInt("id"));
            passenger.setFirstName(rs.getString("first_name"));
            passenger.setSecondName(rs.getString("second_name"));
            passenger.setPhoneNumber(rs.getString("phone_number"));
        }
        connection.closeConnection(rs, st, conn);
        return passenger;
    }

    public Passenger getBySecondName(String secondName) throws SQLException {
        Passenger passenger = new Passenger();
        st = conn.prepareStatement("select * from passengers where second_name = ?;");
        st.setString(1, secondName);
        rs = st.executeQuery();
        if (rs.next()) {
            passenger.setId(rs.getInt("id"));
            passenger.setFirstName(rs.getString("first_name"));
            passenger.setSecondName(rs.getString("second_name"));
            passenger.setPhoneNumber(rs.getString("phone_number"));
        }
        connection.closeConnection(rs, st, conn);
        return passenger;
    }

    public int create(Passenger entity) throws SQLException {
        return 0;
    }

    public Passenger getById(int id) throws SQLException {
        Passenger passenger = new Passenger();
        st = conn.prepareStatement("select * from passengers where id = ?;");
        st.setInt(1, id);
        rs = st.executeQuery();
        if (rs.next()) {
            passenger.setId(rs.getInt("id"));
            passenger.setFirstName(rs.getString("first_name"));
            passenger.setSecondName(rs.getString("second_name"));
            passenger.setPhoneNumber(rs.getString("phone_number"));
        }
        connection.closeConnection(rs, st, conn);
        return passenger;
    }

    public int update(Passenger entity) throws SQLException {
        return 0;
    }

    public int deleteById(int id) throws SQLException {
        return 0;
    }

    public ArrayList<Passenger> readAll() throws SQLException {
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        st = conn.prepareStatement("select * from passengers;");
        rs = st.executeQuery();
        while (rs.next()) {
            Passenger passenger = new Passenger();
            passenger.setId(rs.getInt("id"));
            passenger.setFirstName(rs.getString("first_name"));
            passenger.setSecondName(rs.getString("second_name"));
            passenger.setPhoneNumber(rs.getString("phone_number"));
            passengers.add(passenger);
        }
        connection.closeConnection(rs, st, conn);
        return passengers;
    }
}
