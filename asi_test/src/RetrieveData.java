
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.List;
import java.util.ArrayList;

public class RetrieveData {
    public List<Student> retreive() throws NamingException {
        Hashtable env = new Hashtable();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=maxcrc,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "secret");

        DirContext context = new InitialDirContext(env);


        String searchFilter = "(objectClass=inetOrgPerson)";
        String[] requiredAttributes = {"uid", "userPassword", "givenName", "sn"};
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(requiredAttributes);
        NamingEnumeration users=context.search("ou=Sudent,o=Ecole,dc=maxcrc,dc=com", searchFilter, controls);
        SearchResult searchResult=null;
        String uid=null;
        String password=null;
        String gV=null;
        String sn=null;
        List<Student> ListStudent = new ArrayList<>();

        while(users.hasMore()){


            Student student = new Student(uid, password, gV, sn);
            searchResult=(SearchResult) users.next();
            Attributes attr=searchResult.getAttributes();

            student.setUserId(attr.get("uid").get(0).toString());
            student.setPassword(attr.get("userPassword").get(0).toString());
            student.setCommonName(attr.get("givenName").get(0).toString());
            student.setSurname(attr.get("sn").get(0).toString());


            ListStudent.add(student);

        }

        return ListStudent;



    }


}
