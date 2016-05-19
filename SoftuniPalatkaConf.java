import java.util.Scanner;

public class SoftuniPalatkaConf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();
        scanner.nextLine();

        int numberOfLines = scanner.nextInt();
        scanner.nextLine();

        int beds = 0;
        int food = 0;
        for (int i = 0; i < numberOfLines; i++) {
            String[] arguments = scanner.nextLine().trim().split("\\s+");
            String type = arguments[2];
            int quantity = Integer.parseInt(arguments[1]);
            switch (type) {
                case "normal":
                    beds += quantity * 2;
                    break;
                case "firstClass":
                    beds += quantity * 3;
                    break;
                case "single":
                    beds += quantity * 1;
                    break;
                case "double":
                    beds += quantity * 2;
                    break;
                case "triple":
                    beds += quantity * 3;
                    break;
                case "musaka":
                    food += quantity * 2;
                    break;
            }
        }

        if (beds >= numberOfPeople) {
            System.out.printf("Everyone is happy and sleeping well. Beds left: %d%n", beds - numberOfPeople);
        } else {
            System.out.printf("Some people are freezing cold. Beds needed: %d%n", numberOfPeople - beds);
        }

        if (food >= numberOfPeople) {
            System.out.printf("Nobody left hungry. Meals left: %d%n", food - numberOfPeople);
        } else {
            System.out.printf("People are starving. Meals needed: %d%n", numberOfPeople - food);
        }
    }
}
