import java.util.Scanner;
import java.util.regex.*;

public class WeirdScript {
    public static void main(String[] args) {

        int range = 52;
        Scanner scanner = new Scanner(System.in);
        int letterPosition = scanner.nextInt() % range;
        scanner.nextLine();

        String letter = "";
        if (letterPosition > 26) {
            letterPosition -= 26;
            letter = (char) (letterPosition + 64) + "";
        } else if (letterPosition == 0) {
            letterPosition = 26;
            letter = (char) (letterPosition + 64) + "";
        } else {
            letter = (char) (letterPosition + 96) + "";
        }

        String line = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        while (!line.equals("End")) {
            sb.append(line);
            line = scanner.nextLine();
        }

        String key = letter + letter;
        Pattern pattern = Pattern.compile(key + "(.*?)" + key);

        Matcher matcher = pattern.matcher(sb.toString());
        while (matcher.find()) {
            if (matcher.group(1).length() > 0) {
                System.out.println(matcher.group(1));
            }
        }
    }
}
