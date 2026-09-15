# Project Statement: Mess Management System


## Problem Statement
When I looked at the local hostels and mess facilities around Ashtha, I saw that the admins are still doing everything by hand. They use physical registers to track who is eating lunch or dinner, and figuring out the monthly bills takes forever. Because it's all on paper, its really easy to make mistakes or lose the data entirely. I wanted to build a simple digital solution to fix this exact problem and make their daily work a lot easier.



## Scope of the Project
This project is a desktop app that completely digitizes how a hostel mess works. It keeps track of student profiles and their daily meals (like if they only want dinner, or both meals). Then it automatically calculates the final monthly bill. It connects directly to a MySQL database so nothing gets lost, and it has both a text terminal for quick admin entry and a live graphical dashboard to see all the enrolled students.


## Target Users
*   **Mess Owners and Admins:** The main people who add new students and update their daily plans.
*   **Billing Staff:** Anyone who needs to look at the active plans and generate the final reciepts at the end of the month.



## High-Level Features
*   **MySQL Database Link:** Safely stores and updates all the student info without relying on paper.
*   **Custom Meal Plans:** You can easily switch a students plan to just lunch, just dinner, or both.
*   **Auto-Billing:** The system figures out the exact monthly fee based on what the student actually subscribed to.
*   **Live Dashboard:** A Java Swing UI screen that pulls up the live database list right away so admins can see who is currently active.
*   **Error Handling:** Added protections so if someone types the same student ID twice by accident, the program won't just crash.
