import java.util.*;

public class AddingAngles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfAngles = Integer.parseInt(scanner.nextLine());
        String[] angles = scanner.nextLine().split("\\s+");
        List<String> sets = new ArrayList<>();

        int index = 0;

        while (index < angles.length) {
            int firstAngle = Integer.parseInt(angles[index]);
            for (int i = index + 1; i < angles.length - 1; i++) {
                int secondAngle = Integer.parseInt(angles[i]);
                for (int j = i + 1; j < angles.length; j++) {
                    int thirdAngle = Integer.parseInt(angles[j]);
                    int sumOfAngles = firstAngle + secondAngle + thirdAngle;
                    if (sumOfAngles % 360 == 0) {
                        String set =
                                firstAngle + " + " + secondAngle + " + " + thirdAngle + " = " + sumOfAngles + " degrees";
                        sets.add(set);
                    }
                }
            }

            index++;
        }

        if(sets.size() > 0){
            for (String set : sets) {
                System.out.println(set);
            }
        } else {
            System.out.println("No");
        }

    }
}
