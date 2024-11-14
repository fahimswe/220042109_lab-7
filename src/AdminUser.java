public class AdminUser extends User {

    public AdminUser(String userId, String username, String email, String password) {
        super(userId, username, email, password, "Admin");
    }

    @Override
    public void accessPrivileges() {
        System.out.println("Admin User: Full access including system settings.");
    }

    public void updateUser(String userId, String updatedDetails) {
        System.out.println("Updating user: " + userId);
        // Code to modify user details in User.csv
    }

    public void renameFile(String oldName, String newName) {
        System.out.println("Renaming file from " + oldName + " to " + newName);
        // Code to rename files
    }
}
