import java.util.*;

public class Weightlifting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLine = scanner.nextInt();
        scanner.nextLine();
        TreeMap<String, TreeMap<String, Long>> exercises = new TreeMap<>();

        for (int i = 0; i < numberOfLine; i++) {
            String[] info = scanner.nextLine().split(" ");
            String name = info[0];
            String exercise = info[1];
            long kilos = Long.parseLong(info[2]);

            if (!exercises.containsKey(name)) {
                exercises.put(name, new TreeMap<>());
                exercises.get(name).put(exercise, kilos);
            } else if (!exercises.get(name).containsKey(exercise)) {
                exercises.get(name).put(exercise, kilos);
            } else {
                exercises.get(name).put(exercise, exercises.get(name).get(exercise) + kilos);
            }
        }


        for (Map.Entry pair : exercises.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(pair.getKey() + " : ");
            List<String> exercisesToPrint = new ArrayList<>();

            for (Map.Entry str : exercises.get(pair.getKey()).entrySet()){
                StringBuilder sb1 = new StringBuilder();
                sb1.append(str.getKey() + " - ");
                sb1.append(str.getValue() + " kg");
                exercisesToPrint.add(sb1.toString());
            }

            sb.append(String.join(", ", exercisesToPrint));
            System.out.println(sb.toString());
        }
    }
}
