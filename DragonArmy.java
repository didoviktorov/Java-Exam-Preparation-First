import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        int defaultHealth = 250;
        int defaultDamage = 45;
        int defaultArmor = 10;

        LinkedHashMap<String, TreeMap<String, List<Integer>>> dragons = new LinkedHashMap();

        Scanner scn = new Scanner(System.in);
        int numberOfDragons = Integer.parseInt(scn.nextLine());

        for (int i = 0; i < numberOfDragons; i++) {
            String[] dragon = scn.nextLine().split(" ");
            String type = dragon[0];
            String name = dragon[1];
            int damage;
            int health;
            int armor;

            List<Integer> stats = new ArrayList<>();
            if (dragon[2].equals("null")) {
                damage = defaultDamage;
                stats.add(damage);
            } else {
                damage = Integer.parseInt(dragon[2]);
                stats.add(damage);
            }
            if (dragon[3].equals("null")) {
                health = defaultHealth;
                stats.add(health);
            } else {
                health = Integer.parseInt(dragon[3]);
                stats.add(health);
            }
            if (dragon[4].equals("null")) {
                armor = defaultArmor;
                stats.add(armor);
            } else {
                armor = Integer.parseInt(dragon[4]);
                stats.add(armor);
            }


            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
                dragons.get(type).put(name, stats);
            } else if (!dragons.get(type).containsKey(name)) {
                dragons.get(type).put(name, stats);
            } else {
                dragons.get(type).put(name, stats);
            }
        }

        for (Map.Entry dragonType : dragons.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(dragonType.getKey() + "::(");

            int numberOfDragonsCollected = 0;
            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmor = 0;
            List<String> linesToPrint = new ArrayList<>();
            for (Map.Entry dragon : dragons.get(dragonType.getKey()).entrySet()) {
                StringBuilder lineToAdd = new StringBuilder();
                lineToAdd.append("-" + dragon.getKey() + " -> damage: ");
                ArrayList<Integer> status = (ArrayList<Integer>) dragon.getValue();
                for (int i = 0; i < status.size(); i++) {
                    if (i == 0) {
                        averageDamage += status.get(i);
                        lineToAdd.append(status.get(i) + ", ");
                    } else if (i == 1) {
                        averageHealth += status.get(i);
                        lineToAdd.append("health: " + status.get(i) + ", ");
                    } else {
                        averageArmor += status.get(i);
                        lineToAdd.append("armor: " + status.get(i));
                    }
                }

                linesToPrint.add(lineToAdd.toString());

                numberOfDragonsCollected++;
            }

            averageDamage /= numberOfDragonsCollected;
            averageHealth /= numberOfDragonsCollected;
            averageArmor /= numberOfDragonsCollected;

            sb.append(String.format("%.2f/%.2f/%.2f)", averageDamage, averageHealth, averageArmor));
            System.out.println(sb.toString());
            for (String line : linesToPrint) {
                System.out.println(line);
            }
        }
    }
}
