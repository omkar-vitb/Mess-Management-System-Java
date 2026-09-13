import java.sql.Date;


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
            this.includeLunch=includeDinner;
            this.includeDinner=includeDinner;
            this.monthlyPrice=monthlyPrice;
            this.joinDate=joinDate;
        }

        @Override 
        public String getDetails(){
            return "ID"+ serialNo+" | Name: "+ name +" | joined: "+ joinDate;
        }

        @Override
        public double calculateMonthlyCost(){
            return monthlyPrice;
        } 

        //Getters
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

        //setters
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


    

