package dao;

import entities.Passenger;

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

    public ArrayList<Passenger> getByFirstName(String firstName) throws SQLException {
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        st = conn.prepareStatement("select * from passengers where first_name = ?;");
        st.setString(1, firstName);
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

    public ArrayList<Passenger> getBySecondName(String secondName) throws SQLException {
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        st = conn.prepareStatement("select * from passengers where second_name = ?;");
        st.setString(1, secondName);
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

    public int create(Passenger entity) throws SQLException {
        st = conn.prepareStatement("insert into passengers (first_name, second_name, phone_number) values(?,?,?);");
        st.setString(1, entity.getFirstName());
        st.setString(2, entity.getSecondName());
        st.setString(3, entity.getPhoneNumber());
        int result = st.executeUpdate();
        connection.closeConnection(st, conn);
        return result;
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
        st = conn.prepareStatement("update passengers set first_name = ?, second_name = ?, phone_number = ? where id = ?;");
        st.setString(1, entity.getFirstName());
        st.setString(2, entity.getSecondName());
        st.setString(3, entity.getPhoneNumber());
        st.setInt(4, entity.getId());
        int result = st.executeUpdate();
        connection.closeConnection(st, conn);
        return result;
    }

    public int deleteById(int id) throws SQLException {
        st = conn.prepareStatement("delete from passengers where id = ?;");
        st.setInt(1, id);
        int result = st.executeUpdate();
        connection.closeConnection(st, conn);
        return result;
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
