import java.util.Scanner;

public class MagicCard {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] hand = scanner.nextLine().trim().split(" ");
        String position = scanner.nextLine();
        String magicCard = scanner.nextLine();

        String magicFace = "";
        String magicSuit = "";
        int score = 0;
        if (magicCard.length() > 2) {
            magicFace += magicCard.charAt(0) + "" + magicCard.charAt(1);
            magicSuit += magicCard.charAt(2);
        } else {
            magicFace = "" + magicCard.charAt(0);
            magicSuit = "" + magicCard.charAt(1);
        }

        if (position.equals("odd")) {
            for (int i = 0; i < hand.length; i++) {
                int multiplier = 1;
                if (i % 2 != 0) {
                    String currentFace = "";
                    String currentSuit = "";
                    if (hand[i].length() > 2) {
                        currentFace += hand[i].charAt(0) + "" + hand[i].charAt(1);
                        currentSuit += hand[i].charAt(2);
                    } else {
                        currentFace += hand[i].charAt(0);
                        currentSuit += hand[i].charAt(1);
                    }


                    if (currentFace.equals(magicFace)) {
                        multiplier = 3;
                    } else if (currentSuit.equals(magicSuit)) {
                        multiplier = 2;
                    }

                    score += calculateHand(currentFace, multiplier);

                }
            }
        } else {
            for (int i = 0; i < hand.length; i++) {
                int multiplier = 1;
                if (i % 2 == 0) {
                    String currentFace = "";
                    String currentSuit = "";
                    if (hand[i].length() > 2) {
                        currentFace += hand[i].charAt(0) + "" + hand[i].charAt(1);
                        currentSuit += hand[i].charAt(2);
                    } else {
                        currentFace += hand[i].charAt(0);
                        currentSuit += hand[i].charAt(1);
                    }

                    if (currentFace.equals(magicFace)) {
                        multiplier = 3;
                    } else if (currentSuit.equals(magicSuit)) {
                        multiplier = 2;
                    }

                    score += calculateHand(currentFace, multiplier);
                }
            }
        }

        System.out.println(score);

    }

    private static int calculateHand(String cardFace, int multiplier) {
        int score = 0;
        switch (cardFace) {
            case "2":
                score += 20 * multiplier;
                break;
            case "3":
                score += 30 * multiplier;
                break;
            case "4":
                score += 40 * multiplier;
                break;
            case "5":
                score += 50 * multiplier;
                break;
            case "6":
                score += 60 * multiplier;
                break;
            case "7":
                score += 70 * multiplier;
                break;
            case "8":
                score += 80 * multiplier;
                break;
            case "9":
                score += 90 * multiplier;
                break;
            case "10":
                score += 100 * multiplier;
                break;
            case "J":
                score += 120 * multiplier;
                break;
            case "Q":
                score += 130 * multiplier;
                break;
            case "K":
                score += 140 * multiplier;
                break;
            case "A":
                score += 150 * multiplier;
                break;
        }

        return score;
    }
}
