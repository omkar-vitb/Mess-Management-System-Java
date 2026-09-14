import java.sql.Date;

// This java file cretes the blueprint for a single student. It holds the variables that matches the column i createdin Mysql database.
public class Student 
    implements Subscriber{
        private int serialNo;
        private String name;
        private boolean includeLunch;
        private boolean includeDinner;
        private double monthlyPrice;
        private Date joinDate;

        public Student(int serialNo, String name,boolean includeLunch,boolean includeDinner, double monthlyPrice,Date joinDate){
            this.serialNo=serialNo;
            this.name=name;
            this.includeLunch=includeLunch;
            this.includeDinner=includeDinner;
            this.monthlyPrice=monthlyPrice;
            this.joinDate=joinDate;
        }

        // override function used which allows a subclass to provide it speciifc implemenatation of a method.
        @Override 
        public String getDetails(){
            return "ID"+ serialNo+" | Name: "+ name +" | joined: "+ joinDate;
        }

        @Override
        public double calculateMonthlyCost(){
            return monthlyPrice;
        } 

        //Getters methid  used to read the private object properties
        public int getSerialNo(){
            return serialNo;
        }
        public String getName(){
            return name;
        }
        public boolean includeLunch(){
            return includeLunch;
        }
        public boolean includeDinner(){
            return includeDinner;
        }
        public double getMonthlyPrice(){
            return monthlyPrice;
        }
        public Date getJoinDate(){
            return joinDate;
        }

        //setters method used to write the private object properties.
        public void setIncludeLunch(boolean includeLunch){
            this.includeLunch=includeLunch;
        }
        public void setIncludeDinner(boolean includeDinner){
            this.includeDinner=includeDinner;
        }
        public void setMonthlyPrice(double monthlyPrice){
            this.monthlyPrice=monthlyPrice;
        }



        }


    

