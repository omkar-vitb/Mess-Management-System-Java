# 🍽️ Mess Management System (Java + MySQL)

A complete Object-Oriented Java application designed to manage hostel/mess student records. This project transitions from a volatile RAM-based array system to a robust, permanent **MySQL** database architecture. It features a text-based admin console and a **Java Swing** graphical dashboard for real-time viewing.

## 💡 The Problem Statement
I am Living in Ashtha where  i noticed that most local hostel and mess in-charges still rely on traditional, outdated pen-and-paper methods to manage their student data. Tracking important details—like when a student joined, or whether they opted for just a lunch pass or both meals—is entirely manual. I recognized that this old method was inefficient, hard to search through, and prone to data loss. I built this autonomous system to solve that exact problem, bringing their daily operations into a secure, digital database.

## 🚀 Core Features
*   **Database Persistence:** Permanent data storage using MySQL and JDBC.
*   **CRUD Operations:** Add, View, Search, Update, and Remove students dynamically.
*   **Automated Billing:** Generates physical `.txt` invoice receipts for students using Java File I/O.
*   **Real-Time Dashboard:** A Java Swing UI that instantly displays the live database roster.
*   **Custom Exception Handling:** Prevents duplicate student IDs from crashing the database.
*   **Smart Date Tracking:** Automatically stamps new entries with their exact join date.

## 📸 Project Screenshots

### 1. MySQL Database Live View
*<img width="1238" height="1002" alt="Screenshot 2026-09-15 001614" src="https://github.com/user-attachments/assets/b6bc76dc-8d45-4111-887f-4b330ad2f61e" />
*

### 2. Admin Console & Real-Time UI
*<img width="1911" height="1013" alt="Screenshot 2026-09-15 003105" src="https://github.com/user-attachments/assets/036dc6af-5ec8-4614-b341-a8999e32849c" />
*

## 🛠️ Technology Stack
*   **Language:** Java (JDK 8+)
*   **Database:** MySQL Server 8.0+
*   **Libraries:** Java Swing (UI), JDBC (`mysql-connector-j.jar`)

## ⚙️ Setup & Installation

**1. Database Configuration**
* Open MySQL Workbench.
* Navigate to the `database/` folder, copy the contents of `database.sql`, and execute the script to build the `MessManagementDB` and the `students` table.

**2. Java Configuration**
* Clone this repository to your local machine.
* Navigate to the `src/` folder and open `DBConnection.java`. Replace the password string with your actual MySQL root password.
* Ensure the `lib/mysql-connector-j-26.7.0.jar` file is added to your IDE's referenced libraries.

**3. Running the Application**
* Run the `MessManagement.java` file (located in `src/`) to open the interactive Admin Terminal.
* Run the `EnrolledStudentUI.java` file (located in `src/`) to open the live graphical dashboard.
