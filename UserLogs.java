import java.util.*;
import java.util.regex.*;

public class UserLogs {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        Pattern pattern = Pattern.compile("IP=(.*?)\\s+.*user=(.+)");
        Matcher matcher;

        String line = scn.nextLine();
        while (!line.equals("end")) {
            matcher = pattern.matcher(line);
            if (matcher.find()) {
                String user = matcher.group(2);
                String ip = matcher.group(1);

                if (!userLogs.containsKey(user)) {
                    userLogs.put(user, new LinkedHashMap<>());
                    userLogs.get(user).put(ip, 0);
                } else if(!userLogs.get(user).containsKey(ip)){
                    userLogs.get(user).put(ip, 0);
                }

                userLogs.get(user).put(ip, userLogs.get(user).get(ip) + 1);
            }

            line = scn.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : userLogs.entrySet()) {
            System.out.println(user.getKey() + ":");
            List<String> logs = new ArrayList<>();
            for (Map.Entry ipPair : userLogs.get(user.getKey()).entrySet()) {
                logs.add(ipPair.getKey() + " => " + ipPair.getValue());
            }

            System.out.println(String.join(", ", logs) + ".");
        }

    }
}
