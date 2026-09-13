# 🍽️ Mess Management System (Java + MySQL)

A complete Object-Oriented Java application designed to manage hostel/mess student records. This project transitions from a volatile RAM-based array system to a robust, permanent **MySQL** database architecture. It features a text-based admin console and a **Java Swing** graphical dashboard for real-time viewing.

## 🚀 Core Features
*   **Database Persistence:** Permanent data storage using MySQL and JDBC.
*   **CRUD Operations:** Add, View, Search, Update, and Remove students dynamically.
*   **Automated Billing:** Generates physical `.txt` invoice receipts for students using Java File I/O.
*   **Real-Time Dashboard:** A Java Swing UI that instantly displays the live database roster.
*   **Custom Exception Handling:** Prevents duplicate student IDs from crashing the database.
*   **Smart Date Tracking:** Automatically stamps new entries with their exact join date.

## 🛠️ Technology Stack
*   **Language:** Java (JDK 8+)
*   **Database:** MySQL Server 8.0+
*   **Libraries:** Java Swing (UI), JDBC (`mysql-connector-j.jar`)

## ⚙️ Setup & Installation

**1. Database Configuration**
* Open MySQL Workbench.
* Copy the contents of `database.sql` and execute the script to build the `MessManagementDB` and the `students` table.

**2. Java Configuration**
* Clone this repository to your local machine.
* Open `DBConnection.java` and replace `"YOUR_MYSQL_PASSWORD"` with your actual MySQL root password.
* Ensure the `lib/mysql-connector-j.jar` file is added to your project's build path/referenced libraries.

**3. Running the Application**
* Run `MessManagementSystem.java` to open the interactive Admin Terminal.
* Run `MessDisplayUI.java` to open the live graphical dashboard.
