import java.util.Scanner;

public class Main {
    public static void main(String[] args, String newUserDetails) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the User Management System");

        // User Login
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User loggedInUser = userManager.authenticateUser(username, password, newUserDetails);
        if (loggedInUser != null) {
            System.out.println("Login successful! Welcome, " + loggedInUser.getUsername(newUserDetails) + ".");
            loggedInUser.accessPrivileges();

            // Main Menu based on User Type
            if (loggedInUser instanceof RegularUser) {
                System.out.println("As a Regular User, you can only view data.");
                // Add code to display read-only information (e.g., list users)
            } else if (loggedInUser instanceof PowerUser) {
                PowerUser powerUser = (PowerUser) loggedInUser;
                System.out.println("You can add new users. Would you like to add a new user? (yes/no)");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("yes")) {
                    System.out.print("Enter new user details (UserID,Username,Email,Password,UserType): ");
                    newUserDetails = scanner.nextLine();
                    powerUser.addUser(newUserDetails);
                    System.out.println("User added successfully.");
                }
            } else if (loggedInUser instanceof AdminUser) {
                AdminUser adminUser = (AdminUser) loggedInUser;
                boolean exit = false;
                while (!exit) {
                    System.out.println("\nAdmin Menu:");
                    System.out.println("1. Add User");
                    System.out.println("2. Update User");
                    System.out.println("3. Rename File");
                    System.out.println("4. Exit");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    switch (choice) {
                        case 1:
                            System.out.print("Enter new user details (UserID,Username,Email,Password,UserType): ");
                            newUserDetails = scanner.nextLine();
                            adminUser.getUsername(newUserDetails);  // Admins can also add users
                            System.out.println("User added successfully.");
                            break;
                        case 2:
                            System.out.print("Enter User ID to update: ");
                            String userId = scanner.nextLine();
                            System.out.print("Enter updated user details: ");
                            String updatedDetails = scanner.nextLine();
                            adminUser.updateUser(userId, updatedDetails);
                            System.out.println("User updated successfully.");
                            break;
                        case 3:
                            System.out.print("Enter the current file name: ");
                            String oldName = scanner.nextLine();
                            System.out.print("Enter the new file name: ");
                            String newName = scanner.nextLine();
                            adminUser.renameFile(oldName, newName);
                            System.out.println("File renamed successfully.");
                            break;
                        case 4:
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            }
        } else {
            System.out.println("Invalid username or password.");
        }

        scanner.close();
        System.out.println("Thank you for using the User Management System.");
    }
}
