import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class LogParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\"([A-Za-z]+)\":\\s*.+?\"([\\x00-\\x7F]+?)\"\\]");

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> logger = new LinkedHashMap<>();
        String logLine = scanner.nextLine();
        Matcher matcher;
        while (!logLine.equals("END")) {
            matcher = pattern.matcher(logLine);
            List<String> info = new ArrayList<>();
            while (matcher.find()) {
                info.add(matcher.group(1));
                info.add(matcher.group(2));
            }

            String projectName = info.get(1);
            String errorType = info.get(3);
            String message = info.get(5);

            if (!logger.containsKey(projectName)) {
                logger.put(projectName, new LinkedHashMap<>());
                logger.get(projectName).put("Critical", new ArrayList<>());
                logger.get(projectName).put("Warnings", new ArrayList<>());
            }

            if (errorType.equals("Critical")) {
                logger.get(projectName).get("Critical").add(message);
            } else {
                logger.get(projectName).get("Warnings").add(message);
            }
            logLine = scanner.nextLine();
        }

        scanner.close();

        logger.entrySet().stream()
                .sorted((e1, e2) -> {
                    int total2 = (e2.getValue().get("Critical").size() + e2.getValue().get("Warnings").size());
                    int total1 = (e1.getValue().get("Critical").size() + e1.getValue().get("Warnings").size());

                    if (total1 != total2) {
                        return Integer.compare(total2, total1);
                    }
                    return e1.getKey().compareTo(e2.getKey());
                })
                .forEach(pair -> {
                    System.out.println(pair.getKey() + ":");
                    ArrayList<String> criticals = pair.getValue().get("Critical");
                    ArrayList<String> warnings = pair.getValue().get("Warnings");
                    System.out.println("Total Errors: " + (criticals.size() + warnings.size()));
                    System.out.println("Critical: " + criticals.size());
                    System.out.println("Warnings: " + warnings.size());

                    System.out.println("Critical Messages:");
                    printList(criticals);
                    System.out.println("Warning Messages:");
                    printList(warnings);

                    System.out.println();
                });
    }

    private static void printList(ArrayList<String> list) {
        if (list.size() == 0) {
            System.out.println("--->None");
            return;
        }

        list.stream().sorted((el1, el2) -> {
            if (el1.length() != el2.length()) {
                return Integer.compare(el1.length(), el2.length());
            }
            return el1.compareTo(el2);
        }).forEach(el1 -> {
            System.out.println("--->" + el1);
        });
    }
}
