Employee Database App (Java + JDBC + MySQL)
-------------------------------------------
Project Overview
================

This is a simple Java console-based application that demonstrates how to connect a Java program to a MySQL database using JDBC.
The application performs basic CRUD operations (Create, Read, Update, Delete) on an Employee database.

Features
========

Add a new employee

View all employees

Update employee details

Delete an employee

Technologies Used
=================

Java (JDK 17 or later recommended)

MySQL Database

JDBC (Java Database Connectivity)

Eclipse IDE (for development)

Database Setup
================

Start MySQL server.

Create a database:

CREATE DATABASE employee_db;
USE employee_db;


Create a table:

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    role VARCHAR(100),
    salary DOUBLE
);

How to Run

Clone the repository:
-------------------

git clone https://github.com/Madhusekhar194/EmployeeDataBase.git
cd EmployeeDataBase


Open the project in Eclipse.
---------------------------

Add the MySQL JDBC driver (mysql-connector-j-8.0.xx.jar) to the project Build Path.

Update database credentials in DBConnection.java:

private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
private static final String USER = "root";
private static final String PASSWORD = "your_password";


Run Main.java as a Java Application.

Project Structure
==================

EmployeeDB/
 ├── src/
 │    ├── DBConnection/DBConnection.java
 │    ├── DAO/EmployeeDAO.java
 │    ├── Model/Employee.java
 │    └── Main/Main.java
 ├── lib/ (MySQL Connector JAR here)
 ├── .gitignore
 └── README.md
