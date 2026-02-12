package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;
import util.DBConnection;

public class UserDAO{
    //inserting a new user
    public boolean register(User user){

        String sql = "INSERT INTO users(name,email,password, role) VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =con.prepareStatement(sql);

            ps.setString(1,user.getname());
            ps.setString(2,user.getemail());
            ps.setString(3,user.getpassword());
            ps.setString(4,user.getrole());
            
            int rows =ps.executeUpdate();
            return rows>0;


        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
                 
    }
    //inserting a new user (email,password)
    public User login(String email, String password){

        String sql ="SELECT * FROM users WHERE email =? AND password =?";

        try{
            Connection con =DBConnection.getConnection();
            PreparedStatement ps =con.prepareStatement(sql);

            ps.setString(1,email);
            ps.setString(2,password);

             ResultSet rs = ps.executeQuery();


             if(rs.next()){
                User user = new User();
                user.setid(rs.getInt("id"));
                user.setname(rs.getString("name"));
                user.setemail(rs.getString("email"));
                user.setpassword(rs.getString("password"));

                return user;
             }

        }catch(Exception e){
            e.printStackTrace();

        }
        return null;
    }

}

