import javafx.beans.property.IntegerProperty;

import java.util.Arrays;
import java.util.Scanner;

public class RubikMatrix {
    static int[][] rubikMatrix;
    static int[][] origMatrix;
    static int rows;
    static int cols;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        rows = dimensions[0];
        cols = dimensions[1];

        rubikMatrix = new int[rows][cols];
        origMatrix = new int[rows][cols];

        int valueTofill = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rubikMatrix[i][j] = valueTofill;
                origMatrix[i][j] = valueTofill;
                valueTofill++;
            }
        }

        int numberOfRows = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfRows; i++) {
            String[] line = scanner.nextLine().split("\\s+");

            int elementToShift = Integer.parseInt(line[0]);
            String direction = line[1];
            int moves = Integer.parseInt(line[2]);

            if (direction.equals("up")) {
                shiftUp(elementToShift, moves);
            } else if (direction.equals("down")) {
                shiftDown(elementToShift, moves);
            } else if (direction.equals("left")) {
                shiftLeft(elementToShift, moves);
            } else {
                shiftRight(elementToShift, moves);
            }
        }

        rearrangeMatrix();
    }

    private static void rearrangeMatrix() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rubikMatrix[r][c] == origMatrix[r][c]) {
                    System.out.println("No swap required");
                } else {
                    int numberToSwap = origMatrix[r][c];
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            if (rubikMatrix[i][j] == numberToSwap) {
                                System.out.printf("Swap (%d, %d) with (%d, %d)%n", r, c, i, j);
                                rubikMatrix[i][j] = rubikMatrix[r][c];
                                rubikMatrix[r][c] = numberToSwap;

                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(rubikMatrix[i]));
        }
    }

    private static void shiftRight(int elementToShift, int moves) {
        moves %= cols;
        for (int i = 0; i < moves; i++) {
            int temp = rubikMatrix[elementToShift][cols - 1];
            for (int j = cols - 1; j > 0; j--) {
                rubikMatrix[elementToShift][j] = rubikMatrix[elementToShift][j - 1];
            }

            rubikMatrix[elementToShift][0] = temp;
        }

    }

    private static void shiftLeft(int elementToShift, int moves) {
        moves %= cols;
        for (int i = 0; i < moves; i++) {
            int temp = rubikMatrix[elementToShift][0];
            for (int j = 1; j < cols; j++) {
                rubikMatrix[elementToShift][j - 1] = rubikMatrix[elementToShift][j];
            }

            rubikMatrix[elementToShift][cols - 1] = temp;
        }
    }

    private static void shiftDown(int elementToShift, int moves) {
        moves %= rows;
        for (int i = 0; i < moves; i++) {
            int temp = rubikMatrix[rows - 1][elementToShift];
            for (int j = rows - 1; j > 0; j--) {
                rubikMatrix[j][elementToShift] = rubikMatrix[j - 1][elementToShift];
            }

            rubikMatrix[0][elementToShift] = temp;
        }
    }

    private static void shiftUp(int elementToShift, int moves) {
        moves %= rows;
        for (int i = 0; i < moves; i++) {
            int temp = rubikMatrix[0][elementToShift];
            for (int j = 1; j < rows; j++) {
                rubikMatrix[j - 1][elementToShift] = rubikMatrix[j][elementToShift];
            }

            rubikMatrix[rows - 1][elementToShift] = temp;
        }
    }
}
