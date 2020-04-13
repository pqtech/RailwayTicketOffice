package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteConnection {

    private static final String driverName = "org.sqlite.JDBC";
    private static final String connectionString = "jdbc:sqlite:railwayTO.s3db";

    public Connection getConnection() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found!");
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            System.out.println("Can't get connection!");
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(ResultSet rs, PreparedStatement st, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Can't close connection!");
            e.printStackTrace();
        }
    }

    public void closeConnection(PreparedStatement st, Connection conn) {
        try {
            if (st != null) st.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Can't close connection!");
            e.printStackTrace();
        }
    }
}
