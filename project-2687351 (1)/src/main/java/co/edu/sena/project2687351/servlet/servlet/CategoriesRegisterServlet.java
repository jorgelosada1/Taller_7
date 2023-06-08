//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.sena.project2687351.servlet;

import co.edu.sena.project2687351.model.Repository.CategoryRepositoryImpl;
import co.edu.sena.project2687351.model.bean.Category;
import co.edu.sena.project2687351.model.Repository.CategoryRepositoryImpl;
import co.edu.sena.project2687351.model.Repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("registerCategory")
public class  CategoriesRegisterServlet extends HttpServlet {
    public CategoriesRegisterServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category_name = request.getParameter("category_name");
        Category category = new Category();
        category.setCategory_name(category_name);
        CategoryRepositoryImpl repository = new CategoryRepositoryImpl();
        boolean rows = false;

        try {
            repository.saveObj(category);
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
