-- this is the main blueprint to store all the students record permanently in mysql--

CREATE DATABASE MessManagementDB;
USE MessManagementDB;

CREATE TABLE students(
    serialNo INT PRIMARY KEY,
    name VARCHAR(100),
    includeLunch BOOLEAN,
    includeDinner BOOLEAN,
    monthlyPrice DOUBLE,
    joinDate DATE DEFAULT(CURRENT_DATE)
);
