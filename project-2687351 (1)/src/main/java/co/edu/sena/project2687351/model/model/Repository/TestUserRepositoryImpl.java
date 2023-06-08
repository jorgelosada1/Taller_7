package co.edu.sena.project2687351.model.Repository;

import co.edu.sena.project2687351.model.bean.User;


import java.sql.SQLException;

public class TestUserRepositoryImpl {

    public static void main(String[] args) throws SQLException {
        co.edu.sena.project2687351.model.Repository.Repository<User> repository = (co.edu.sena.project2687351.model.Repository.Repository<User>) new co.edu.sena.project2687351.model.Repository.UserRepositoryImpl();

        System.out.println("========== saveObj Insert ==========");  //insert
        User userInsert = new User();
        userInsert.setUser_firstname("Carlos");
        userInsert.setUser_lastname("Rojas");
        userInsert.setUser_email("carlos@gmail.com");
        userInsert.setUser_password("asdfg12345");
        repository.saveObj(userInsert);
        userInsert.setUser_firstname("pEpE");
        userInsert.setUser_lastname("perez");
        userInsert.setUser_email("PEPE@hotmail.com");
        userInsert.setUser_password("67890qwerty");
        repository.saveObj(userInsert);

        System.out.println("========== listAllObj ========== ");
        repository.listAllobj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== byIdObj ==========");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("========== saveObj ========== "); //update
        User userUpdate = new  User();
        userUpdate.setUser_id(2);
        userUpdate.setUser_firstname("jorge");
        userUpdate.setUser_lastname("losada");
        userUpdate.setUser_email("jorge@hotmail.com");
        userUpdate.setUser_password("12345asdfg");
        repository.saveObj(userInsert);
        repository.listAllobj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== deleteObj ==========");
        repository.deleteObj(2);
        repository.listAllobj().forEach(System.out::println);
    }
} // testUserRepositoryImpl