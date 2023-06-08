package co.edu.sena.project2687351.servlet;
import co.edu.sena.project2687351.model.Repository.CategoryRepositoryImpl;
import co.edu.sena.project2687351.model.Repository.ProductRepositoryImpl;
import co.edu.sena.project2687351.model.Repository.Repository;


import co.edu.sena.project2687351.model.bean.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet("register_product")
public class ProductRegisterServlet extends HttpServlet {

    public ProductRegisterServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_name = request.getParameter("product_name");
        String product_value = request.getParameter("product_value");
        String category_id = request.getParameter("category_id");
        Product product = new Product();
        product.setProduct_name(product_name);
        product.setProduct_value(Float.valueOf(product_value));
        product.setCategory_id(Integer.valueOf(category_id));
        CategoryRepositoryImpl repository = new CategoryRepositoryImpl();
        boolean rows = false;

        try {
            repository.saveObj(product);
        } catch (SQLException var8) {
            var8.printStackTrace();
        }

        if (!rows) {
            System.out.println("Ocurrio un error");
        } else {
            System.out.println("Registro exitoso");
        }

    }
}
