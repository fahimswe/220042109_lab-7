public class PowerUser extends User {

    public PowerUser(String userId, String username, String email, String password) {
        super(userId, username, email, password, "Power");
    }

    @Override
    public void accessPrivileges() {
        System.out.println("Power User: Read and write access to User.csv.");
    }

    public void addUser(String newUserDetails) {
        System.out.println("Adding user: " + newUserDetails);
        // Code to append newUserDetails to User.csv
    }
}
