package co.edu.sena.project2687351.model.Repository;

import co.edu.sena.project2687351.model.bean.Product;


import java.sql.SQLException;

public class TestProductRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        co.edu.sena.project2687351.model.Repository.Repository<Product> repository = (co.edu.sena.project2687351.model.Repository.Repository<Product>) new co.edu.sena.project2687351.model.Repository.ProductRepositoryImpl();

        System.out.println("========== saveObj Insert ==========");  //insert
        Product productInsert = new Product();
        productInsert.setProduct_name("raza");
        productInsert.setProduct_value(2312f);
        productInsert.setCategory_id(1);

        repository.saveObj(productInsert);

        System.out.println("========== listAllObj ========== ");
        repository.listAllobj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== byIdObj ==========");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("========== saveObj ========== "); //update
        Product productUpdate = new Product();
        productUpdate.setProduct_id(2);
        productUpdate.setProduct_name("raza");
        productUpdate.setProduct_value(12123f);
        productUpdate.setCategory_id(1);
        repository.saveObj(productUpdate);
        repository.listAllobj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== deleteObj ==========");
        repository.deleteObj(4);
        repository.listAllobj().forEach(System.out::println);
    }
} // TestProductRepositoryImpl
