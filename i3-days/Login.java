
import java.util.Scanner;

public class Login {

    private static boolean isLoggedIn = false;

    public static boolean performLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // In a real system, you would check the entered credentials against a database.
        // For simplicity, let's assume a fixed username and password.
        if ("admin".equals(username) && "password123".equals(password)) {
            isLoggedIn = true;
            System.out.println("Login successful!");
            return true;
        } else {
            isLoggedIn = false;
            System.out.println("Login failed. Please check your credentials.");
            return false;
        }
    }
}
