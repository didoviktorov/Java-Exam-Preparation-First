import java.util.Scanner;

public class LabyrinthDash {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        scanner.nextLine();
        int maxLineLenght = 0;
        String[] lines = new String[rows];
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            lines[i] = line;
            if (line.length() > maxLineLenght) {
                maxLineLenght = line.length();
            }
        }

        Character[][] labyrinth = new Character[rows][maxLineLenght];
        String format = "%-" + maxLineLenght + "s";
        for (int i = 0; i < rows; i++) {
            lines[i] = String.format(format, lines[i]);
            for (int j = 0; j < maxLineLenght; j++) {
                labyrinth[i][j] = lines[i].charAt(j);
            }
        }

        String moves = scanner.nextLine();
        int lives = 3;
        int totalMoves = 0;
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            switch (move) {
                case '>':
                    startCol++;
                    if (startCol == maxLineLenght || labyrinth[startRow][startCol] == ' ') {
                        System.out.println("Fell off a cliff! Game Over!");
                        totalMoves++;
                    } else if (labyrinth[startRow][startCol] == '|' || labyrinth[startRow][startCol] == '_') {
                        startCol--;
                        System.out.println("Bumped a wall.");
                    } else if (labyrinth[startRow][startCol] == '@' ||
                            labyrinth[startRow][startCol] == '#' ||
                            labyrinth[startRow][startCol] == '*') {
                        lives--;
                        totalMoves++;
                        if (lives > 0) {
                            System.out.printf("Ouch! That hurt! Lives left: %d%n", lives);
                        } else {
                            System.out.printf("Ouch! That hurt! Lives left: %d%n", lives);
                            System.out.println("No lives left! Game Over!");
                        }
                    } else if (labyrinth[startRow][startCol] == '$') {
                        lives++;
                        totalMoves++;
                        labyrinth[startRow][startCol] = '.';
                        System.out.printf("Awesome! Lives left: %d%n", lives);
                    } else {
                        totalMoves++;
                        System.out.println("Made a move!");
                    }
                    break;
                case '<':
                    startCol--;
                    if (startCol < 0 || labyrinth[startRow][startCol] == ' ') {
                        System.out.println("Fell off a cliff! Game Over!");
                        totalMoves++;
                    } else if (labyrinth[startRow][startCol] == '|' || labyrinth[startRow][startCol] == '_') {
                        startCol++;
                        System.out.println("Bumped a wall.");
                    } else if (labyrinth[startRow][startCol] == '@' ||
                            labyrinth[startRow][startCol] == '#' ||
                            labyrinth[startRow][startCol] == '*') {
                        lives--;
                        totalMoves++;
                        if (lives > 0) {
                            System.out.printf("Ouch! That hurt! Lives left: %d%n", lives);
                        } else {
                            System.out.printf("Ouch! That hurt! Lives left: %d%n", lives);
                            System.out.println("No lives left! Game Over!");
                        }
                    } else if (labyrinth[startRow][startCol] == '$') {
                        lives++;
                        totalMoves++;
                        labyrinth[startRow][startCol] = '.';
                        System.out.printf("Awesome! Lives left: %d%n", lives);
                    } else {
                        totalMoves++;
                        System.out.println("Made a move!");
                    }
                    break;
                case '^':
                    startRow--;
                    if (startRow < 0 || labyrinth[startRow][startCol] == ' ') {
                        System.out.println("Fell off a cliff! Game Over!");
                        totalMoves++;
                    } else if (labyrinth[startRow][startCol] == '|' || labyrinth[startRow][startCol] == '_') {
                        startRow++;
                        System.out.println("Bumped a wall.");
                    } else if (labyrinth[startRow][startCol] == '@' ||
                            labyrinth[startRow][startCol] == '#' ||
                            labyrinth[startRow][startCol] == '*') {
                        lives--;
                        totalMoves++;
                        if (lives > 0) {
                            System.out.printf("Ouch! That hurt! Lives left: %d%n", lives);
                        } else {
                            System.out.printf("Ouch! That hurt! Lives left: %d%n", lives);
                            System.out.println("No lives left! Game Over!");
                        }
                    } else if (labyrinth[startRow][startCol] == '$') {
                        lives++;
                        totalMoves++;
                        labyrinth[startRow][startCol] = '.';
                        System.out.printf("Awesome! Lives left: %d%n", lives);
                    } else {
                        totalMoves++;
                        System.out.println("Made a move!");
                    }
                    break;
                case 'v':
                    startRow++;
                    if (startRow == rows || labyrinth[startRow][startCol] == ' ') {
                        System.out.println("Fell off a cliff! Game Over!");
                        totalMoves++;
                    } else if (labyrinth[startRow][startCol] == '|' || labyrinth[startRow][startCol] == '_') {
                        startRow--;
                        System.out.println("Bumped a wall.");
                    } else if (labyrinth[startRow][startCol] == '@' ||
                            labyrinth[startRow][startCol] == '#' ||
                            labyrinth[startRow][startCol] == '*') {
                        lives--;
                        totalMoves++;
                        if (lives > 0) {
                            System.out.printf("Ouch! That hurt! Lives left: %d%n", lives);
                        } else {
                            System.out.printf("Ouch! That hurt! Lives left: %d%n", lives);
                            System.out.println("No lives left! Game Over!");
                        }
                    } else if (labyrinth[startRow][startCol] == '$') {
                        lives++;
                        totalMoves++;
                        labyrinth[startRow][startCol] = '.';
                        System.out.printf("Awesome! Lives left: %d%n", lives);
                    } else {
                        totalMoves++;
                        System.out.println("Made a move!");
                    }
                    break;
            }

            if(startRow < 0 ||
                    startRow == rows||
                    startCol == maxLineLenght ||
                    startRow < 0 ||
                    startCol < 0 ||
                    labyrinth[startRow][startCol] == ' ' ||
                    lives == 0){
                break;
            }
        }

        System.out.printf("Total moves made: %d%n", totalMoves);
    }
}
