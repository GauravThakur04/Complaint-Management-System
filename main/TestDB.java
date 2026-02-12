package main;
import dao.UserDAO;
import model.User;
import util.DBConnection;

public class TestDB {

    public static void main(String[] args) {

        System.out.println("MAIN METHOD REACHED");

        if (DBConnection.getConnection() != null) {
            System.out.println("Database connected successfully");
        } else {
            System.out.println("Database connection failed");
        }


        User user = new User(
            "Gaurav",
            "gtvecna@gmail.com",
            "1234566",
            "user");

            UserDAO dao = new UserDAO();

            if(dao.register(user)){
                System.out.println("user inserted successfully");

            }else{
                System.out.println("user insertion failed");
           }
        UserDAO dao1 = new UserDAO();

        User loggedInUser = dao1.login("test@test.com", "1234");
        if(loggedInUser != null){
            System.out.println("logeed in successfully");
            System.out.println("Welcome" + loggedInUser.getname());
            System.out.println("Role" + loggedInUser.getrole());
        }else{
            System.out.println("Invalid name or password");
        }

       
        }
    
}
