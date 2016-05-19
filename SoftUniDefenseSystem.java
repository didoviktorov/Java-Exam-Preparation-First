import java.util.*;
import java.util.regex.*;

public class SoftUniDefenseSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentLiters = 0;
        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]*?[A-Z]).*?([0-9]+L)");
        Matcher matcher;
        while (!line.equals("OK KoftiShans")) {
            matcher = pattern.matcher(line);
            while (matcher.find()) {
                String name = matcher.group(1);
                String type = matcher.group(2).toLowerCase();
                String litters = matcher.group(3).substring(0, matcher.group(3).length() - 1);
                int quantity = Integer.parseInt(litters);
                System.out.printf("%s brought %d liters of %s!%n", name, quantity, type);
                currentLiters += quantity;
            }

            line = scanner.nextLine();
        }

        System.out.printf("%.3f softuni liters%n", currentLiters / 1000);
    }
}
