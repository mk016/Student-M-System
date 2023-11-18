package StManagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;



public class Student {

    private HashMap<Integer, Map<String, String>> students;

    public Student() {
        this.students = new HashMap<>();
        addPredefinedStudents();
    }

    private void addPredefinedStudents() {
        addStudentWithDetails(1, "Monish", "26");
        addStudentWithDetails(2, "Charul", "80");
        addStudentWithDetails(3, "Alka", "46");
        addStudentWithDetails(4, "Budhesh", "30");
        addStudentWithDetails(5, "Dipti Lodha", "35");
    }

    private void addStudentWithDetails(int rollNumber, String name, String age) {
        Map<String, String> studentInfo = new HashMap<>();
        studentInfo.put("name", name);
        studentInfo.put("age", age);

        students.put(rollNumber, studentInfo);
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student's roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        // Check if the roll number already exists
        if (students.containsKey(rollNumber)) {
            System.out.println("Student roll number already exists, please try again!");
            return;  // Exit the method to avoid recursion
        }

        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student's age: ");
        String age = scanner.nextLine();

        Map<String, String> studentInfo = new HashMap<>();
        studentInfo.put("name", name);
        studentInfo.put("age", age);

        students.put(rollNumber, studentInfo);
        System.out.println("Student added successfully.");
    }

    public void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student's roll number to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (students.containsKey(rollNumber)) {
            students.remove(rollNumber);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void getStudentDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student's roll number");
        int searchKey = scanner.nextInt();

        for (Map.Entry<Integer, Map<String, String>> entry : students.entrySet()) {
            int rollNumber = entry.getKey();
            Map<String, String> studentInfo = entry.getValue();

            if (searchKey == rollNumber) {
                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Name: " + studentInfo.get("name"));
                System.out.println("Age: " + studentInfo.get("age"));
                return;
            }
        }
       System.out.println("Student not found.");
    }

    public void viewAllStudents() {
        for (Map.Entry<Integer, Map<String, String>> entry : students.entrySet()) {
            int rollNumber = entry.getKey();
            Map<String, String> studentInfo = entry.getValue();

            // Concatenate student information into a single line
            String[] studentDetails = {
                    "Roll Number: " + rollNumber,
                    "Name: " + studentInfo.get("name"),
                    "Age: " + studentInfo.get("age")
            };

            // Display the information as a single line
            System.out.println(Arrays.toString(studentDetails));
        }
    }
}
