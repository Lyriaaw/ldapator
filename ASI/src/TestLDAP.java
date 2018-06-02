
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.naming.NamingException;
import org.json.JSONException;


public class TestLDAP {

    public static void main(String[] args) throws NamingException, JSONException, UnsupportedEncodingException, FileNotFoundException, IOException {

        RetrieveData Connection = new RetrieveData();
        List<Student> Student= Connection.retreive();
        SendData Send=new SendData();
        Send.SendData(Student);

    }
}





