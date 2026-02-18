package main;

import dao.ComplaintDAO;
import dao.UserDAO;
import java.util.List;
import java.util.Scanner;
import model.Complaint;
import model.User;

public class MainApp {
    static Scanner sc =new Scanner(System.in);
    static UserDAO userDao =new UserDAO();
    static ComplaintDAO complaintDAO= new ComplaintDAO();

    public static void main(String[] args){

        while(true){
            System.out.println("\n--COMPLAINT MANAGEMENT SYSTEM--");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. EXIT");
            System.out.print("choose option:");
             //Here we use so that cursor will stay on same line after printing the message

            
            int choice = sc.nextInt(); //Takes user input 1,2,3 || leaves ne wlin ein buffer
            sc.nextLine(); // clears the buffer after reading an integer 

            switch (choice){
                case 1 -> register();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Thank you");
                    System.exit(0); // stops program immediately

                }
                default -> System.out.println("invalid choice");    //if user enters value other than 1,2,3 then it print this default output
    
            }
        }
    }
    //---------------- REGISTRATION CODE -------------------
     static void register(){
        System.out.println("\n--USER REGISTRATION--");

        System.out.println("Name:");
        String name = sc.nextLine();

        System.out.println("Email:");
        String email = sc.nextLine();

        System.out.println("password:");
        String password = sc.nextLine();

        System.out.println("Role (user/admin):");
        String role = sc.nextLine();

        User user = new User(name,email,password,role);

        boolean success = userDao.register(user);
        if(success){
            System.out.println("Registration Successfull");
        }
        else{
            System.out.println("Registration failed");
        }
    }

        //-----------LOGIN PART-------------
    static void login(){
        System.out.println("\n--LOGIN-- ");

        System.out.println("Name: ");
        String name = sc.nextLine();

        System.out.println("password: ");
        String password = sc.nextLine();

        User user = userDao.login(name,password);
        
        if(user == null){
            System.out.println("INVALID CREDENTIALS");
            return;
        }
        System.out.println("WELCOME" + user.getname());
        
        if (user.getrole().equalsIgnoreCase("admin")) {
        adminMenu();
    } else {
        userMenu(user);
    }
}
// ------USER MENU (ADD, VIEW,LOG OUT) -------
static void userMenu(User user){
    System.out.println("---USER MENU--");
    System.out.println("1.Add Complaint");
    System.out.println("2.View Complaint");
    System.out.println("3. Logout");
    System.out.print("Choose option: ");

    int choice = sc.nextInt();
    sc.nextLine();

    switch (choice) {
        case 1 -> addComplaint(user);

        case 2 -> viewMyComplaints(user);

        case 3 ->{
            System.out.println("Logged out successfully");
            return;
        }
    
    default -> System.out.println("invalid choice");
    }

}
static void adminMenu(){
    System.out.println("Admin menu coming next...");
}
//------------AddComplaint--------

public static void addComplaint(User user){
    System.out.println("--ADD COMPLAINT--");

    System.out.println("TITLE: ");
    String title = sc.nextLine();

    System.out.println("DESCRIPTION:");
    String Description = sc.nextLine();

    Complaint complaint = new Complaint(
        user.getid(),
        title,
        Description
    );
    
    boolean success = complaintDAO.addComplaint(complaint);
    if(success){
        System.out.println("Complaint Added successfully");
    }else{
        System.out.println("Failed to add Complaint");
    }
}
//------------VIEW COMPLAINTS---------
static void viewMyComplaints(User user){
    System.out.println("\n--- MY COMPLAINTS ---");

    List<Complaint> list =  complaintDAO.getComplaintsByUser(user.getid());

    if(list.isEmpty()){
        System.out.println("No complaints found");
        return;
    }
    for(Complaint c: list){
         System.out.println(
                "ID: " + c.getId() +
                " | Title: " + c.getTitle() +
                " | Status: " + c.getStatus()
        );
    }
}

//------UPDATE COMPLAINT STATUS ---------
static void updateComplaintStatus(){
    System.out.println("----UPDATE COMPLAINT STATUS------");

    System.out.println("Enter Complaint ID :");
    int id  =sc.nextInt();
    sc.nextLine();

    System.out.println("Enter comoplaint status(Pending /Resolved)");
    String status = sc.nextLine();

    boolean success = complaintDAO.updateComplaintStatus(id, status);

    if(success){
        System.out.println("Complaint status Updated successfully");
    }
    else{
        System.out.println("Failed to update Complaint Status");
    }

}
}


//COMPLETE FLOW
//login as user


//1.add complaint
//2.view complaint
//3.logout -> back to main menhu