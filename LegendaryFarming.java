import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {

        int legendaryPrice = 250;

        TreeMap<String, Integer> keyItems = new TreeMap<>();
        keyItems.put("fragments", 0);
        keyItems.put("motes", 0);
        keyItems.put("shards", 0);

        TreeMap<String, Integer> junkItems = new TreeMap<>();

        String firstCollected = "";
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        while (true) {
            for (int i = 1; i < line.length; i += 2) {
                int quantity = Integer.parseInt(line[i - 1]);
                String item = line[i].toLowerCase();

                if (keyItems.containsKey(item)) {
                    keyItems.put(item, keyItems.get(item) + quantity);

                    if (keyItems.get(item) >= legendaryPrice) {
                        keyItems.put(item, keyItems.get(item) - legendaryPrice);
                        firstCollected = item;
                        break;
                    }

                } else {
                    if (!junkItems.containsKey(item)) {
                        junkItems.put(item, 0);
                    }
                    junkItems.put(item, junkItems.get(item) + quantity);
                }
            }

            if (firstCollected.length() > 0) {
                break;
            } else {
                line = scanner.nextLine().split(" ");
            }
        }

        if (firstCollected.equals("shards")) {
            System.out.println("Shadowmourne obtained!");
        } else if (firstCollected.equals("motes")) {
            System.out.println("Dragonwrath obtained!");
        } else {
            System.out.println("Valanyr obtained!");
        }

        keyItems.entrySet().stream()
                .sorted((key1, key2) -> key2.getValue().compareTo(key1.getValue()))
                .forEach(pair -> System.out.printf("%s: %d%n", pair.getKey(), pair.getValue()));

        junkItems.entrySet().stream()
                .forEach(pair -> System.out.printf("%s: %d%n", pair.getKey(), pair.getValue()));
    }
}
