import java.util.Scanner;

public class MarksProcessor {

    // Grade from an average
    public static char calculateGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else {
            return 'F';
        }
    }

    // Overload: grade from total marks and number of subjects
    public static char calculateGrade(double total, int numSubjects) {
        double average = total / numSubjects;
        return calculateGrade(average);
    }

    public static void main(String[] args) {
        final int SUBJECTS = 5;
        Scanner scanner = new Scanner(System.in);
        double[] marks = new double[SUBJECTS];

        for (int i = 0; i < SUBJECTS; i++) {
            System.out.print("Enter mark for subject " + (i + 1) + ": ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input - Marks must be numeric values.");
                scanner.close();
                return;
            }
            marks[i] = scanner.nextDouble();
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid input - Marks must be between 0 and 100 (inclusive)");
                scanner.close();
                return;
            }
        }
        scanner.close();

        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        double average = total / SUBJECTS;

        System.out.println();
        System.out.println("Total marks   : " + total);
        System.out.printf("Average marks : %.2f%n", average);
        System.out.println("Grade (from average)        : " + calculateGrade(average));
        System.out.println("Grade (from total, subjects): " + calculateGrade(total, SUBJECTS));
    }
}
