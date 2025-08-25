# 🗄️ JDBC Connectivity in Java

This project demonstrates how to connect a **Java application** with a **relational database** using **JDBC (Java Database Connectivity)**.  
It includes examples of performing basic **CRUD operations** and handling database interactions securely.

---

## 📌 Features
- Establish connection between Java and Database
- Perform **Insert, Select, Update, Delete** operations
- Use of **PreparedStatement** for safe query execution
- Proper exception handling and resource management
- Beginner-friendly, extendable into larger applications

---

## 🛠️ Tech Stack
- **Java (Eclipse IDE)**
- **JDBC API**
- **MySQL Database** (can be adapted to Oracle / PostgreSQL)

---


## Setup Database

1.Install MySQL (or your preferred database).

2.Create a database and table for testing:


```
create database jdbcdemo;
use jdbcdemo;
create table employe(
emp_id int primary key ,
emp_name varchar(30),
salary int
);

```

3.Configure Database Credentials


```
String url = "jdbc:mysql://localhost:3306/testdb";
String user = "root";
String password = "yourpassword";

```


## 3.📖 Learning Outcome

Understand the fundamentals of database connectivity in Java

Learn how to perform database operations programmatically

Build a strong foundation for projects like Bus Reservation System, ATM Management System, or Student Management System
