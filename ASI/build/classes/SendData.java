
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;






        



public class SendData {
    
    
    
    public void SendData(List<Student> student) throws JSONException, UnsupportedEncodingException, FileNotFoundException, IOException{
        Properties prop=new Properties();
        FileReader reader=new FileReader("Configuration.properties");
        prop.load(reader);
        
        String url="https://636f2f83.ngrok.io/schools/users";
        
        HttpClient client=new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            post.setHeader("Content-Type","application/json");
        
        JSONArray Liste = new JSONArray();
        JSONObject TokenListe=new JSONObject();
        String Token=prop.getProperty("Token");
        TokenListe.accumulate("token",Token);
        for(int i=0;i<student.size();i++){
            
            
            JSONObject jsonObject=new JSONObject();
            jsonObject.accumulate("id",student.get(i).getUserId());
            jsonObject.accumulate("email",student.get(i).getemail());
            jsonObject.accumulate("password",student.get(i).getPassword());
            jsonObject.accumulate("surname",student.get(i).getSurname());
            jsonObject.accumulate("commonname",student.get(i).getCommonName());
            
            Liste.put(jsonObject);
            
            
           
            
        }
        
        TokenListe.put("students", Liste);
        String json = TokenListe.toString();
        StringEntity se= new StringEntity(json);
        System.out.println(TokenListe);
        post.setEntity(se);
        HttpResponse httpResponse=client.execute(post);
           
        
        
         
        
    }
}