//This creates a read only visual dashboard for enrolled student , It talks directly to Mysql to display the live data(enrolled student in the mess).

import javax.swing.*;
import java.sql.*;


public class EnrolledStudentUI {
    public static void main(String[] args){
        JFrame frame=new JFrame("Mess student enrolled list");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea displayScreen=new JTextArea();
        displayScreen.setFont(new java.awt.Font("Monospaced",java.awt.Font.PLAIN,17));
        JScrollPane scrollPane=new JScrollPane(displayScreen);

        try(Connection conn=DBConnection.getConnection();
             Statement stmt=conn.createStatement();
             ResultSet rs=stmt.executeQuery("SELECT * FROM students")) {

            displayScreen.append(String.format("%-5s |%-15s |%-6s|%-6s|%-10s|%-12s\n", "ID","Name","Lunch","Dinner","Price(Rs)","Join Date"));

             displayScreen.append("----------------------------------------------------------------------------------------------\n");

            // Here looping through every single row foun in databse and formatting it neatly so columns align perfectly.
             while(rs.next()){
                int id=rs.getInt("serialNo");
                String studentName=rs.getString("name");
                boolean lunch=rs.getBoolean("includeLunch"); 
                boolean dinner=rs.getBoolean("includeDinner");
                double price=rs.getDouble("monthlyPrice");
                Date dateJoined=rs.getDate("joinDate");
                displayScreen.append(String.format("%-5d | %-15s | %-6s | %-6s | %-10.1f | %-12s\n", 
                 id, studentName, (lunch ? "Yes" : "No"),(dinner?"Yes":"No"),price, dateJoined));
            }
         
            // catch block is used here.
        }catch (SQLException e){
            displayScreen.setText("Could not connect to database:"+e.getMessage());
        }

        frame.add(scrollPane);
        frame.setVisible(true);
                           
            
    
    }
    
}

