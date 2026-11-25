import java.util.Scanner;

public class MarksProcessor {

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

    public static char calculateGrade(double total, int numSubjects) {
        return calculateGrade(total / numSubjects);
    }

    // Description for each grade, chosen with a switch
    public static String describeGrade(char grade) {
        switch (grade) {
            case 'A':
                return "Excellent performance";
            case 'B':
                return "Very good performance";
            case 'C':
                return "Satisfactory performance";
            default:
                return "Unsatisfactory performance";
        }
    }

    public static void main(String[] args) {
        final int SUBJECTS = 5;
        Scanner scanner = new Scanner(System.in);
        double total = 0;                       // visible only inside main

        for (int i = 1; i <= SUBJECTS; i++) {   // i exists only inside this loop
            System.out.print("Enter mark for subject " + i + ": ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input - Marks must be numeric values.");
                scanner.close();
                return;
            }
            double mark = scanner.nextDouble(); // mark exists only inside this iteration
            if (mark < 0 || mark > 100) {
                System.out.println("Invalid input - Marks must be between 0 and 100 (inclusive)");
                scanner.close();
                return;
            }
            total += mark;
        }
        scanner.close();

        double average = total / SUBJECTS;
        char grade = calculateGrade(average);

        System.out.println();
        System.out.println("===== Student Result =====");
        System.out.println("Total marks : " + total + " out of " + (SUBJECTS * 100));
        System.out.printf("Average     : %.2f%n", average);
        System.out.println("Grade       : " + grade + " (" + describeGrade(grade) + ")");
        System.out.println("==========================");
    }
}
