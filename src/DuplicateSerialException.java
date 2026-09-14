// This java file helps in preventing in creatig two id's. whenevr anyone tries to enter a student id that already existes in the database this file helps in flagging out the problem instead of letting the entire system crash

public class DuplicateSerialException extends Exception {
    public DuplicateSerialException(String message){
        super(message);
    }
    
}
