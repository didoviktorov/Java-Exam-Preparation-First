import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String[] line = scn.nextLine().split("[\\s]+");

        double totalSum = 0;
        for (int i = 0; i < line.length; i++) {
            double currentSum = 0;
            double firstLeterPosition = 0;
            double secondLeterPosition = 0;
            double number = Long.parseLong(line[i].substring(1, line[i].length() - 1));
            char first = line[i].charAt(0);
            char second = line[i].charAt(line[i].length() - 1);
            if (Character.isUpperCase(first)) {
                firstLeterPosition = first - 64;
                currentSum += number / firstLeterPosition;
            } else {
                firstLeterPosition = first - 96;
                currentSum += number * firstLeterPosition;
            }
            if (Character.isUpperCase(second)) {
                secondLeterPosition = second - 64;
                currentSum -= secondLeterPosition;
            } else {
                secondLeterPosition = second - 96;
                currentSum += secondLeterPosition;
            }

            totalSum += currentSum;
        }

        System.out.printf("%.2f%n", totalSum);
    }
}
