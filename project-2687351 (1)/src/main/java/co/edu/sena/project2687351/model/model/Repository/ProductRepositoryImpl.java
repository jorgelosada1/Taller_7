package co.edu.sena.project2687351.model.Repository;

import co.edu.sena.project2687351.model.bean.Product;
import co.edu.sena.project2687351.util.DBConnection;

import java.util.*;
import java.sql.*;

public class ProductRepositoryImpl {
    private String sql= null;

    public Product createObj(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setProduct_id(rs.getInt("product_id"));
        product.setProduct_name(rs.getString("product_name"));
        product.setProduct_value(Float.valueOf(rs.getString("product_value")));
        product.setCategory_id(Integer.valueOf(rs.getString("category_id")));


        return product;
    }


    public List listAllObj() throws SQLException {
        sql = "select p.product_id, p.product_name, p.product_value, c.category_id " +
                "from products p order by p.product_id, p.product_name";
        List<Product> products = new ArrayList<>();
        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql))

        {
            while (rs.next()){
                Product p = createObj(rs);
                products.add(p);
            }
        }
        return products;
    }


    public Object byIdObj(Integer id) throws SQLException {
        sql = "select p.product_id, p.product_name, p.product_value, c.category_id "+
                "from products p where p.products_id = ?";
        Product product = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    product = createObj(rs);
                }
            }
        }
        return product;
    }


    public Integer saveObj(Object o) throws SQLException {
        int rowsAffected = 0;
        if (Product.getProduct_id() !=null && Product.getProduct_id() > 0){
            sql = "update products set products_name = ?, products_value = ?, category_id =?,"+ "where products_id = ?";
        } else {
            sql = "insert into products (products_name, products_value, category_id)"+
                    "values(upper(?), upper(?), lower(?), ";
        }

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,Product.getProduct_name());
            ps.setString(2, String.valueOf(Product.getProduct_value()));
            ps.setString(3, String.valueOf(Product.getCategory_id()));
            if (Product.getProduct_id() != null && Product.getProduct_id()>0){
                ps.setInt(4, Product.getProduct_id());
            }
            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }


    public void deleteObj(Integer id) throws SQLException {
        sql = "delete from products where products_id =?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }

    }


}