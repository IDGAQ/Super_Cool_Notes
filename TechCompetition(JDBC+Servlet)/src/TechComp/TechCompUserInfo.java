package TechComp;

public class TechCompUserInfo {
    String username;
    String password;
    String major;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMajor(){return major;}

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        String a;
        a = String.format("%-10s", username);
        a += String.format("%-10s", password);
        a += String.format("%-10s", major);
        return a;
    }
}
