package StManagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private Map<String, String> users;

    public User() {
        this.users = new HashMap<>();
        // Predefined users
        initializePredefinedUsers();
    }

    private void initializePredefinedUsers() {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
        users.put("user4", "password4");
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        users.put(username, password);
        System.out.println("User created successfully.");
    }

    public boolean loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
