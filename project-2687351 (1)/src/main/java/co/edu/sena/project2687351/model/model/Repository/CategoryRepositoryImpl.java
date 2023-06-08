//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.sena.project2687351.model.Repository;

import co.edu.sena.project2687351.util.DBConnection;
import co.edu.sena.project2687351.model.bean.Category;
import java.util.*;
import java.sql.*;

public class CategoryRepositoryImpl implements Repository {
    private String sql= null;

    public Category createObj(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setCategory_id(rs.getInt("category_id"));
        category.setCategory_name(rs.getString("category_name"));



        return category;
    }

    @Override
    public List listAllobj() throws SQLException {
        sql = "select c.category_id, c.category_name " +
                "from category c order by category_id, category_name";
        List<Category> category = new ArrayList<>();
        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql))

        {
            while (rs.next()){
                Category c = createObj(rs);
                category.add(c);
            }
        }
        return category;
    }

    @Override
    public Object byIdObj(Integer id) throws SQLException {
        sql = "select c.category_id, c.category_name "+
                "from category c where c.category_id = ?";
        Category category = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    category = createObj(rs);
                }
            }
        }
        return category;
    }

    @Override


    //@Override
    public Integer saveObj(Object o) throws SQLException {
        int rowsAffected = 0;
        if (Category.getCategory_id() !=null && Category.getCategory_id() > 0){
            sql = "update category set category_name = ?"+
                    "where category_id = ?";
        }
        else{
            sql= "insert into category (category_name)"+ "values(upper(?))";
        }

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,Category.getCategory_name());
            if (Category.getCategory_id() != null && Category.getCategory_id()>0){
                ps.setInt(2, Category.getCategory_id());
            }
            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql = "delete from category where category_id =?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }

    }


}
