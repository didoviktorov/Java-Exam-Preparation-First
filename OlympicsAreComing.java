import java.util.*;
import java.util.stream.Collectors;

public class OlympicsAreComing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> countries = new LinkedHashMap<>();

        String line = scanner.nextLine().trim();
        while (!line.equals("report")) {
            String[] infoLine = line.replaceAll("\\s+", " ").trim().split("\\|");
            String country = infoLine[1].trim();
            String athlete = infoLine[0].trim();

            if (!countries.containsKey(country)) {
                countries.put(country, new LinkedHashMap<>());
                countries.get(country).put(athlete, 0);
            } else if (!countries.get(country).containsKey(athlete)) {
                countries.get(country).put(athlete, 0);
            }

            countries.get(country).put(athlete, countries.get(country).get(athlete) + 1);

            line = scanner.nextLine().trim();
        }

        LinkedHashMap<String, LinkedHashMap<String, Integer>> sortedCountries = countries
                .entrySet()
                .stream()
                .sorted((country1, country2) ->
                        getWins(country2.getValue()).compareTo(getWins(country1.getValue()))
                )
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));

        for (Map.Entry<String, LinkedHashMap<String, Integer>> country : sortedCountries.entrySet()) {
            int wins = getWins(country.getValue());
            int participants = country.getValue().values().size();
            System.out.printf("%s (%d participants): %d wins%n", country.getKey(), participants, wins);
        }
    }

    public static Integer getWins(LinkedHashMap<String, Integer> athlete) {
        int sum = 0;

        for (Map.Entry<String, Integer> entry : athlete.entrySet()) {
            sum += entry.getValue();
        }

        return sum;
    }
}
