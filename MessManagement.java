
import java.sql.*;
import java.util.Scanner;

public class MessManagement {
    private static Scanner scanner=new Scanner(System.in);

    private static final double LUNCH_ONLY_PRICE= 2000.0;
    private static final double DINNER_ONLY_PRICE=2000.0;
    private static final double BOTH_MEALS_PRICE=3600.0;

    public static void main(String[] args){
        System.out.println("  ___ __  __ _  __  _   ___  ");
System.out.println(" / _ \\  \\/  | |/ / /_\\ | _ \\ ");
System.out.println("| (_) | |\\/| | ' </ _ \\|   / ");
System.out.println(" \\___/|_|  |_|_|\\_\\/ \\_\\_|_\\ ");
System.out.println("   MESS MANAGEMENT SYSTEM    ");
System.out.println("=============================");
        System.out.println("Connecting to MYSQL DATAbase....");

        int choice=0;

        // This is the infinite loop that keeps running until  the user decide to press exit that is option 9
        do{
            System.out.println("===== OMKAR MESS MANAGEMENT SYSTEM ");
            System.out.println("1. Add student");
            System.out.println("2. view all student");
            System.out.println("3. Search student");
            System.out.println("4. Update student");
            System.out.println("5. Remove student");
            System.out.print("6. Kitchen report ");
            System.out.println();
            System.out.print("7. Total monthly revenue ");
            System.out.println();
            System.out.print("8. Generate student bill");
            System.out.println();
            System.out.print("9. Exit");
            System.out.println();
            System.out.print("Enter your choice (1-9)");

            try{
                choice=Integer.parseInt(scanner.nextLine());
                switch(choice){
                    case 1:addStudent();
                    break;
                    case 2:viewAllStudents();
                    break;
                    case 3:searchStudent();
                    break;
                    case 4:updateStudent();
                    break;
                    case 5:removeStudent();
                    break;
                    case 6:kitchenReport();
                    break;
                    case 7:showTotalRevenue();
                    break;
                    case 8: handleBilling();
                    break;
                    case 9:System.out.println("Exiting System'' All data is safely stored in MYSQL");
                    break;
                    default:System.out.println("Invalid choice please select 1-9");
                }
            }catch(NumberFormatException e){
                System.out.println("Error: please enter a valid number!");
            }

        }while(choice!=9);
    }

    private static double calculatePrice(boolean includeLunch,boolean includeDinner){
        if(includeLunch && includeDinner){
            return BOTH_MEALS_PRICE;
        }
        if(includeLunch){
            return LUNCH_ONLY_PRICE;
        }
        if(includeDinner){
            return DINNER_ONLY_PRICE;
        }
        else{
            return 0.0;
        }        
    }

    private static void addStudent(){
        try(Connection conn=DBConnection.getConnection()){
            System.out.print("Enter serial no: ");
            int serialNo=Integer.parseInt((scanner.nextLine()));

            // before adding a new student i am quering the databse to see if this id is already taken or   not . if it is then i throw custom exceptiom so the system dont crash
            String checkSql="SELECT serialNo FROM students WHERE serialNo=?";
            PreparedStatement checkStmt=conn.prepareStatement(checkSql);
            checkStmt.setInt(1,serialNo);
            ResultSet rs=checkStmt.executeQuery();
            if(rs.next()){
                throw new DuplicateSerialException("serial No "+serialNo+" is already taken in the database!");

            }
        System.out.print("Enter name:");
        String name=scanner.nextLine();
        System.out.print("Include monthly lunch? (yes/no: )");
        boolean includeLunch=scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("include monthly dinner? (yes/no: )");
        boolean includeDinner=scanner.nextLine().equalsIgnoreCase("yes");

        if(!includeLunch && !includeDinner){
            System.out.println("Student must opt for one meal atleast");
            return;
        }
        double price=calculatePrice(includeLunch,includeDinner);
        String insertSql="INSERT INTO students (serialNo,name,includeLunch, includeDinner,monthlyPrice) VALUES (?,?,?,?,?)";

            PreparedStatement insertStmt=conn.prepareStatement(insertSql);
            insertStmt.setInt(1,serialNo);
            insertStmt.setString(2,name);
            insertStmt.setBoolean(3,includeLunch);
            insertStmt.setBoolean(4,includeDinner);
            insertStmt.setDouble(5,price);
            insertStmt.executeUpdate();
            System.out.println("Success! student added to MYSQL databse");
    }
    catch(DuplicateSerialException e){
        System.out.println("CUSTOM ERROR: " +e.getMessage());
        }catch (SQLException e){
            System.out.println("Database error: " +e.getMessage());
        }catch (Exception e){
            System.out.println("General error: invalid input.");
        }  
    }

    // here this is used to view all the students who already enrolled 
    private static void viewAllStudents(){
        try(Connection conn=DBConnection.getConnection()) {
            String sql="SELECT * FROM students";
            PreparedStatement stmt=conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            System.out.println("\n--- All students in database ---");
            boolean found=false;
            while(rs.next()){
                found=true;
                System.out.println("ID: " +rs.getInt("serialNo")+
                   " | Name: " + rs.getString("name")+
                   " | Lunch: " + (rs.getBoolean("includeLunch") ? "Yes" : "No")+
                   " | Dinner: "+(rs.getBoolean("includeDinner") ? "Yes" : "No")+
                   " | Price: Rs."+rs.getDouble("monthlyPrice")+
                   " | Joined: "+rs.getDate("joinDate"));
            }
            if (!found){
                System.out.println("No students found in the database.");
            }
        }catch(SQLException e){
            System.out.println("Database error: " +e.getMessage());
        }
    }

    // this can be used to search for a particular student by serial no/id
    private static void searchStudent(){
        System.out.print("Enter serial no to search: ");
        try(Connection conn=DBConnection.getConnection()){
            int serialNo=Integer.parseInt(scanner.nextLine());
            
            String sql="SELECT * FROM students WHERE serialNo=?";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setInt(1, serialNo);
            ResultSet rs=stmt.executeQuery();
            
            if(rs.next()){
                System.out.println("--- Student Found ---");
                System.out.println("ID: "+rs.getInt("serialNo")+
                   " | Name: "+rs.getString("name")+
                   " | Lunch: "+(rs.getBoolean("includeLunch")? "Yes" : "No") +
                   " | Dinner: "+(rs.getBoolean("includeDinner") ?"Yes": "No") +
                   " | Price: Rs."+rs.getDouble("monthlyPrice") +
                   " | Joined: "+rs.getDate("joinDate"));
            }else {
                System.out.println("Student with Serial No "+serialNo+" not found.");
            }
        }catch(SQLException e){
             System.out.println("Database error: "+e.getMessage());
        }catch(Exception e){
            System.out.println("Invalid input.");
        }
    }


    // this is used to update any student  choice in case of entered mistakely or want to chnage then this method can be used.
    private static void updateStudent(){
        System.out.print("Enter serial no of student to update: ");
        try(Connection conn=DBConnection.getConnection()){
            int serialNo=Integer.parseInt(scanner.nextLine());
            
            // Check if student exists
            String checkSql="SELECT * FROM students WHERE serialNo=?";
            PreparedStatement checkStmt=conn.prepareStatement(checkSql);
            
            checkStmt.setInt(1, serialNo);
            ResultSet rs=checkStmt.executeQuery();
            
            if(rs.next()){
                System.out.println("Current name: "+rs.getString("name"));
                
                System.out.print("Opt for lunch? (yes/no):");
                boolean newLunch=scanner.nextLine().equalsIgnoreCase("yes");

                System.out.print("Opt for dinner? (yes/no):");

                boolean newDinner=scanner.nextLine().equalsIgnoreCase("yes");
                
                if(!newLunch && !newDinner){
                    System.out.println("Student must have at least one meal. Update failed.");
                    return;
                }

                double newPrice=calculatePrice(newLunch,newDinner);
                
                String updateSql="UPDATE students SET includeLunch = ?, includeDinner = ?, monthlyPrice = ? WHERE serialNo = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setBoolean(1,newLunch);
                updateStmt.setBoolean(2,newDinner);


                updateStmt.setDouble(3,newPrice);

                updateStmt.setInt(4,serialNo);
                updateStmt.executeUpdate();

                System.out.println("Student details updated successfully in MySQL!");
            }else{
                System.out.println("Student not found.");
            }
        }catch(SQLException e){
             System.out.println("Database error: " + e.getMessage());
        }catch(Exception e){


            System.out.println("Invalid input.");
        }
    }

    //this can be used to remove any student from the list 

    private static void removeStudent(){
        System.out.print("Enter Serial No to remove:");
        try(Connection conn=DBConnection.getConnection()){


            int serialNo=Integer.parseInt(scanner.nextLine());
            
            String sql="DELETE FROM students WHERE serialNo = ?";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setInt(1, serialNo);
            
            int rowsAffected=stmt.executeUpdate();
            if(rowsAffected>0){


                System.out.println("Student removed successfully from MySQL.");
            }else{
                System.out.println("Student not found.");
            }
        }catch(SQLException e){
             System.out.println("Database error: " + e.getMessage());

        }catch (Exception e){

            System.out.println("Invalid input.");
        }
    }
     

    //this function is useful for manager to know how much food plate they need to prepare after checking from mysql that how many students are enrollled. 
     private static void kitchenReport(){
        try(Connection conn=DBConnection.getConnection()){
            String sql="SELECT includeLunch, includeDinner FROM students";
            PreparedStatement stmt=conn.prepareStatement(sql);

            ResultSet rs=stmt.executeQuery();
            
            int lunchCount=0;
            int dinnerCount=0;
            
            while(rs.next()){
                if(rs.getBoolean("includeLunch")) lunchCount++;
                if(rs.getBoolean("includeDinner")) dinnerCount++;
            }
            
            System.out.println("\n--- Kitchen preparation report ---");

            System.out.println("Total lunches to prepare today: "+lunchCount);
            System.out.println("Total dinners to prepare today: "+dinnerCount);

        }catch (SQLException e){

             System.out.println("Database error: " + e.getMessage());
        }
    }
 
    //this   function is used to show the total revenue.
    private static void showTotalRevenue(){
        try(Connection conn=DBConnection.getConnection()){
            String sql ="SELECT SUM(monthlyPrice) AS total FROM students";
            PreparedStatement stmt=conn.prepareStatement(sql);


            ResultSet rs= stmt.executeQuery();
            
            if(rs.next()){
                System.out.println("\n--- financial summary ---");


                System.out.println("Total Expected Monthly Revenue:Rs."+ rs.getDouble("total"));
            }
        }catch (SQLException e){

             System.out.println("Database Error:"+ e.getMessage());
        }
    }


// this functio is used to handle billing.
    private static void handleBilling(){
        System.out.print("Enter Serial No of student to generate bill:");
        try(Connection conn=DBConnection.getConnection()){
            int serialNo=Integer.parseInt(scanner.nextLine());
            
            String sql="SELECT * FROM students WHERE serialNo=?";


            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setInt(1, serialNo);
            ResultSet rs=stmt.executeQuery();
            
            if(rs.next()){
                
Student s=new Student(
    rs.getInt("serialNo"), 
    rs.getString("name"), 
    rs.getBoolean("includeLunch"), 
    rs.getBoolean("includeDinner"), 
    rs.getDouble("monthlyPrice"),
    rs.getDate("joinDate") // Added date retrieval here
);
                BillGenerator.generateBillFile(s);
            } else{
                System.out.println("Student not found.");
            }
        } catch(SQLException e){
             System.out.println("Database Error: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Invalid input.");
        }


    }


}
    
