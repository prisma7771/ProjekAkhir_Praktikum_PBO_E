package Main;

public class Akun {

    private String email;
    private String username;
    private String usernameadmin;

    public Akun(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public Akun(String usernameadmin) {
        this.usernameadmin = usernameadmin;
    }

    public String getUsernameadmin() {
        return usernameadmin;
    }

    public String getEmail() {
        return email;
    }

    public String getusername() {
        return username;
    }
}
