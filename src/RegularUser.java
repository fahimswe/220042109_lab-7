public class RegularUser extends User {

    public RegularUser(String userId, String username, String email, String password) {
        super(userId, username, email, password, "Regular");
    }

    @Override
    public void accessPrivileges() {
        System.out.println("Regular User: Read-only access to User.csv.");
    }
}
