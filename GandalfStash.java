import java.util.Scanner;

public class GandalfStash {
    static int cramPoints = 2;
    static int lembasPoints = 3;
    static int applePoints = 1;
    static int melonPoints = 1;
    static int honeyCakePoints = 5;
    static int mushroomPoints = -10;
    static int otherPoints = -1;

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int startMood = Integer.parseInt(scn.nextLine());

        String[] food = scn.nextLine().replaceAll("([^A-Za-z]+)", "-").split("-");

        for (int i = 0; i < food.length; i++) {
            String cuurentFood = food[i].toLowerCase();
            switch (cuurentFood) {
                case "cram":
                    startMood += cramPoints;
                    break;
                case "lembas":
                    startMood += lembasPoints;
                    break;
                case "apple":
                    startMood += applePoints;
                    break;
                case "melon":
                    startMood += melonPoints;
                    break;
                case "honeycake":
                    startMood += honeyCakePoints;
                    break;
                case "mushrooms":
                    startMood += mushroomPoints;
                    break;
                default:
                    startMood += otherPoints;
                    break;
            }
        }

        if (startMood < -5) {
            System.out.printf("%d%nAngry%n", startMood);
        } else if (startMood >= -5 && startMood < 0) {
            System.out.printf("%d%nSad%n", startMood);
        } else if (startMood >= 0 && startMood <= 15) {
            System.out.printf("%d%nHappy%n", startMood);
        } else {
            System.out.printf("%d%nSpecial JavaScript mood%n", startMood);
        }
    }
}
