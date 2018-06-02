import java.util.Date;
import java.util.Timer;


public class ServerLoop {
    public static void main(String[] args) {
        
        
        
        Timer timer;
        timer=new Timer();
        timer.schedule(new TestLDAP(),new Date(), 30000);
    }
    
}
