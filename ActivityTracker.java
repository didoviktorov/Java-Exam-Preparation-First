import java.util.*;
import java.util.stream.Collectors;

public class ActivityTracker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<Integer, TreeMap<String, Integer>> tracker = new LinkedHashMap<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] activity = scanner.nextLine().split(" ");
            int month = Integer.parseInt(activity[0].replaceAll(".*\\/([0-9]{2})\\/.*", "$1"));
            String name = activity[1];
            int distance = Integer.parseInt(activity[2]);

            if (!tracker.containsKey(month)) {
                tracker.put(month, new TreeMap<>());
                tracker.get(month).put(name, distance);
            } else if (!tracker.get(month).containsKey(name)) {
                tracker.get(month).put(name, distance);
            } else {
                tracker.get(month).put(name, tracker.get(month).get(name) + distance);
            }
        }

        LinkedHashMap<Integer, TreeMap<String, Integer>> sortedTracker =
                tracker.entrySet().stream().sorted((el1, el2) -> el1.getKey().compareTo(el2.getKey()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (x, y) -> {
                                    throw new AssertionError();
                                },
                                LinkedHashMap::new
                        ));

        for (Map.Entry<Integer, TreeMap<String, Integer>> entry : sortedTracker.entrySet()) {
            List<String> values = new ArrayList<>();
            for (Map.Entry value : sortedTracker.get(entry.getKey()).entrySet()) {
                values.add(String.format("%s(%d)", value.getKey(), value.getValue()));
            }

            System.out.printf("%d: %s%n", entry.getKey(), String.join(", ", values));
        }
    }
}
