package services;

import dao.SQLitePassengerDAO;
import dao.SQLiteTicketDAO;

import java.sql.SQLException;

public class DeleteById {
    public int deletePassenger(int id) {
        int result = 0;
        try {
            result = new SQLitePassengerDAO().deleteById(id);
        } catch (SQLException e) {
            System.out.println("Can't delete the passenger!");
            e.printStackTrace();
        }
        return result;
    }

    public int deleteTicket(int id) {
        int result = 0;
        try {
            result = new SQLiteTicketDAO().deleteById(id);
        } catch (SQLException e) {
            System.out.println("Can't delete the ticket!");
            e.printStackTrace();
        }
        return result;
    }
}
