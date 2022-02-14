import java.time.LocalDate;

public class Admin extends Person{
    private String username;
    private String password;
    private boolean isAdmin = true;

    public Admin(String name, LocalDate DoB, Boolean isMale, String username, String password) {
        super(name, DoB, isMale);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdmin(){
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }
}
