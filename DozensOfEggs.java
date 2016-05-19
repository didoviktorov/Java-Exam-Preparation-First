import java.util.Scanner;

public class DozensOfEggs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfLines = 7;

        int countEggs = 0;
        for (int i = 0; i < numberOfLines; i++) {
            String[] numberOfEggs = scanner.nextLine().trim().split("\\s+");
            int quantity = Integer.parseInt(numberOfEggs[0]);
            String measure = numberOfEggs[1];

            switch (measure) {
                case "dozens":
                    countEggs += quantity * 12;
                    break;
                default:
                    countEggs += quantity;
                    break;
            }
        }

        System.out.printf("%d dozens + %d eggs%n", countEggs / 12, countEggs % 12);
    }
}
