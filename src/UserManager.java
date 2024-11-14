import java.io.*;
import java.util.*;

public class UserManager {
    private static final String USER_FILE = "User.csv";
    private static final String ADMIN_FILE = "Admin.csv";
    private List<User> users = new ArrayList<>();

    public UserManager() {
        loadUsers();
    }

    public void loadUsers() {
        // Load users from User.csv
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                User user;
                switch (details[4]) {
                    case "Admin":
                        user = new AdminUser(details[0], details[1], details[2], details[3]);
                        break;
                    case "Power":
                        user = new PowerUser(details[0], details[1], details[2], details[3]);
                        break;
                    default:
                        user = new RegularUser(details[0], details[1], details[2], details[3]);
                        break;
                }
                users.add(user);
            }
        } catch (IOException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
    }

    public User authenticateUser(String username, String password, String newUserDetails) {
        for (User user : users) {
            if (user.getUsername(newUserDetails).equals(username) && user.authenticate(password)) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args, String newUserDetails) {
        UserManager manager = new UserManager();
        User user = manager.authenticateUser("adminUser", "password123", newUserDetails);
        if (user != null) {
            user.accessPrivileges();
        } else {
            System.out.println("Authentication failed.");
        }
    }
}
