package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Complaint;
import util.DBConnection;

public class ComplaintDAO {

    // Add a complaint
    public boolean addComplaint(Complaint complaint) {

        String sql = "INSERT INTO complaints (user_id, title, description, status) VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection(); // without connection java cannot talk without databases || SQL cannot run
            PreparedStatement ps = con.prepareStatement(sql); // hides username/password || creates one reusable connection ||Prepared Statement is Safe

            ps.setInt(1, complaint.getUserId());
            ps.setString(2, complaint.getTitle());
            ps.setString(3, complaint.getDescription());
            ps.setString(4, complaint.getStatus());

            return ps.executeUpdate() > 0;
            // There are three execution methods :
            //1.executeUpdate : SSLECT,INSERT,UPDATE ( we modify database thats why we use this execute update)
            //2.executeQuery : SELECT
            //3.execute :  Rare/mixed
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Get complaints by user
    public List<Complaint> getComplaintsByUser(int userId) {

        List<Complaint> list = new ArrayList<>(); //user can have 0 complaint ,1-100 complaints
        String sql = "SELECT * FROM complaints WHERE user_id = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Complaint c = new Complaint();
                c.setId(rs.getInt("id"));
                c.setUserId(rs.getInt("user_id"));
                c.setTitle(rs.getString("title"));
                c.setDescription(rs.getString("description"));
                c.setStatus(rs.getString("status"));
                c.setCreatedAt(rs.getTimestamp("created_at"));

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

//ADMIN PART: VIEW ALLL COMPLAINTS

public List<Complaint> getAllComplaints(){

    List<Complaint> list = new ArrayList<>();

    String sql = "SELECT * FROM complaints";

    try{
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();


        while(rs.next()){
            Complaint c = new Complaint();

            c.setId(rs.getInt("id"));
            c.setUserId(rs.getInt("user_id"));
            c.setTitle(rs.getString("title"));
            c.setDescription(rs.getString("description"));
            c.setStatus(rs.getString("status"));
            c.setCreatedAt(rs.getTimestamp("created_at"));


            list.add(c);
        }
        }
        catch(Exception e){
            e.printStackTrace();

        
    }
    return list;

}

//ADMIN : UPDATE COMPLAINT STATUS

public boolean updateComplaintStatus(int Complaint_id ,String status){

    String sql ="UPDATE complaints SET status = ? WHERE id =?";

    try {
        Connection con =  DBConnection.getConnection();
        PreparedStatement ps =con.prepareStatement(sql);

        ps.setString(1,status);
        ps.setInt(2,Complaint_id);

        return ps.executeUpdate()>0;

    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
}// Bracket of class bcz it should parse upto here (at the end of the file)