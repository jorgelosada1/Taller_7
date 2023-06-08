package co.edu.sena.project2687351.model.Repository;


import java.util.*;
import java.sql.*;

public interface Repository<T> {
    List <T> listAllobj() throws SQLException;

    T byIdObj(Integer id) throws SQLException;

    Integer saveObj(T t) throws SQLException;

    void deleteObj(Integer id) throws SQLException;

    T createObj(ResultSet rs) throws SQLException;
}
