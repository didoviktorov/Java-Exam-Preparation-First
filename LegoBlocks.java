import java.util.Scanner;

public class LegoBlocks {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int rows = Integer.parseInt(scn.nextLine());

        int totalNumberOfCells = 0;
        int fitLenght = 0;
        boolean isFit = true;

        String[][] jagged = new String[rows][];

        for (int i = 0; i < rows; i++) {
            String[] first = scn.nextLine().replaceAll("\\s+", " ").trim().split(" ");

            jagged[i] = new String[first.length];
            for (int j = 0; j < first.length; j++) {
                jagged[i][j] = first[j];
            }

            totalNumberOfCells += first.length;
        }

        for (int i = 0; i < rows; i++) {
            String[] second = scn.nextLine().replaceAll("\\s+", " ").trim().split(" ");
            int currentMaxLenght = jagged[i].length + second.length;
            if (i == 0) {
                fitLenght = jagged[i].length + second.length;
            }

            String[] reversed = new String[second.length];
            int reversedIndex = 0;
            for (int j = second.length - 1; j >= 0; j--) {
                reversed[reversedIndex] = second[j];
                reversedIndex++;
            }
            String[] newLine = new String[currentMaxLenght];
            int index = 0;
            for (int j = 0; j < currentMaxLenght; j++) {
                if (j < currentMaxLenght - reversed.length) {
                    newLine[j] = jagged[i][j];
                } else {
                    newLine[j] = reversed[index];
                    index++;
                }
            }

            jagged[i] = new String[currentMaxLenght];
            for (int j = 0; j < currentMaxLenght; j++) {
                jagged[i][j] = newLine[j];
            }
            if (i != 0 && currentMaxLenght != fitLenght) {
                isFit = false;
            }
            totalNumberOfCells += second.length;
        }

        if (isFit) {
            for (int i = 0; i < rows; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("[" + String.join(", ", jagged[i]) + "]");
                System.out.println(sb.toString());
            }
        } else {
            System.out.println("The total number of cells is: " + totalNumberOfCells);
        }
    }
}
