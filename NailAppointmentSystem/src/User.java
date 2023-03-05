public class User {

    private boolean loggedIn;
    private String nama;
    private String password;

    public User() {
        loggedIn = false;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn (boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

}
