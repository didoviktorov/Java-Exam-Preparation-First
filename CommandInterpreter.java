import java.lang.reflect.Array;
import java.util.*;

public class CommandInterpreter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if (array.length == 1) {
                System.out.println("Invalid input parameters.");
                break;
            }

            String[] commandArgs = command.split(" ");
            String action = commandArgs[0];

            switch (action) {
                case "reverse":
                    int startIndex = Integer.parseInt(commandArgs[2]);
                    int count = Integer.parseInt(commandArgs[4]);
                    if (isValidCommand(array, startIndex, count - 1)) {
                        array = reverseArray(array, startIndex, count);
                    } else {
                        System.out.println("Invalid input parameters.");
                    }
                    break;
                case "sort":
                    int start = Integer.parseInt(commandArgs[2]);
                    int countElements = Integer.parseInt(commandArgs[4]);
                    if (isValidCommand(array, start, countElements - 1)) {
                        array = sortArray(array, start, countElements);
                    } else {
                        System.out.println("Invalid input parameters.");
                    }
                    break;
                case "rollLeft":
                    int countTimes = Integer.parseInt(commandArgs[1]);
                    if (countTimes >= 0) {
                        array = rollLeft(array, countTimes);
                    } else {
                        System.out.println("Invalid input parameters.");
                    }
                    break;
                case "rollRight":
                    int times = Integer.parseInt(commandArgs[1]);
                    if (times >= 0) {
                        array = rollRight(array, times);
                    } else {
                        System.out.println("Invalid input parameters.");
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(Arrays.toString(array));
    }

    public static String[] rollRight(String[] array, int count) {
        int positionsToMove = count % array.length;

        for (int i = 0; i < positionsToMove; i++) {
            String last = array[array.length - 1];

            for (int j = array.length - 1; j >= 1; j--) {
                array[j] = array[j - 1];
            }

            array[0] = last;
        }

        return array;
    }

    public static String[] rollLeft(String[] array, int count) {
        int positionsToMove = count % array.length;

        for (int i = 0; i < positionsToMove; i++) {
            String temp = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }

            array[array.length - 1] = temp;
        }

        return array;
    }

    public static String[] sortArray(String[] array, int startIndex, int count) {
        String[] partArray = new String[count];
        int endIndex = startIndex + (count - 1);
        int currentIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (i >= startIndex && i <= endIndex) {
                partArray[currentIndex] = array[i];
                currentIndex++;
            }
        }

        Arrays.sort(partArray);

        currentIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (i >= startIndex && i <= endIndex) {
                array[i] = partArray[currentIndex];
                currentIndex++;
            }
        }

        return array;
    }

    public static String[] reverseArray(String[] array, int startIndex, int count) {
        String[] partArray = new String[count];
        int endIndex = startIndex + (count - 1);
        int currentIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (i >= startIndex && i <= endIndex) {
                partArray[currentIndex] = array[i];
                currentIndex++;
            }
        }

        for (int i = 0; i < partArray.length / 2; i++) {
            String element = partArray[i];
            partArray[i] = partArray[partArray.length - i - 1];
            partArray[partArray.length - i - 1] = element;
        }

        currentIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (i >= startIndex && i <= endIndex) {
                array[i] = partArray[currentIndex];
                currentIndex++;
            }
        }

        return array;
    }

    public static boolean isValidCommand(String[] array, int startIndex, int count) {
        if (startIndex < 0 || startIndex >= array.length || count < 0) {
            return false;
        } else if (count + startIndex >= array.length) {
            return false;
        }

        return true;
    }
}
