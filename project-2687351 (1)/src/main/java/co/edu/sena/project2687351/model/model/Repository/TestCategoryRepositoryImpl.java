package co.edu.sena.project2687351.model.Repository;

import co.edu.sena.project2687351.model.bean.Category;
import co.edu.sena.project2687351.model.bean.User;

import java.sql.SQLException;

public class TestCategoryRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        co.edu.sena.project2687351.model.Repository.Repository<Category> repository = (co.edu.sena.project2687351.model.Repository.Repository<Category>) new co.edu.sena.project2687351.model.Repository.CategoryRepositoryImpl();

        System.out.println("========== saveObj Insert ==========");  //insert
        Category categoryInsert = new Category();
        categoryInsert.setCategory_name("raza");

        repository.saveObj(categoryInsert);

        System.out.println("========== listAllObj ========== ");
        repository.listAllobj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== byIdObj ==========");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("========== saveObj ========== "); //update
        Category categoryUpdate = new Category();
        categoryUpdate.setCategory_id(2);
        categoryUpdate.setCategory_name("raza");
        repository.saveObj(categoryUpdate);
        repository.listAllobj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== deleteObj ==========");
        repository.deleteObj(2);
        repository.listAllobj().forEach(System.out::println);
    }
}
