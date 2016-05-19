import java.util.*;
import java.util.regex.*;

public class TextTransformer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        while (!line.equals("burp")) {
            sb.append(line);
            line = scanner.nextLine();
        }

        String finalStr = sb.toString().replaceAll("\\s+", " ");

        StringBuilder result = new StringBuilder();
        Pattern regex = Pattern.compile("\\$(.+?)\\$|\\'(.+?)\\'|\\%(.+?)\\%|\\&(.+?)\\&");
        Matcher matcher = regex.matcher(finalStr);
        while (matcher.find()) {
            String match = matcher.group();
            char startingSymbol = match.charAt(0);

            StringBuilder stringToAdd = new StringBuilder();
            for (int i = 0; i < match.length(); i++) {
                if(i != 0 && i != match.length() - 1){
                    stringToAdd.append(match.charAt(i));
                }
            }

            match = stringToAdd.toString();
            stringToAdd = new StringBuilder();

            int weight = 0;
            switch (startingSymbol) {
                case '$':
                    weight = 1;
                    break;
                case '%':
                    weight = 2;
                    break;
                case '&':
                    weight = 3;
                    break;
                default:
                    weight = 4;
                    break;
            }

            for (int i = 0; i < match.length(); i++) {
                if (i % 2 != 0) {
                    stringToAdd.append((char)(match.charAt(i) - weight));
                } else {
                    stringToAdd.append((char)(match.charAt(i) + weight));
                }
            }

            result.append(stringToAdd.toString());
            result.append(" ");
        }

        System.out.println(result.toString());
    }
}
