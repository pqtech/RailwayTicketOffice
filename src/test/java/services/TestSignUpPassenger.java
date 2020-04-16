package services;

import dao.SQLiteConnection;
import dao.SQLitePassengerDAO;
import entities.Order;
import entities.Passenger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestSignUpPassenger {

    Passenger passengerExpected = new Passenger();
    Passenger passengerActual = new Passenger();

    String testFirstName = "TestFirstName";
    String testSecondName = "TestSecondName";
    String testPhoneNumber = "+738349593293";

    @Test
    public void testGetOrders() throws SQLException {

        passengerExpected.setFirstName(testFirstName);
        passengerExpected.setSecondName(testSecondName);
        passengerExpected.setPhoneNumber(testPhoneNumber);
        int result = new SQLitePassengerDAO().create(passengerExpected);

        passengerActual = new SQLitePassengerDAO().getByPhoneNumber(testPhoneNumber);
        passengerExpected.setId(passengerActual.getId());
        Assert.assertEquals(passengerActual, passengerExpected);

    }

}
