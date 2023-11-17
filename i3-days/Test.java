
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Test {

    private static List<User> userList = new ArrayList<>();
    private static List<Student> studentList = new ArrayList<>();
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Options:");
            System.out.println("1. Create User");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    isRunning = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }

    private static void createUser() {
        User newUser = User.createUser();
        userList.add(newUser);
        System.out.println("User created successfully!");
    }

    private static void login() {
        if (Login.performLogin()) {
            isLoggedIn = true;
            showLoggedInMenu();
        } else {
            isLoggedIn = false;
        }
    }

    private static void showLoggedInMenu() {
        Scanner scanner = new Scanner(System.in);

        while (isLoggedIn) {
            System.out.println("\nLogged In Options:");
            System.out.println("1. List of All Students");
            System.out.println("2. Add a Student");
            System.out.println("3. Delete a Student");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listAllStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    isLoggedIn = false;
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void listAllStudents() {
        System.out.println("\nList of All Students:");
        for (Student student : studentList) {
            System.out.println(student);
        }
        returnToMainPage();
    }

    private static void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student roll number: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter student address: ");
        String address = scanner.nextLine();

        System.out.print("Enter student subject: ");
        String subject = scanner.nextLine();

        Student newStudent = new Student(name, rollNo, address, subject);
        studentList.add(newStudent);

        System.out.println("Student added successfully!");
        returnToMainPage();
    }

    private static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the roll number of the student to delete: ");
        int rollNoToDelete = scanner.nextInt();

        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getRollNo() == rollNoToDelete) {
                iterator.remove();
                System.out.println("Student deleted successfully!");
                returnToMainPage();
                return;
            }
        }

        System.out.println("Student with Roll Number " + rollNoToDelete + " not found.");
        returnToMainPage();
    }

    private static void returnToMainPage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPress Enter to return to the main page...");
        scanner.nextLine();
    }

    static class Student {
        private String name;
        private int rollNo;
        private String address;
        private String subject;

        public Student(String name, int rollNo, String address, String subject) {
            this.name = name;
            this.rollNo = rollNo;
            this.address = address;
            this.subject = subject;
        }

        public int getRollNo() {
            return rollNo;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", rollNo=" + rollNo +
                    ", address='" + address + '\'' +
                    ", subject='" + subject + '\'' +
                    '}';
        }
    }
}
