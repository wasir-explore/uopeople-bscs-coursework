import java.util.Scanner;

public class MarksProcessor {
    public static void main(String[] args) {
        final int SUBJECTS = 5;
        Scanner scanner = new Scanner(System.in);
        double[] marks = new double[SUBJECTS];

        // Read and validate each mark; stop the program at the first bad entry
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

        // Second loop: total and average
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        double average = total / SUBJECTS;

        System.out.println();
        System.out.println("Total marks   : " + total);
        System.out.printf("Average marks : %.2f%n", average);
    }
}
