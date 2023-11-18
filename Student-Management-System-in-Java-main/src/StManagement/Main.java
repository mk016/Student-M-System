package StManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Student student = new Student();
        boolean loggedIn = false;

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Create a User");
            System.out.println("2. Login into an existing user");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    user.createUser();
                    break;
                case 2:
                    loggedIn = user.loginUser();
                    if (loggedIn) {
                        System.out.println("Login successful.");
                    } else {
                        System.out.println("Login failed. Incorrect username or password.");
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }

            if (loggedIn) {
                while (true) {
                    System.out.println("\nStudent Management System");
                    System.out.println("1. Add a Student");
                    System.out.println("2. Remove a Student");
                    System.out.println("3. Get details of a Student");
                    System.out.println("4. View all student data");
                    System.out.println("5. Logout");
                    System.out.print("Enter your choice: ");

                    int innerChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline character

                    switch (innerChoice) {
                        case 1:
                            student.addStudent();
                            break;
                        case 2:
                            student.removeStudent();
                            break;
                        case 3:
                            student.getStudentDetails();
                            break;
                        case 4:
                            student.viewAllStudents();
                            break;
                        case 5:
                            loggedIn = false;
                            System.out.println("Logged out.");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }

                    if (!loggedIn) {
                        break;
                    }
                }
            }
        }
    }
}
