import java.io.FileWriter;
import java.io.IOException;



    public class BillGenerator{
        public static void generateBillFile(Student s){
            String fileName=s.getName().replaceAll(" ","_")+"Bill.txt";

            try(FileWriter writer=new FileWriter(fileName)){
                writer.write("=================================");
                System.out.println();
                writer.write("MESS MONTHLY INVOICE");
                System.out.println();

            writer.write("=====================================");
            System.out.println();
            writer.write("Student Name: "+s.getName());
            System.out.println();
            writer.write("Serial No: "+s.getSerialNo());
            System.out.println();
            writer.write("Join Date: "+s.getJoinDate());
            System.out.println();
            writer.write("Lunch Included: " +(s.includeLunch()?"Yes":"No"));
            System.out.println();
            writer.write("Dinner Included: "+(s.includeDinner()?"Yes":"No"));
            System.out.println();
            writer.write("-------------------------------------");
            System.out.println();
            writer.write("TOTAL AMOUNT DUE: Rs."+s.getMonthlyPrice());
            System.out.println();
            writer.write("=====================================");
            System.out.println();

            System.out.println("Success! Bill saved as "+fileName+" in the project folder.");
        }catch (IOException e){
            System.out.println("Error generating bill: "+e.getMessage());
            
            }
        }
    }
    

