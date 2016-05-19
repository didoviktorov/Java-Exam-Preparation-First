import java.util.Scanner;

public class TinySporebat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int health = 5800;
        int glowcaps = 0;
        while (!line.equals("Sporeggar")) {
            char[] enemies = line.toCharArray();
            for (int i = 0; i < enemies.length; i++) {
                if (health <= 0) {
                    break;
                }

                char symbol = enemies[i];
                if (symbol == 'L') {
                    health += 200;
                } else if (Character.isDigit(symbol) && i == enemies.length - 1) {
                    String digit = symbol + "";
                    glowcaps += Integer.parseInt(digit);
                } else {
                    health -= symbol;
                }
            }

            line = scanner.nextLine();
        }

        int priceOfSporebat = 30;
        if (health > 0 && glowcaps >= priceOfSporebat) {
            System.out.printf("Health left: %d%n", health);
            System.out.printf("Bought the sporebat. Glowcaps left: %d%n", glowcaps - priceOfSporebat);
        } else if (health > 0 && priceOfSporebat > glowcaps) {
            System.out.printf("Health left: %d%n", health);
            System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.%n", priceOfSporebat - glowcaps);
        } else {
            System.out.printf("Died. Glowcaps: %d%n", glowcaps);
        }
    }
}
