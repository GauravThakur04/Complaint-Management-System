# Complaint Management System
## User
- User Registration & Login
- Raise a Complaint
- View Own Complaints
- Update Complaint Details
- Logout

## Admin
- Admin Login
- View All Complaints
- Update Complaint Status (Pending / In Progress / Resolved)
- Manage User Complaints

## Tech Stack
- Language: Java
- Database: MySQL
- Backend: JDBC
- Architecture: DAO (Data Access Object) Pattern
- Version Control: Git & GitHub
## Modules
- User Registration
- User Login
- Add Complaint
- Check Complaint status
- Admin Login
- Update Complaint status


## How to Run the Project
git clone https://github.com/GauravThakur04/Complaint-Management-System.git
cd Complaint-Management-System

Create MySQL database

Run SQL scripts from database/ folder

Update DB credentials in:

util/DBConnection.java

javac -cp "lib/mysql-connector-j-9.6.0.jar:." main/MainApp.java

java -cp "lib/mysql-connector-j-9.6.0.jar:." main.MainApp

Key Concepts Used
- OOPS
- Interface
- JDBC with PreparedStatement
- DAO Design Pattern
- Role-Based Access Control
- Exception Handling (try, catch) 
- SQL Constraints (UNIQUE email)
- Git version control best practices

### not included till now
- email Notification
- OTP verification
- chart and analytics
- Spring Boot REST API version
- Web UI (React / JSP)



## Project Structure
- dao
- model
- util

### DAO(Data access Object)

- it's job is to talk Databases only(no Business Logic ,no UI)




## Author
- Gaurav Thakur
- 💻 Java Developer | Backend Enthusiast
- GitHub: https://github.com/GauravThakur04