
import java.io.FileNotFoundException;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;

public class RetrieveData {
    public List<Student> retreive() throws NamingException, FileNotFoundException, IOException {
        Hashtable env = new Hashtable();
        Properties prop=new Properties();
        FileReader reader=new FileReader("Configuration.properties");
        prop.load(reader);
        
        String addresse=prop.getProperty("Addresse");
        String user=prop.getProperty("user");
        String Password=prop.getProperty("password");
        String rep=prop.getProperty("rep");
        

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, addresse);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, user);
        env.put(Context.SECURITY_CREDENTIALS, Password);

        DirContext context = new InitialDirContext(env);


        String searchFilter = "(objectClass=inetOrgPerson)";
        String[] requiredAttributes = {"entryid", "userPassword", "givenName", "sn", "mail"};
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(requiredAttributes);
        NamingEnumeration users=context.search(rep, searchFilter, controls);
        SearchResult searchResult=null;
        String uid=null;
        String password=null;
        String gV=null;
        String sn=null;
        String email=null;
        List<Student> ListStudent = new ArrayList<>();

        while(users.hasMore()){


            Student student = new Student(uid, password, gV, sn, email);
            searchResult=(SearchResult) users.next();
            Attributes attr=searchResult.getAttributes();
            student.setUserId(attr.get("entryid").get(0).toString()); 
            student.setPassword(new String((byte[])attr.get("userPassword").get(0)));
            student.setCommonName(attr.get("givenName").get(0).toString());
            student.setSurname(attr.get("sn").get(0).toString());
            student.setemail(attr.get("mail").get(0).toString());
            
            ListStudent.add(student);
            
            

        }
        
   
        return ListStudent;
        



    }


}
