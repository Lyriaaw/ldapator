
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import org.json.JSONException;


public class TestLDAP extends TimerTask{

    @Override
    public void run() {
        RetrieveData Connection = new RetrieveData();
        List<Student> Student = null;
        try {
            Student = Connection.retreive();
        } catch (NamingException ex) {
            Logger.getLogger(TestLDAP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestLDAP.class.getName()).log(Level.SEVERE, null, ex);
        }
        SendData Send=new SendData();
        try {
            Send.SendData(Student);
        } catch (JSONException ex) {
            Logger.getLogger(TestLDAP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestLDAP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestLDAP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}





