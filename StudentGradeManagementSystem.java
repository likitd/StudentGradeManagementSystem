import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int[] marks = new int[3];
    double average;
    char grade;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        calculateAverage();
        assignGrade();
    }

    private void calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        this.average = total / 3.0;
    }

    private void assignGrade() {
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 75) {
            grade = 'B';
        } else if (average >= 60) {
            grade = 'C';
        } else {
            grade = 'D';
        }
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks[0] + ", " + marks[1] + ", " + marks[2]);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("--------------------------------");
    }
}

public class StudentGradeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Management System ===");

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();

            int[] marks = new int[3];
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter mark " + (j + 1) + ": ");
                marks[j] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume newline

            students.add(new Student(name, marks));
        }

        System.out.println("\n=== Student Results ===");
        for (Student student : students) {
            student.displayDetails();
        }

        scanner.close();
    }
}
