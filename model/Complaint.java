package model;

import java.sql.Timestamp;

public class Complaint {

    private int id;
    private int userId;
    private String title;
    private String description;
    private String status;
    private Timestamp createdAt;

    // zero paramet constructor || Required for framework (JDBC ,Spring)
    public Complaint() {
    }

    // Constructor for new complaint || parametrized contructor when we create objects manually
    public Complaint(int userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.status = "Pending";
    }

    // getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
