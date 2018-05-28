public class Idée {

    /*  public static void main(String[] args) {
        Hashtable env = new Hashtable();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=maxcrc,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "secret");

        DirContext dirContext;
        try {

            dirContext = new InitialDirContext(env);

            String searchFilter = "(objectClass=inetOrgPerson)";
            String[] requiredAttributes = {"uid", "userPassword", "givenName", "sn"};
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            controls.setReturningAttributes(requiredAttributes);





           *//* Attributes attributes = new BasicAttributes(true);
            Attributes attributs = dirContext.getAttributes("cn=Dupont,dc=test-ldap,dc=net");
            Attributs attribut = (Attribut) attributs.get("description") ;
            System.out.println("Description : " + attribut.get());
           // MonObjet objet = (MonObjet) dirContext.lookup("cn=Manager,dc=maxcrc,dc=com");
           // System.out.println("champ1="+objet.getChamp1());
            //System.out.println("champ2="+objet.getChamp2());
            dirContext.close();*//*
            System.out.println("OK");

        } catch (NamingException e) {
            System.err.println("Erreur lors de l'accès au serveur LDAP " + e);
            e.printStackTrace();
        }
        System.out.println("fin des traitements");
    }*/







    /*AJOUT DUN ELEMENT DANS ANNUAIRE*/

     /* Attributes attributes =new BasicAttributes();
                Attribute attribute = new BasicAttribute("objectClass");
                attribute.add("inetOrgPerson");
                attributes.put(attribute);
                Attribute sn=new BasicAttribute("sn");
                sn.add("Kappa");
                Attribute cn=new BasicAttribute("cn");
                cn.add("kappa");

                attributes.put(sn);
                attributes.put(cn);
                context.createSubcontext("uid=oui, ou=Sudent,o=Ecole,dc=maxcrc,dc=com",attributes);*/
}


