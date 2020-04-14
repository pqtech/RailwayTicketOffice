package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DaoInterface<T> {
    int create(T entity) throws SQLException;
    T getById(int id) throws SQLException;
    int update(T entity) throws SQLException;
    int deleteById(int id) throws SQLException;
    ArrayList<T> readAll() throws SQLException;

}
