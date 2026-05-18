# Z_Kart

Z_Kart is a Java-based console application that simulates an e-commerce management system. The project is designed using a modular structure with separate features for products, customers, orders, cart management, authentication, and utility handling.

This project demonstrates:

* Core Java concepts
* Object-Oriented Programming (OOP)
* Modular package structure
* DTO (Data Transfer Object) usage
* Console-based menu navigation
* Basic repository/database simulation
* Input validation and session handling

---

# Features

## Authentication

* User Sign Up
* User Login
* Role-based handling
* Password history management

## Product Management

* Add products
* View products
* Search products
* Product detail management

## Customer Management

* Add customers
* View customers
* Search customers
* Customer detail handling

## Order Management

* Create orders
* Manage orders
* Search orders
* Track order details and status

## Cart Management

* Add items to cart
* View cart details
* Manage cart items

## Utility Support

* Console input handling
* Session management
* Validation utilities

---

# Project Structure

```text
src/
│
├── Z_KartMain.java
│
└── com/gowri_manikandan/Z_Kart/
    │
    ├── features/
    │   ├── login/
    │   ├── signup/
    │   ├── product/
    │   ├── customer/
    │   ├── order/
    │   └── card/
    │
    ├── repository/
    │   ├── db/
    │   └── dto/
    │
    └── utils/
```

---

# Technologies Used

* Java
* OOP Principles
* Collections Framework
* Console-based UI

---

# Important Packages

## features

Contains all feature modules:

* Login
* Signup
* Product
* Customer
* Order
* Cart

Each feature generally contains:

* Model
* View
* Detail Management
* Search Management

## repository

Contains:

* DTO classes
* Database simulation classes

## utils

Contains helper utilities:

* ValidationUtil
* ConsoleUtil
* SessionManager

---

# DTO Classes

The application uses DTO classes for storing and transferring data.

Main DTOs:

* Product
* Customer
* Order
* OrderItem
* Card
* CardItem
* PasswordHistory
* Role
* OrderStatus

---

# How to Run the Project

## 1. Clone the Repository

```bash
git clone <repository-url>
```

## 2. Open in IDE

Recommended IDEs:

* IntelliJ IDEA
* Eclipse
* VS Code

## 3. Compile the Project

```bash
javac Z_KartMain.java
```

## 4. Run the Application

```bash
java Z_KartMain
```

---

# Application Flow

```text
Start Application
       ↓
 Login / Signup
       ↓
 Main Menu
       ↓
 Product / Customer / Order / Cart Modules
       ↓
 Manage Data
       ↓
 Exit
```

---

# Concepts Covered

This project demonstrates the following Java concepts:

* Classes and Objects
* Encapsulation
* Inheritance
* Abstraction
* Package Management
* Static Methods
* Collections
* Enums
* Validation Handling
* Modular Design

---

# Future Improvements

Possible enhancements:

* JDBC database integration
* File storage support
* GUI version using JavaFX or Swing
* REST API integration
* Payment module
* Admin dashboard
* Inventory management
* Unit testing

---

# Author

Developed by Gowri Manikandan.

---

# License

This project is created for learning and educational purposes.
