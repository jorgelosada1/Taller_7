package co.edu.sena.project2687351.servlet;

import co.edu.sena.project2687351.model.Repository.Repository;
import co.edu.sena.project2687351.model.Repository.UserRepositoryImpl;
import co.edu.sena.project2687351.model.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("register_User")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String user_firstname = request.getParameter("user_firstname");
        String user_lastname = request.getParameter("user_lastname");
        String user_email = request.getParameter("user_email");
        String user_password = request.getParameter("user_password");



        User user = new User();
        user.setUser_firstname(user_firstname);
        user.setUser_lastname(user_lastname);
        user.setUser_email(user_email);
        user.setUser_password(user_password);



        Repository<User> repository = new UserRepositoryImpl();
        int rows = 0;
        try{
            repository.saveObj(user);
        } catch (SQLException e){
            e.printStackTrace();
        }

        // todo prepare an information message for user about success or failure of the operation

        if (rows == 0){
            System.out.println("ocurrio un error");
        }else{
            System.out.println("Registro exitoso");
        }

        // todo todo write  the message back to page in client browser
    }
}
