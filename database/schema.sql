-- Complaint Management System Database Schema

CREATE DATABASE IF NOT EXISTS complaint_system;
USE complaint_system;

-- Users Table
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50) UNIQUE,
    password VARCHAR(50),
    role VARCHAR(10)
);

-- Complaints Table
CREATE TABLE complaints (
    complaint_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    title VARCHAR(100),
    description TEXT,
    status VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Default Admin Account
INSERT INTO users (name, email, password, role)
VALUES ('Admin', 'admin@cms.com', 'admin123', 'admin');
