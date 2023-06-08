package co.edu.sena.project2687351.model.Repository;

import co.edu.sena.project2687351.model.bean.User;
import co.edu.sena.project2687351.util.DBConnection;

import java.util.*;
import java.sql.*;


public class UserRepositoryImpl implements Repository{
    private String sql= null;

    public User createObj(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setUser_firstname(rs.getString("user_firstname"));
        user.setUser_lastname(rs.getString("user_lastname"));
        user.setUser_password(rs.getString("user_password"));
        user.setUser_email(rs.getString("user_email"));


        return user;
    }

    @Override
    public List listAllobj() throws SQLException {
        sql = "select u.user_id, u.user_firstname, u.user_lastname, u.user_email, u.user_password " +
                "from users u order by u.user_lastname, u.user_firstname";
        List<User> users = new ArrayList<>();
        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql))

        {
          while (rs.next()){
              User u = createObj(rs);
              users.add(u);
          }
        }
        return users;
    }

    @Override
    public Object byIdObj(Integer id) throws SQLException {
        sql = "select u.user_id, u.user_firstname, u.user_lastname, u.user_email, u.user_password "+
                "from users u where u.user_id = ?";
        User user = null;
        try (Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    user = createObj(rs);
                }
            }
        }
        return user;
    }

    @Override
    public Integer saveObj(Object o) throws SQLException {
        int rowsAffected = 0;
        if (User.getUser_id() !=null && User.getUser_id() > 0){
            sql = "update users set user_firstname = ?, user_lastname = ?, user_email =?,"+
                    "user_password = aes_encrypt (?, '$2a$12$cyYB1dwpDKIwc8DTy9L/..pyz/n5pGuGMQXJONLfI1t.GFcWxnEfC')"+
                    "where user_id = ?";
        } else {
            sql = "insert into users (user_firstname, user_lastname, user_email, user_password)"+
                    "values(upper(?), upper(?), lower(?), "+
                    "aes_encrypt(?,'$2a$12$cyYB1dwpDKIwc8DTy9L/..pyz/n5pGuGMQXJONLfI1t.GFcWxnEfC'))";
        }

        try(Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,User.getUser_firstname());
            ps.setString(2,User.getUser_lastname());
            ps.setString(3,User.getUser_email());
            ps.setString(4,User.getUser_password());
            if (User.getUser_id() != null && User.getUser_id()>0){
                ps.setInt(5, User.getUser_id());
            }
            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql = "delete from users where user_id =?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }

    }


}
