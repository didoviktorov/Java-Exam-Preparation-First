import javafx.beans.binding.StringBinding;

import java.util.Scanner;

public class Enigma {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countLines = scanner.nextInt();
        scanner.nextLine();

        while (countLines > 0) {
            String line = scanner.nextLine();

            int lenght = line.length();

            for (int i = 0; i < line.length(); i++) {
                if (Character.isWhitespace(line.charAt(i)) || Character.isDigit(line.charAt(i))) {
                    lenght--;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (!(Character.isWhitespace(symbol)) && !(Character.isDigit(symbol))) {
                    sb.append((char)(line.charAt(i) + lenght / 2));
                } else {
                    sb.append(line.charAt(i));
                }
            }

            System.out.println(sb.toString());
            countLines--;
        }
    }
}
