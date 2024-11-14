import java.util.Objects;

public abstract class User {
    protected String userId;
    protected String username;
    protected String email;
    protected String password;
    protected String userType;

    public User(String userId, String username, String email, String password, String userType) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername(String newUserDetails) {
        return username;
    }

    public boolean authenticate(String password) {
        return Objects.equals(this.password, password);
    }

    public abstract void accessPrivileges();

    @Override
    public String toString() {
        return userId + "," + username + "," + email + "," + password + "," + userType;
    }
}
