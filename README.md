# 🍽️ Mess Management System (Java + MySQL)

A complete Object-Oriented Java application designed to manage hostel/mess student records. This project transitions from a volatile RAM-based array system to a robust, permanent **MySQL** database architecture. It features a text-based admin console and a **Java Swing** graphical dashboard for real-time viewing.

## 💡 The Problem Statement
Living in Ashtha, I noticed that most local hostel and mess in-charges still rely on traditional, outdated pen-and-paper methods to manage their student data. Tracking important details—like when a student joined, or whether they opted for just a lunch pass or both meals—is entirely manual. I recognized that this old method was inefficient, hard to search through, and prone to data loss. I built this autonomous system to solve that exact problem, bringing their daily operations into a secure, digital database.

## 🚀 Core Features
*   **Database Persistence:** Permanent data storage using MySQL and JDBC.
*   **CRUD Operations:** Add, View, Search, Update, and Remove students dynamically.
*   **Automated Billing:** Generates physical `.txt` invoice receipts for students using Java File I/O.
*   **Real-Time Dashboard:** A Java Swing UI that instantly displays the live database roster.
*   **Custom Exception Handling:** Prevents duplicate student IDs from crashing the database.
*   **Smart Date Tracking:** Automatically stamps new entries with their exact join date.

## 📸 Project Screenshots

*(Showcasing the live database and UI without needing to run the code locally)*

### 1. MySQL Database Live View
*(<img width="1238" height="1002" alt="Screenshot 2026-09-15 001614" src="https://github.com/user-attachments/assets/b6bc76dc-8d45-4111-887f-4b330ad2f61e" />
)*
![MySQL Database View](<img width="1238" height="1002" alt="Screenshot 2026-09-15 001614" src="https://github.com/user-attachments/assets/859c2731-86df-4c4b-a2ef-4242dbde97fe" />
)

### 2. Admin Console & Real-Time UI
*(Add a screenshot of your terminal and the Java Swing Dashboard here)*
![UI Dashboard](link-to-your-ui-image.png)

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
* Open `DBConnection.java` and replace the password string with your actual MySQL root password.
* Ensure the `lib/mysql-connector-j.jar` file is added to your project's build path/referenced libraries.

**3. Running the Application**
* Run `MessManagement.java` to open the interactive Admin Terminal.
* Run `EnrolledStudentUI.java` to open the live graphical dashboard.
