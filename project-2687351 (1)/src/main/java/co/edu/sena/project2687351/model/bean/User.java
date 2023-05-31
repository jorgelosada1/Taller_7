package co.edu.sena.project2687351.model.bean;

public class User {
    private static Integer user_id;
    private static String user_firstname;
    private static String user_lastname;
    private static String user_password;
    private static String user_email;

    public User() {

    }

    public User(int user_id, String user_firstname, String user_lastname, String user_password, String user_email) {
        this.user_id = user_id;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_email = user_email;
        this.user_password = user_password;

    }


    public static Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public static String getUser_firstname() {
        return user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public static String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }
    public static String getUser_email() {
        return user_email;
    }

    public static void setUser_email(String user_email) {
        User.user_email = user_email;
    }
    public static String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }



    @Override
    public String toString() {
        return "user{" +
                "user_id=" + user_id +
                ", user_firstname='" + user_firstname + '\'' +
                ", user_lastname='" + user_lastname + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_email='" + user_email + '\'' +
                '}';
    }
}
