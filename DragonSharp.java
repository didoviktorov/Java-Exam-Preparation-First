import java.util.*;
import java.util.regex.*;

public class DragonSharp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfLines = scanner.nextInt();
        scanner.nextLine();

        boolean error = false;
        int errorLine = 0;
        boolean previousLineFalse = false;
        List<String> linesToPrint = new ArrayList<>();

        String pattern = "\"(.*)\";";
        Pattern path = Pattern.compile(pattern);

        for (int i = 1; i < numberOfLines + 1; i++) {
            String line = scanner.nextLine();
            Matcher matcher = path.matcher(line);
            if (matcher.find()) {
                String toPrint = matcher.group(1);
                line = line.substring(0, line.indexOf(toPrint));
                String[] conditions = line.split(" ");
                if (conditions[0].equals("if")) {
                    if (ifTrue(conditions[1])) {
                        if (conditions.length > 4) {
                            int index = Integer.parseInt(conditions[3]);
                            for (int j = 0; j < index; j++) {
                                linesToPrint.add(toPrint);
                            }

                            previousLineFalse = false;
                        } else {
                            linesToPrint.add(toPrint);
                            previousLineFalse = false;
                        }
                    }else {
                        previousLineFalse = true;
                    }
                } else if(conditions[0].equals("else") && previousLineFalse == true){
                    if (conditions.length > 3) {
                        int index = Integer.parseInt(conditions[2]);
                        for (int j = 0; j < index; j++) {
                            linesToPrint.add(toPrint);
                        }

                        previousLineFalse = false;
                    } else {
                        linesToPrint.add(toPrint);
                        previousLineFalse = false;
                    }
                }
            } else {
                errorLine = i;
                error = true;
                break;
            }
        }

        if (error) {
            System.out.printf("Compile time error @ line %d%n", errorLine);
        } else {
            for (String str : linesToPrint) {
                System.out.println(str);
            }
        }
    }

    private static boolean ifTrue(String condition) {
        boolean ifTrue = false;
        String check = condition.substring(1, condition.length() - 1);
        String firstNumber = "";
        String secondNumber = "";
        String equation = "";
        boolean endFirstNum = false;
        for (int i = 0; i < check.length(); i++) {
            if (Character.isDigit(check.charAt(i)) && endFirstNum == false) {
                firstNumber += check.charAt(i);
            } else if (Character.isDigit(check.charAt(i)) && endFirstNum == true) {
                secondNumber += check.charAt(i);
            } else {
                equation += check.charAt(i);
                endFirstNum = true;
            }
        }

        long firstNum = Long.parseLong(firstNumber);
        long secondNum = Long.parseLong(secondNumber);
        switch (equation) {
            case "==":
                ifTrue = firstNum == secondNum;
                break;
            case ">":
                ifTrue = firstNum > secondNum;
                break;
            case "<":
                ifTrue = firstNum < secondNum;
                break;
        }

        return ifTrue;
    }
}
