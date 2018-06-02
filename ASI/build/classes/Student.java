public class Student {

    private String userId;
    private String password;
    private String commonName;
    private String surname;
    private String email;

    public Student(String userId, String password, String commonName, String surname, String email) {
        this.userId = userId;
        this.password = password;
        this.commonName = commonName;
        this.surname = surname;
        this.email = email;
    }
    
    public String getemail(){
        return email;
    }
    
    public void setemail(String email){
        this.email=email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

  


}
