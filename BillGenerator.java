// This file can be used to create a bill in .txt file to act as physical receipt.

import java.io.FileWriter;
import java.io.IOException;



    public class BillGenerator{
        public static void generateBillFile(Student s){
            String fileName=s.getName().replaceAll(" ","_")+"Bill.txt";

            try(FileWriter writer=new FileWriter(fileName)){
                writer.write("=================================\n");
                
                writer.write("MESS MONTHLY INVOICE\n");
                

            writer.write("=====================================\n");
           
            writer.write("Student Name: "+s.getName()+"\n");
            
            writer.write("Serial No: "+s.getSerialNo()+"\n");
           
            writer.write("Join Date: "+s.getJoinDate()+"\n");
            
            writer.write("Lunch Included: " +(s.includeLunch()?"Yes":"No")+"\n");
            
            writer.write("Dinner Included: "+(s.includeDinner()?"Yes":"No")+"\n");
            
            writer.write("-------------------------------------\n");
            
            writer.write("TOTAL AMOUNT DUE: Rs."+s.getMonthlyPrice()+"\n");
            
            writer.write("=====================================\n");
            

            System.out.println("Success! Bill saved as "+fileName+" in the project folder.");
        }catch (IOException e){
            System.out.println("Error generating bill: "+e.getMessage());
            
            }
            
        }


    }
    

