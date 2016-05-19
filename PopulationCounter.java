import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("report")) {
            String[] info = line.split("\\|");
            String country = info[1];
            String city = info[0];
            long population = Long.parseLong(info[2]);

            if (!countries.containsKey(country)) {
                countries.put(country, new LinkedHashMap<>());
                countries.get(country).put(city, population);
            } else if (!countries.get(country).containsKey(city)) {
                countries.get(country).put(city, population);
            } else {
                countries.get(country).put(city, countries.get(country).get(city) + population);
            }

            line = scanner.nextLine();
        }

        LinkedHashMap<String, LinkedHashMap<String, Long>> sortedCountries = countries
                        .entrySet()
                        .stream()
                        .sorted((firstCountry, secondCountry) ->
                                getPopulation(secondCountry.getValue()).compareTo(getPopulation(firstCountry.getValue())))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (x, y) -> {
                                    throw new AssertionError();
                                },
                                LinkedHashMap::new
                        ));

        for (Map.Entry<String, LinkedHashMap<String, Long>> country : sortedCountries.entrySet()) {
            System.out.printf("%s (total population: %d)%n", country.getKey(), getPopulation(country.getValue()));

            LinkedHashMap<String, Long> sortedCities = country.getValue()
                            .entrySet()
                            .stream()
                            .sorted((city1, city2) -> city2.getValue().compareTo(city1.getValue()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (x, y) -> {
                                throw new AssertionError();
                            },
                            LinkedHashMap::new
                    ));

            for (Map.Entry<String, Long> city : sortedCities.entrySet()) {
                System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
            }
        }
    }

    public static Long getPopulation(LinkedHashMap<String, Long> country) {
        long population = 0;
        for (Map.Entry<String, Long> city : country.entrySet()) {
            population += city.getValue();
        }

        return population;
    }
}
